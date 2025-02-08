package com.example.kafka_test.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<Long, String> kafkaTemplate;

    public void sendMessage() {
        kafkaTemplate.send("demo-topic", 1L, "Some message");
    }

}
