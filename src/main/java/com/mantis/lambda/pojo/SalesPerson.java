package com.mantis.lambda.pojo;

/**
 * @Description:
 * @author: wei.wang
 * @since: 2020/8/12 11:04
 * @history: 1.2020/8/12 created by wei.wang
 */
public class SalesPerson {
    private Employee employee;
    private String address;
    private String entryYear;

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEntryYear() {
        return this.entryYear;
    }

    public void setEntryYear(String entryYear) {
        this.entryYear = entryYear;
    }

    public SalesPerson(Employee employee, String address, String entryYear) {
        this.employee = employee;
        this.address = address;
        this.entryYear = entryYear;
    }

    public SalesPerson() {
    }

    @Override
    public String toString() {
        return "SalesPerson [employee=" + this.employee + ", address=" + this.address + ", entryYear=" + this.entryYear + "]";
    }
}