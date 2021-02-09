package com.example.demo.service.impl;

import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.entities.UserRoleEntity;
import com.example.demo.model.entities.enums.Role;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CurrentUser;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        UserEntity user = userRepository.findByUsername(username).orElseThrow();
        List<Role> userRoles = user.getRoles().stream()
                .map(UserRoleEntity::getRole).collect(Collectors.toList());
   currentUser.setAnonymous(false).setName(user.getUsername())
   .setUserRoles(userRoles);
    }

    @Override
    public void logoutUser() {
        currentUser.setAnonymous(true);
    }
}
