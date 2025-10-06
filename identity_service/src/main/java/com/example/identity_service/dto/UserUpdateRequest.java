package com.example.identity_service.dto;

import java.time.LocalDate;

public class UserUpdateRequest {

    private String password;
    private String fisrtName;
    private String lastName;
    private LocalDate dob;


    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFisrtName() {
        return this.fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
