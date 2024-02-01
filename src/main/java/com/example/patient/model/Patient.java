package com.example.patient.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends User{

    @OneToMany(mappedBy = "sender")
    private List<Message> messages;

    @OneToMany(mappedBy = "patient")
    private List<Note> notes;

    @OneToMany(mappedBy = "patient")
    private List<Encounter> encounters;

    @OneToMany(mappedBy = "patient")
    private List<Condition> conditions;


    public Patient(Long id, String username, String firstName, String lastName, LocalDate birthDate) {
        super(id, username, firstName, lastName, birthDate, Role.PATIENT);
    }

    public Patient(String email, String password, String firstName, String lastName, LocalDate birthDate) {
        super(email, password, firstName, lastName, birthDate, Role.PATIENT);
    }

}
