package com.example.kafka_test.kafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(topics = "demo-topic", partitions = 1)
class KafkaConsumerServiceTest {

    @Autowired
    private KafkaConsumerService kafkaConsumerService;

    @Autowired
    private KafkaTemplate<Long, String> kafkaTemplate;

    @Test
    void testListener() throws InterruptedException {
        kafkaTemplate.send("demo-topic", 1L, "Some message");

        CountDownLatch latch = kafkaConsumerService.getLatch();
        latch.await(10L, TimeUnit.SECONDS);

        assertEquals(1, kafkaConsumerService.getMessages().size());
        assertEquals("Some message", kafkaConsumerService.getMessages().get(0));
    }
}