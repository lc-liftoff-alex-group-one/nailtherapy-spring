package com.theone.nailtherapyspring.contact;

import com.theone.nailtherapyspring.models.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.scheduling.support.SimpleTriggerContext;

@Entity

public class ContactForm{
    @Id
    @GeneratedValue
    private int id;
@NotBlank(message = "Name is required")
private String name;
@NotBlank(message= "Email is required")
@Email
private String email;
@NotBlank(message= "Phone number is required")
private String phone;
@NotBlank(message = "How can we help you?")
@Size(max = 2000)
private String message;

    public ContactForm(String name, String email, String phone, String message) {
        this.name= name;
        this.email= email;
        this.phone= phone;
        this.message= message;
    }

    public ContactForm() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
