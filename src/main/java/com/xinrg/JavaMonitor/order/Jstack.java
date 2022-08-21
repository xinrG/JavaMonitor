package com.xinrg.JavaMonitor.order;

import com.xinrg.JavaMonitor.core.ExecuteCmd;
import com.xinrg.JavaMonitor.entity.JstackEntity;
import com.xinrg.JavaMonitor.util.ArrayUtil;
import com.xinrg.JavaMonitor.util.PathUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;


public class Jstack {
    private final static String prefix = "java.lang.Thread.State: ";

    /**
     * 线程的堆栈信息
     * @param id 进程id
     * @return
     */
    public static JstackEntity jstack(String id) {
        String s = ExecuteCmd.execute(new String[]{"jstack",id});
        int total = ArrayUtil.appearTimes(s,"nid=");
        int runnable = ArrayUtil.appearTimes(s,prefix+"RUNNABLE");
        int timed_waiting = ArrayUtil.appearTimes(s,prefix+"TIMED_WAITING");
        int waiting = ArrayUtil.appearTimes(s,prefix+"WAITING");
        int blocked = ArrayUtil.appearTimes(s,prefix+"BLOCKED");
        return new JstackEntity(id,total,runnable,timed_waiting,waiting,blocked);
    }
    /**
     * 导出线程快照
     * @param id
     * @return
     */
    public static String dump(String id) throws IOException {
        String path = PathUtil.getRootPath("dump/"+id+"_thread.txt");
        String s = ExecuteCmd.execute(new String[]{"jstack", id});
        File file = new File(path);
        FileUtils.write(file,s,Charset.forName("UTF-8"));
        return path;
    }
}
