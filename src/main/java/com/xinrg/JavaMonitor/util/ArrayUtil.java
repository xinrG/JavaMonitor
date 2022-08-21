package com.xinrg.JavaMonitor.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayUtil {
    public static String[] trim(String[] str) {
        if(str == null || str.length == 0) {
            return str;
        }
        List<String> list = new ArrayList<>();
        for(String s : str) {
            if (s != null && !s.equals("")) {
                list.add(s);
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    /**
     * 统计字符串findString在字符串targetString中出现的次数
     * @param targetString
     * @param findString
     * @return
     */
    public static int appearTimes(String targetString,String findString) {
        int count = 0;
        Pattern p = Pattern.compile(findString);
        Matcher m = p.matcher(targetString);
        while (m.find()) {
            count++;
        }
        return count;
    }
}
