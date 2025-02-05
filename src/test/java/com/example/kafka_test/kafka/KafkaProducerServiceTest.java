package com.example.kafka_test.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(topics = {"demo-topic"}, partitions = 1)
class KafkaProducerServiceTest {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private KafkaTemplate<Long, String> kafkaTemplate;

    @Test
    void testSendMessage() {
        kafkaProducerService.sendMessage();

        ConsumerRecord<Long, String> record = kafkaTemplate.receive("demo-topic", 0, 0, Duration.ofDays(1));
        assertNotNull(record);
        assertNotNull(record.value());
    }
}