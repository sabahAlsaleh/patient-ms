package com.example.patient.repository;

import com.example.patient.model.Message;
import com.example.patient.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findBySenderIdOrderByDateTimeDesc(Long senderId);
    List<Message> findByStatusOrderByDateTimeDesc(Message.Status status);
}
