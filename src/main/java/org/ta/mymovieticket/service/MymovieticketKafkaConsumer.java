package org.ta.mymovieticket.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MymovieticketKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(MymovieticketKafkaConsumer.class);
    private static final String TOPIC = "topic_mymovieticket";

    @KafkaListener(topics = "topic_mymovieticket", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
