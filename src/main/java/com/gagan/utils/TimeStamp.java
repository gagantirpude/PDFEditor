package com.gagan.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamp {

   public static void myTimeStamp(){
       // Print completion timestamp
       String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
       System.out.println("Completed at: " + timestamp);
    }

}
