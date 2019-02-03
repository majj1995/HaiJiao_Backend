package com.mjj.travelling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TravellingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravellingApplication.class, args);
    }

}

