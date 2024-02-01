package com.example.patient.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Encounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Employee employee;
    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "encounter")
    private List<Note> notes;
    @OneToMany(mappedBy = "encounter")
    private List<Observation> observations;


}