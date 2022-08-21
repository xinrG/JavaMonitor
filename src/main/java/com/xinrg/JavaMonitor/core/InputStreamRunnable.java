package com.xinrg.JavaMonitor.core;

import java.io.*;

public class InputStreamRunnable implements Runnable {
    private BufferedReader bufferedReader = null;
    InputStreamRunnable(InputStream is,String type){
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(is),"UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        String line = null;
        int num = 1;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                //如果整数不够2列就补上0   2是宽度
                System.out.println("---->"+String.format("%02d",num++)+" "+line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
