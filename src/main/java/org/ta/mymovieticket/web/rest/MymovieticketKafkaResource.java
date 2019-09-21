package org.ta.mymovieticket.web.rest;

import org.ta.mymovieticket.service.MymovieticketKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/mymovieticket-kafka")
public class MymovieticketKafkaResource {

    private final Logger log = LoggerFactory.getLogger(MymovieticketKafkaResource.class);

    private MymovieticketKafkaProducer kafkaProducer;

    public MymovieticketKafkaResource(MymovieticketKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
