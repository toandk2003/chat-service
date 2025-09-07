package com.example.chat_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatService {

    public static void main(String[] args) {
        SpringApplication.run(ChatService.class, args);
        System.out.println("hi from Chat Service");
    }

}
