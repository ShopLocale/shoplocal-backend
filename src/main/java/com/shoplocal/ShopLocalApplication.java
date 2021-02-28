package com.shoplocal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class ShopLocalApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShopLocalApplication.class, args);
  }

  // =======================================

  // Set UTC time zone for the application
  @PostConstruct
  void started() {
    TimeZone.setDefault(TimeZone.getTimeZone("IST"));
  }
}
