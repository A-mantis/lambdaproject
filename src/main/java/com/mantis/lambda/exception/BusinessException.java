package com.mantis.lambda.exception;

/**
 * @Description:
 * @author: wei.wang
 * @since: 2020/6/16 15:43
 * @history: 1.2020/6/16 created by wei.wang
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String msg) {
        super(msg);
    }
}
