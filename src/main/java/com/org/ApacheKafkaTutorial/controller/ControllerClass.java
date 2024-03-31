package com.org.ApacheKafkaTutorial.controller;

import com.org.ApacheKafkaTutorial.Kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {

    @Autowired
    private KafkaProducer kafkaProducer;

    public ControllerClass(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    //http:localhost:8080/sentMessageToProducer/message

    @GetMapping("/sentMessageToProducer")
    public ResponseEntity sentMessageToProducer(@PathVariable String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }
}
