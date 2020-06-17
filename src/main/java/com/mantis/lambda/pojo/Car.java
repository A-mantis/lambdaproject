package com.mantis.lambda.pojo;

/**
 * @Description:
 * @author: wei.wang
 * @since: 2020/6/17 8:39
 * @history: 1.2020/6/17 created by wei.wang
 */
public class Car {
    private Insurance insurance;

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    @Override
    public String toString() {
        return "Car{" +
                "insurance=" + insurance +
                '}';
    }
}