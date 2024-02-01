package com.example.patient.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime dateTime;
    private Status status;
    @ManyToOne
    private User sender;
    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(name = "message_id")
    private List<Reply> replies;

    public enum Status {ACTIVE,ARCHIVED}

    public Message(String content, User sender) {
        this.content = content;
        this.dateTime = LocalDateTime.now();
        this.sender = sender;
        this.status = Status.ACTIVE;
        this.replies = new ArrayList<>();
    }


}
