package com.gagan.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampUtil {
    public static String getCurrentTimestamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }
}
