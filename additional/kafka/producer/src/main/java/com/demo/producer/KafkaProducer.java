package com.demo.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class KafkaProducer {

    private final KafkaTemplate<String, RiderLocation> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, RiderLocation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {

        RiderLocation riderLocation = new RiderLocation("rider123", 28.61, 75.23);

        kafkaTemplate.send("my-topic-new", riderLocation);
        return "Message sent: " + riderLocation.getRiderId();
    }

}
