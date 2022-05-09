package com.example.ManagerEmployee.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "employees")
public class Employee {

    @Id
    private String id;
    private String name;
    private String address;
    private String sex;
    private String age;
    private String startDay;
    private String phoneNumber;
    private Number salaryPerHour;
    private String idTeam;
    private Object[] working;
    private Object[] advances;
    private String avatar;

    public Employee(String name, String address, String sex, String age, String startDay, String phoneNumber,
                    Number salaryPerHour, String idTeam, Object[] working, Object[] advances, String avatar) {
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.age = age;
        this.startDay = startDay;
        this.phoneNumber = phoneNumber;
        this.salaryPerHour = salaryPerHour;
        this.idTeam = idTeam;
        this.working = working;
        this.advances = advances;
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Number getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(Number salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public Object[] getWorking() {
        return working;
    }

    public void setWorking(Object[] working) {
        this.working = working;
    }

    public Object[] getAdvances() {
        return advances;
    }

    public void setAdvances(Object[] advances) {
        this.advances = advances;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
