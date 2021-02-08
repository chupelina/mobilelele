package com.example.demo.model.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected Instant created;
    protected Instant updated;

    public Long getId() {
        return id;
    }

    public Instant getCreated() {
        return created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public BaseEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public BaseEntity setUpdated(Instant updated) {
        this.updated = updated;
        return this;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
