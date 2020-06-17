package com.mantis.lambda.pojo;

/**
 * @Description:
 * @author: wei.wang
 * @since: 2020/6/17 8:39
 * @history: 1.2020/6/17 created by wei.wang
 */
public class Insurance {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "name='" + name + '\'' +
                '}';
    }
}