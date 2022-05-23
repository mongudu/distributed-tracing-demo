package com.example.appa.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class PingController {

    private static final Logger logger = LoggerFactory.getLogger(PingController.class);

    private final WebClient webClientOfAppB;

    public PingController(WebClient.Builder webClientBuilder) {
        this.webClientOfAppB = webClientBuilder.baseUrl("http://localhost:9091").build();
    }

    @GetMapping("/ping-b")
    public String pingB(){
        logger.info("ping-b called");
        return webClientOfAppB.get().uri("/ping").retrieve().bodyToMono(String.class).block();
    }

}
