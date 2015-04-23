package org.codetrip.common.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by RuFeng on 2015/4/19.
 */
public class DateUtil {

    public static Calendar DateParser(String dateStr, String formatStr) throws Exception {
        String tempStr = dateStr;
        int initHours = 0;
        if (dateStr.endsWith("AM")) {
            tempStr = dateStr.substring(0, dateStr.indexOf("AM"));
        }
        else if (dateStr.endsWith("PM")) {
            tempStr = dateStr.substring(0, dateStr.indexOf("PM"));
            initHours += 12;
        }

        tempStr.trim();

        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(tempStr));
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + initHours);
        return cal;
    }

    public static Boolean before(Calendar time1, Calendar time2) {
        if (time1.compareTo(time2) < 0) return Boolean.TRUE;
        return Boolean.FALSE;
    }

    public static Boolean after(Calendar time1, Calendar time2) {
        if (time1.compareTo(time2) < 0) return Boolean.FALSE;
        return Boolean.TRUE;
    }

    public static Boolean equal(Calendar time1, Calendar time2) {
        if (time1.compareTo(time2) == 0) return Boolean.TRUE;
        return Boolean.FALSE;
    }
}
