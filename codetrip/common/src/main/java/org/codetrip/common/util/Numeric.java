package org.codetrip.common.util;

/**
 * Created by RuFeng on 2015/4/22.
 */
public class Numeric {

    public static boolean isInteger(String num) {
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException err) {
            return false;
        }
        return true;
    }
}
