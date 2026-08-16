package com.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "my-group", concurrency = "3")
    public void listen(String message) {
        System.out.println("Received Message: " + message);
    }

}
