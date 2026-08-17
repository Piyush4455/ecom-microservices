package com.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "test-group-1")
    public void listen1(String message) {
        System.out.println("Received Message 1: " + message);
    }

    @KafkaListener(topics = "my-topic", groupId = "test-group-2")
    public void listen2(String message) {
        System.out.println("Received Message 2: " + message);
    }

    @KafkaListener(topics = "my-topic-new", groupId = "test-group-3")
    public void listenRiderLocation(RiderLocation riderLocation) {
        System.out.println(
                "Received Location: "
                        + riderLocation.getRiderId()
                        + " : "
                        + riderLocation.getLatitude()
                        + " : "
                        + riderLocation.getLongitude()
        );
    }

}
