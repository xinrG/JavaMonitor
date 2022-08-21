package com.xinrg.JavaMonitor.timer.job;

import com.xinrg.JavaMonitor.entity.JpsEntity;
import com.xinrg.JavaMonitor.entity.JstackEntity;
import com.xinrg.JavaMonitor.entity.KVEntity;
import com.xinrg.JavaMonitor.order.Jps;
import com.xinrg.JavaMonitor.order.Jstack;
import com.xinrg.JavaMonitor.order.Jstat;
import com.xinrg.JavaMonitor.service.ClassService;
import com.xinrg.JavaMonitor.service.GcService;
import com.xinrg.JavaMonitor.service.ThreadService;
import com.xinrg.JavaMonitor.timer.util.TimeUtil;
import org.apache.commons.collections4.MapUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UpdateJob extends QuartzJobBean {
    private Logger logger = LoggerFactory.getLogger(UpdateJob.class);
    @Autowired
    private ClassService classService;
    @Autowired
    private GcService gcService;
    @Autowired
    private ThreadService threadService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.debug("Regularly updated data...");
        String date = TimeUtil.time();
        Map<String, JpsEntity> map = Jps.jps();
        logger.info("UpdateJob map={}", map);
        if (MapUtils.isEmpty(map)) {
            return;
        }
        Set<String> s = map.keySet();
        try {
            for (String pid : s) {
                //System.out.println(pid);
                JstackEntity jstackEntity = Jstack.jstack(pid);
                List<KVEntity> jstat_class = Jstat.jstatClass(pid);
                List<KVEntity> jstat_gc = Jstat.jstatGc(pid);
                //System.out.println("---");
                //写入线程堆栈
                threadService.insert(pid, date, jstackEntity);
                //写入类装载、卸载信息
                classService.insert(pid, date, jstat_class);
                //写入堆、方法区内存使用情况、gc次数等信息
                gcService.insert(pid, date, jstat_gc);
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
