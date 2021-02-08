package com.example.demo.model.entities;

import com.example.demo.model.entities.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Enumerated(value = EnumType.STRING)
    private Role role;

    public Long getId() {
        return id;
    }

    public UserRoleEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserRoleEntity setRole(Role role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}
