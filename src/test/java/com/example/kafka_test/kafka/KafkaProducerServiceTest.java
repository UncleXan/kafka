package com.example.kafka_test.kafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(topics = "demo-topic", partitions = 1)
class KafkaProducerServiceTest {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private KafkaConsumerService kafkaConsumerService;

    @Test
    void testSendMessage() throws InterruptedException {
        kafkaProducerService.sendMessage();

        CountDownLatch latch = kafkaConsumerService.getLatch();
        latch.await(10L, TimeUnit.SECONDS);

        assertNotNull(kafkaConsumerService.getMessages());
        assertEquals("Some message", kafkaConsumerService.getMessages().get(0));
    }
}