package com.example.tripease.dto.request;

import com.example.tripease.Enum.Gender;

public class CustomerRequest {
    private String name;
    private int age;
    private String emailId;
    private Gender gender;

    public CustomerRequest(String name, int age, String emailId, Gender gender) {
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.gender = gender;
    }

    public CustomerRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
