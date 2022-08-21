package com.xinrg.JavaMonitor.order;

import com.xinrg.JavaMonitor.core.ExecuteCmd;
import com.xinrg.JavaMonitor.entity.JinfoEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Jinfo {
    public static JinfoEntity info(String id) {
        String s = ExecuteCmd.execute(new String[]{"jinfo","-flags",id});
        if(!s.contains("successfully")) {
            return null;
        }
        String flags = "flags:";
        String command = "Command line:";
        int flagsIndex = s.indexOf(flags);
        int commandIndex = s.indexOf(command);
        // \\s表示 空格,回车,换行等空白符 +号表示一个或多个
        String[] nonDefault = s.substring(flagsIndex+flags.length(),commandIndex).split("\\s+");
        String[] strCommandLine = null;
        List<String> commandLine = new ArrayList<>();
        s = s.substring(commandIndex);
        if(!s.equals(command)) {
            int indexXboot = s.indexOf("-Xbootclasspath");
            if(indexXboot >= 0) {
                strCommandLine = s.substring(command.length(),indexXboot).split("\\s+");
                for (String string : strCommandLine) {
                    commandLine.add(string);
                }
                strCommandLine = s.substring(indexXboot).split(";");
                for (String string : strCommandLine) {
                    commandLine.add(string);
                }
            } else {
                strCommandLine = s.substring(command.length()).split("\\s+");
                for (String string : strCommandLine) {
                    commandLine.add(string);
                }
            }
        }
        return new JinfoEntity(Arrays.stream(nonDefault).collect(Collectors.toList()), commandLine);
    }
}
