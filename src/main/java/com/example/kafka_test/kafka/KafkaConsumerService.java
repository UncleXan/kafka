package com.example.kafka_test.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    @KafkaListener(topics = "demo-topic")
    public void listener(ConsumerRecord<Long, String> record) {
        log.info("[Tech][Kafka] key = %d | value = %s".formatted(record.key(), record.value()));
    }

}