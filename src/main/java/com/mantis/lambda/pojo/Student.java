package com.mantis.lambda.pojo;

/**
 * @Description:
 * @author: wei.wang
 * @since: 2019/12/27 13:20
 * @history: 1.2019/12/27 created by wei.wang
 */
public class Student {
    private String name;
    private int grade;
    private String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Student(String name, int grade, String department) {
        this.name = name;
        this.grade = grade;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", department='" + department + '\'' +
                '}';
    }
}
