package com.example.chat_service.service;

import com.example.chat_service.entity.User;
import com.example.chat_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserService {
    private UserRepository userRepository;

}
