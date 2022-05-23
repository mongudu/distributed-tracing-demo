package com.example.appg.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KafkaMessageConsumer {

  private static final Logger logger = LoggerFactory.getLogger(KafkaMessageConsumer.class);

  @Autowired
  private RestTemplate restTemplate;

  @KafkaListener(topics = "topic1", groupId = "appG")
  public void listenGroupFoo(String messagePayload) {
    logger.info("Received Message in group foo: " + messagePayload);
    String response = restTemplate.getForObject("http://localhost:9098/ping", String.class);
    logger.info("response: {}", response);
  }

}
