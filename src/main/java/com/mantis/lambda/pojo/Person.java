package com.mantis.lambda.pojo;

/**
 * @Description:
 * @author: wei.wang
 * @since: 2020/6/17 8:39
 * @history: 1.2020/6/17 created by wei.wang
 */
public class Person {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "car=" + car +
                '}';
    }
}