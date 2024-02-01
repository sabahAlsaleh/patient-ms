package com.example.patient.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private LocalDateTime dateTimeCreated;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    @Nullable
    private Encounter encounter;

    public Note(String text, Employee employee, Patient patient, @Nullable Encounter encounter) {
        this.text = text;
        this.employee = employee;
        this.patient = patient;
        this.encounter = encounter;
        this.dateTimeCreated = LocalDateTime.now();
    }

}
