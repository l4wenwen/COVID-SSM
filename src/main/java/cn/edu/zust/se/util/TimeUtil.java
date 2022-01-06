package cn.edu.zust.se.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String getDate() {
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strDateFormat);
        return simpleDateFormat.format(date);
    }
}
