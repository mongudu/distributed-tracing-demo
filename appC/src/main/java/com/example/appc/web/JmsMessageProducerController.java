package com.example.appc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmsMessageProducerController {

  private static final Logger logger = LoggerFactory.getLogger(JmsMessageProducerController.class);

  @Autowired
  private JmsTemplate jmsTemplate;

  @PostMapping("/produce-jms-message")
  public void produceJmsMessage() {
    logger.info("produce-jms-message called");
    jmsTemplate.convertAndSend("queue1", "My message");
  }

}
