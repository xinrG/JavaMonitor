package com.xinrg.JavaMonitor.timer.job;

import com.xinrg.JavaMonitor.service.ClassService;
import com.xinrg.JavaMonitor.service.GcService;
import com.xinrg.JavaMonitor.service.ThreadService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ClearJob extends QuartzJobBean {
    private Logger logger = LoggerFactory.getLogger(ClearJob.class);
    @Autowired
    private ClassService classService;
    @Autowired
    private GcService gcService;
    @Autowired
    private ThreadService threadService;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.debug("Clear all data on a regular basis");
        classService.clearAll();
        gcService.clearAll();
        threadService.clearAll();
    }
}
