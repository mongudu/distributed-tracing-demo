package com.example.appf.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JmsMessageConsumer {

    private static final Logger logger = LoggerFactory.getLogger(JmsMessageConsumer.class);

    @Autowired
    private RestTemplate restTemplate;

    @JmsListener(destination = "queue1", containerFactory = "myFactory")
    public void receiveMessage(String messagePayload) {
      logger.info("Message payload <" + messagePayload + ">");
      String response = restTemplate.getForObject("http://localhost:9098/ping", String.class);
      logger.info("response: {}", response);
    }

}
