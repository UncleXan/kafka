package com.example.kafka_test.kafka;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Slf4j
@Service
@Getter
public class KafkaConsumerService {

    private final CountDownLatch latch = new CountDownLatch(1);
    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "demo-topic")
    public void listener(ConsumerRecord<Long, String> record) {
        log.info("[Tech][Kafka] key = %d | value = %s".formatted(record.key(), record.value()));
        messages.add(record.value());
        latch.countDown();
    }

}