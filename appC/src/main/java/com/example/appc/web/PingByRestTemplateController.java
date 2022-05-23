package com.example.appc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PingByRestTemplateController {

  private static final Logger logger = LoggerFactory.getLogger(PingByRestTemplateController.class);

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/by-rest-template/ping-d")
  public String pingD() {
    logger.info("ping-d called");
    return restTemplate.getForObject("http://localhost:9094/ping", String.class);
  }

  @GetMapping("/by-rest-template-exchange/ping-d")
  public ResponseEntity<String> pingDByRestTemplateExchange() {
    logger.info("pingDByRestTemplateExchange called");
    return restTemplate.exchange("http://localhost:9094/ping", HttpMethod.GET, HttpEntity.EMPTY, String.class);
  }

  @GetMapping("/by-rest-template/ping-d-and-e")
  public String pingDAndE() {
    logger.info("ping-d-and-e called");
    return restTemplate.getForObject("http://localhost:9094/ping-e", String.class);
  }

}
