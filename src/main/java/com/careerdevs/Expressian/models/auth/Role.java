package com.careerdevs.Expressian.models.auth;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERoll name;

    public Role() {
    }

    public Role(ERoll name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERoll getName() {
        return name;
    }

    public void setName(ERoll name) {
        this.name = name;
    }
}
