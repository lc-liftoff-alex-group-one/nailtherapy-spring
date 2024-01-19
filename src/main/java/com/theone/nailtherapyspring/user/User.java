package com.theone.nailtherapyspring.user;

import com.theone.nailtherapyspring.models.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "emailAddress" })})
public class User extends AbstractEntity {
    @NotBlank
    @Size(max = 32)
    private String firstName;

    @NotBlank
    @Size(max = 32)
    private String lastName;

    @NaturalId
    @NotBlank
    @Size(max = 64)
    @Email
    private String emailAddress;

    @Size(max = 16)
    private String phoneNumber;

    @NotBlank
    @Size(max = 100)
    private String passcode;

    @ManyToMany
    @JoinTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName, String emailAddress, String phoneNumber, String passcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.passcode = passcode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
