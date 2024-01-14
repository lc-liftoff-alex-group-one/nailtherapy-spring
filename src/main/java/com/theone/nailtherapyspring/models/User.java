package com.theone.nailtherapyspring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Email
    private String emailAddress;

    private String phoneNumber;


    public User() {
    }

    public User(String firstName, String lastName, String emailAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }
}
