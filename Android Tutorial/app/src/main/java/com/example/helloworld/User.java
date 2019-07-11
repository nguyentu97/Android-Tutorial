package com.example.helloworld;

import java.io.Serializable;

public class User implements Serializable {
    String name,phoneNumeber,dob,email,provice;

    public User() {
    }

    public User(String name, String phoneNumeber, String dob, String email, String provice) {
        this.name = name;
        this.phoneNumeber = phoneNumeber;
        this.dob = dob;
        this.email = email;
        this.provice = provice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumeber() {
        return phoneNumeber;
    }

    public void setPhoneNumeber(String phoneNumeber) {
        this.phoneNumeber = phoneNumeber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }
}
