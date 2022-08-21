package com.xinrg.JavaMonitor.order;

import com.xinrg.JavaMonitor.core.ExecuteCmd;
import com.xinrg.JavaMonitor.entity.JpsEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Jps {
    /**
     * key 进程id
     * value 进程name 参数
     */
    public static Map<String, JpsEntity> jps() {
        Map<String,JpsEntity> map = new HashMap<>();
        String s = ExecuteCmd.execute(new String[] {"jps","-l","-v"});
        if(s == null || s.length() == 0) {
            return null;
        }
        String[] lines = s.split("\n");
        for(String line : lines) {
            String[] arrLine = line.split("\\s+");
            String str = arrLine[1];
            //排除sun.tools进程
            if(str.contains("sun.tools")) {
                continue;
            }
            if(!str.substring(0,1).equals("-")) {
                String className = str;
                String smallName = str.contains(".")?str.substring(str.lastIndexOf(".")+1):str;
                List<String> params = Arrays.stream(arrLine).skip(2).collect(Collectors.toList());
                map.put(arrLine[0],new JpsEntity(className,smallName,params));
            } else {
                List<String> params = Arrays.stream(arrLine).skip(1).collect(Collectors.toList());
                map.put(arrLine[0],new JpsEntity(params));
            }
        }
        return map;
    }
}
