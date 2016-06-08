package com.doctor.common;

/**
 * Created by lzc on 2016/5/30.
 */
public class StringUtil {
    public static boolean isVailtString(String s){
        if (null != s && !s.equals(""))
            return true;
        else return false;
    }
}
