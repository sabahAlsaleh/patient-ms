package com.example.patient.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public final class Employee extends User{
    @Enumerated(EnumType.STRING)
    private Position position;
    public enum Position {DOCTOR, OTHER}


}
