package com.xinrg.JavaMonitor.order;

import com.xinrg.JavaMonitor.core.ExecuteCmd;
import com.xinrg.JavaMonitor.util.PathUtil;

import java.io.File;

public class Jmap {
    /**
     * 导出堆快照
     * @param id
     * @return
     */
    public static String dump(String id) {
        String path = PathUtil.getRootPath("dump/"+id+"_heap.hprof");
        File file = new File(PathUtil.getRootPath("dump/"));
        if (!file.exists()){
            file.mkdirs();
        }
        ExecuteCmd.execute(new String[]{"jmap","-dump:format=b,file="+path, id});
        return path;
    }
}
