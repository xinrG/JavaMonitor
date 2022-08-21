package com.xinrg.JavaMonitor.core;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuteCmd {
    public static String execute(String[] cmd,String... encoding) {
        //字符流
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            //错误流
            Thread t = new Thread(new InputStreamRunnable(p.getErrorStream(), "ErrorStream"));
            t.start();
            //字节流
            BufferedInputStream bis = new BufferedInputStream(p.getInputStream());
            if(encoding != null && encoding.length != 0) {
                inputStreamReader = new InputStreamReader(bis,encoding[0]);
            } else {
                inputStreamReader = new InputStreamReader(bis,"utf-8");
            }
            bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            bufferedReader.close();
            p.destroy();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
