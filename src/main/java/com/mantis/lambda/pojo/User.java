package com.mantis.lambda.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @Description:
 * @author: wei.wang
 * @since: 2020/7/27 10:30
 * @history: 1.2020/7/27 created by wei.wang
 */
public class User {
    private String userId;
    private String username;
    private String password;
    private String status;
    private Date createTime;
    private Date updateTime;
    private int age;
    private BigDecimal memberNum;

    public User() {
    }

    public User(String userId, String username, String password, String status, Date createTime, Date updateTime, int age, BigDecimal memberNum) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.age = age;
        this.memberNum = memberNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(BigDecimal memberNum) {
        this.memberNum = memberNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", age=" + age +
                ", memberNum=" + memberNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(status, user.status) &&
                Objects.equals(createTime, user.createTime) &&
                Objects.equals(updateTime, user.updateTime) &&
                Objects.equals(memberNum, user.memberNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, status, createTime, updateTime, age, memberNum);
    }
}

