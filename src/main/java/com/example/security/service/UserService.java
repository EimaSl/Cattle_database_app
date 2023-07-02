package com.example.security.service;

import com.example.security.model.LivestockDTO;
import com.example.security.model.User;
import com.example.security.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getByUsername(String username){
        return userRepository.getByUsername(username);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<LivestockDTO> getAllCattle(Long id) {
        return null;
    }
}
