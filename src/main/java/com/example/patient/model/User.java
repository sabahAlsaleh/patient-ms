package com.example.patient.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String username;
    private String password;

    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String email, String password, String firstName, String lastName, LocalDate birthDate, Role patient) {

    }


    public enum Role {EMPLOYEE, PATIENT}

    public User(Long id, @NonNull String username, @NonNull String firstName, @NonNull String lastName, @NonNull LocalDate birthDate, @NonNull Role role) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.role = role;
    }


}
