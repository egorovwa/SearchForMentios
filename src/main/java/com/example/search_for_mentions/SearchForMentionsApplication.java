package com.example.search_for_mentions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SearchForMentionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchForMentionsApplication.class, args);
    }

}
