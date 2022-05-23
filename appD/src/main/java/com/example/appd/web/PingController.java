package com.example.appd.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PingController {

    private static final Logger logger = LoggerFactory.getLogger(PingController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ping")
    public String ping(HttpServletRequest request){
        logger.info("ping called");
        return "pong";
    }
    @GetMapping("/ping-e")
    public String pingE(HttpServletRequest request){
        logger.info("ping-e called");
        return restTemplate.getForObject("http://localhost:9095/ping", String.class);
    }
}
