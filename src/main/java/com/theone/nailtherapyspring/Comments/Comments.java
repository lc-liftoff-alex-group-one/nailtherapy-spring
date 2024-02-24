
package com.theone.nailtherapyspring.Comments;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Comments {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @NotBlank(message = "Comment is required")
    private String comment;

    public Comments(String name, String comment){
        this.name=name;
        this.comment=comment;
    }

    public Comments(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}