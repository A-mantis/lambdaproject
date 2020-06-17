package com.mantis.lambda.util;

/**
 * @Description:
 * @author: wei.wang
 * @since: 2020/6/17 9:54
 * @history: 1.2020/6/17 created by wei.wang
 */
public class DataUtil {
    /**
     * 判断字符是否为空
     *
     * @param str
     * @return
     */
    public static Boolean isStrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static Boolean isStrNull(String str) {
        return !isStrEmpty(str);
    }
}
