package com.example.appe.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PingController {

    private static final Logger logger = LoggerFactory.getLogger(PingController.class);

    @GetMapping("/ping")
    public String ping(HttpServletRequest request){
        logger.info("ping is called");
        return "pong";
    }

}
