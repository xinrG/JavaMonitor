package com.xinrg.JavaMonitor.timer.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String time() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd HH:mm");
        return simpleDateFormat.format(new Date());
    }
}
