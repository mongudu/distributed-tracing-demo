package com.example.appc.web;

import brave.baggage.BaggageField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PingAdvancedScenarioBaggageController {

  private static final Logger logger = LoggerFactory.getLogger(PingAdvancedScenarioBaggageController.class);

  @Autowired
  BaggageField countryCodeField;

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/ping-d-with-baggage")
  public String pingDWithBaggage() {
    logger.info("pingDWithBaggage");
    countryCodeField.updateValue("TR");
    return restTemplate.getForObject("http://localhost:9094/ping", String.class);
  }

  @GetMapping("/ping-d-and-e-with-baggage")
  public String pingDAndEWithBaggage() {
    logger.info("pingDWithBaggage");
    countryCodeField.updateValue("EN");
    return restTemplate.getForObject("http://localhost:9094/ping-e", String.class);
  }


}
