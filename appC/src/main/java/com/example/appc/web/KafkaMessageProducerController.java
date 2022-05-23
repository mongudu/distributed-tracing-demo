package com.example.appc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaMessageProducerController {

    private static final Logger logger = LoggerFactory.getLogger(KafkaMessageProducerController.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/produce-kafka-message")
    public void produceKafkaMessage(){
        logger.info("produce-kafka-message called");
        kafkaTemplate.send("topic1", "My message");
    }

}
