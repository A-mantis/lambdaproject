package com.mantis.lambda.pojo;

import java.util.Objects;

/**
 * @Description:
 * @author: wei.wang
 * @since: 2020/8/12 11:04
 * @history: 1.2020/8/12 created by wei.wang
 */
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private Status status;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String print() {
        return "this is reference!";
    }

    @Override
    public String toString() {
        return "Employee [id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" + this.salary + ", status=" + this.status + "]";
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(int id, String name, int age, double salary, Status status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }

    public Employee() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return id == employee.id &&
                age == employee.age &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) &&
                status == employee.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary, status);
    }
}
