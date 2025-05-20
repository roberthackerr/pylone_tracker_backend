package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name; // e.g., "ADMIN", "USER"
    @OneToMany(mappedBy = "role")
    private List<User> users;
}
