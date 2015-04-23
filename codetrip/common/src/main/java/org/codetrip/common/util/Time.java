package org.codetrip.common.util;

import java.util.Calendar;

/**
 * Created by RuFeng on 2015/4/21.
 */
public class Time {
    private int hour;
    private int minute;
    private int second;
    private int year;
    private int month;
    private int day;

    public Time(Calendar time) {
        hour = time.get(Calendar.HOUR_OF_DAY);
        minute = time.get(Calendar.MINUTE);
        second = time.get(Calendar.SECOND);
        year = time.get(Calendar.YEAR);
        month = time.get(Calendar.MONTH);
        day = time.get(Calendar.DAY_OF_MONTH);
    }

    public boolean before(Time time) {
        if (year > time.year) return false;
        else if (year < time.year) return true;
        else {
            if (month > time.month) return false;
            else if (month < time.month) return true;
            else {
                if (day > time.day) return false;
                else if (day < time.day) return true;
                else {
                    if (hour > time.hour) return false;
                    else if (hour < time.hour) return true;
                    else {
                        if (minute > time.minute) return false;
                        else if (minute < time.minute) return true;
                        else {
                            if (second >= time.second) return false;
                            else return true;
                        }
                    }
                }
            }
        }
    }

    public boolean after(Time time) {
        if (year > time.year) return true;
        else if (year < time.year) return false;
        else {
            if (month > time.month) return true;
            else if (month < time.month) return false;
            else {
                if (day > time.day) return true;
                else if (day < time.day) return false;
                else {
                    if (hour > time.hour) return true;
                    else if (hour < time.hour) return false;
                    else {
                        if (minute > time.minute) return true;
                        else if (minute < time.minute) return false;
                        else {
                            if (second > time.second) return true;
                            else return false;
                        }
                    }
                }
            }
        }
    }

    public boolean equal(Time time) {
        if (year == this.year && month == this.month && day == this.day &&
                hour == this.hour && minute == this.minute && second == this.second) return true;
        return false;
    }
}
