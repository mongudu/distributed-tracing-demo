package com.example.appc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class PingController {

  private static final Logger logger = LoggerFactory.getLogger(PingController.class);

  private final WebClient webClientOfAppD;

  public PingController(WebClient.Builder webClientBuilder) {
    this.webClientOfAppD = webClientBuilder.baseUrl("http://localhost:9094").build();
  }

  @GetMapping("/ping")
  public String ping() {
    logger.info("test");
    return "pong";
  }

  @GetMapping("/ping-d")
  public String pingD() {
    logger.info("ping-d called");
    return webClientOfAppD.get().uri("/ping").retrieve().bodyToMono(String.class).block();
  }

  @GetMapping("/ping-d-and-e")
  public String pingDAndE() {
    logger.info("ping-d-and-e called");
    return webClientOfAppD.get().uri("/ping-e").retrieve().bodyToMono(String.class).block();
  }


}
