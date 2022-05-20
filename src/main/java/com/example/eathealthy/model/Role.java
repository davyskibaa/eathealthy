package com.example.eathealthy.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="roles")
@Data

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }
}
