package com.example.patient.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Reply{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime dateTime;
    @ManyToOne
    private User sender;

    public Reply(String content, User sender) {
        this.content = content;
        this.dateTime = LocalDateTime.now();
        this.sender = sender;
    }


}
