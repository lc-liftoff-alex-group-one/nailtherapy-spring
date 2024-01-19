package com.theone.nailtherapyspring.role;

import com.theone.nailtherapyspring.models.AbstractEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "roles")
public class Role extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 64)
    private RoleName name;

    public Role() {
    }

    public Role(RoleName name) {
        this.name = name;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
