package com.aassoua.mvc;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MvcApplication {
    public static final Logger logger = LoggerFactory.getLogger(MvcApplication.class);

    public static void main(String[] args) {
        log.info("Server Started!");
        SpringApplication.run(MvcApplication.class, args);
    }

}
