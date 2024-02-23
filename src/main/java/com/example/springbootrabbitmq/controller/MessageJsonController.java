package com.example.springbootrabbitmq.controller;

import com.example.springbootrabbitmq.dto.User;
import com.example.springbootrabbitmq.publisher.RabbitMQJsonProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageJsonController {
    private final RabbitMQJsonProducer jsonProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json sent to RabbitMQ...");
    }
}
