package com.example.appc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.sleuth.annotation.ContinueSpan;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingAdvancedScenarioController {

  private static final Logger logger = LoggerFactory.getLogger(PingAdvancedScenarioController.class);

  @GetMapping("/ping-and-tag")
  @ContinueSpan()
  public String pingAndTag(@RequestParam("customerId") @SpanTag("customerId") String customerId) {
    logger.info("pingAndTag customerId:{}", customerId);
    return "pong";
  }

  @GetMapping("/ping-with-new-span")
  @NewSpan("custom-span-name-ping-with-new-span")
  public String pingWithNewSpan() {
    logger.info("pingWithNewSpan");
    return "pong";
  }

}
