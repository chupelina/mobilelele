package com.example.demo.service.impl;

import com.example.demo.model.entities.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CurrentUser;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public boolean authenticate(String username, String password) {
        Optional<UserEntity> current = userRepository.findByUsername(username);
        if(current.isEmpty()){
            return false;
        }else{
            return passwordEncoder.matches( password,current.get().getPassword());
        }

    }

    @Override
    public void loginUser(String username) {
   currentUser.setAnonymous(false).setName(username);
    }

    @Override
    public void logoutUser() {
        currentUser.setAnonymous(true);
    }
}
