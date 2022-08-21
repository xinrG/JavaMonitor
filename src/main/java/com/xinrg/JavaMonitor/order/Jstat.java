package com.xinrg.JavaMonitor.order;

import com.xinrg.JavaMonitor.core.ExecuteCmd;
import com.xinrg.JavaMonitor.entity.KVEntity;
import com.xinrg.JavaMonitor.util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Jstat {
    /**
     *
     * @param strings jstat命令 -options
     * @return KVEntity
     * @throws IOException
     */
    public static List<KVEntity> jstat(String[] strings) throws IOException {
        List<KVEntity> kvList = new ArrayList<>();
        String s = ExecuteCmd.execute(strings);
        if(s == null || s.length() == 0) {
            return null;
        }
        BufferedReader br = new BufferedReader(new StringReader(s));
        // 匹配空白符或制表符
        String[] keys = ArrayUtil.trim(br.readLine().split("\\s+|\t"));
        String[] values = ArrayUtil.trim(br.readLine().split("\\s+|\t"));
        if(strings[1].equals("-compiler")) {
            for(int i = 0; i < 4; i++) {
                kvList.add(new KVEntity(keys[i],values[i]));
            }
        } else {
            for(int i = 0; i < keys.length; i++) {
                kvList.add(new KVEntity(keys[i],values[i]));
            }
        }
        br.close();
        return kvList;
    }
    /**
     * 类装载信息
     * @param id 进程id
     * @return
     * @throws IOException
     */
    public static List<KVEntity> jstatClass(String id) throws IOException {
        //监视类装载、卸载数量、总空间以及类装载所耗费的时间
        List<KVEntity> jstat_Class = Jstat.jstat(new String[]{"jstat","-class",id});
        //输出JIT编译器编译过的方法、耗时等信息
        List<KVEntity> jstat_Compiler = Jstat.jstat(new String[]{"jstat","-compiler",id});
        jstat_Class.addAll(jstat_Compiler);
        return jstat_Class;
    }
    /**
     * 堆内存、方法区监控
     * @param id
     * @return
     */
    public static List<KVEntity> jstatGc(String id) throws IOException {
        //监视java堆状况、包括Eden区、survivor区、老年代、永久代等的容量、已用空间、GC时间等信息
        return Jstat.jstat(new String[]{"jstat","-gc",id});
    }
    /**
     * 百分比输出
     * @param id
     * @return
     * @throws IOException
     */
    public static List<KVEntity> jstatGcUtil(String id) throws IOException {
        return Jstat.jstat(new String[]{"jstat","-gcutil",id});
    }
}
