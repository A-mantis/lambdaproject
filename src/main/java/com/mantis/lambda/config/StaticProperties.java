package com.mantis.lambda.config;

import java.text.SimpleDateFormat;

/**
 * @Description:
 * @author: wei.wang
 * @since: 2020/7/3 0:50
 * @history: 1.2020/7/3 created by wei.wang
 */
public class StaticProperties {

    private StaticProperties() {
    }

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
}
