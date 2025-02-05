package com.example.kafka_test.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<Long, String> kafkaTemplate;

    //@Scheduled(fixedDelay = 3000L)
    public void sendMessage() {
        kafkaTemplate.send("demo-topic", 1L, "Some message");
    }

}
