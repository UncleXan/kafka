package com.example.kafka_test.kafka;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class Consumer {

    @Qualifier("kafkaConsumer")
    private final KafkaConsumer<Long, String> consumer;

    @Scheduled(fixedDelay = 1000L)
    public void consume() {
//        ConsumerRecords<Long, String> records = consumer.poll(100);
//
//        for (ConsumerRecord<Long, String> record : records) {
//            log.info("[Tech][Kafka] key = %d | value = %s".formatted(record.key(), record.value()));
//        }
        log.info("wasd");
    }

}
