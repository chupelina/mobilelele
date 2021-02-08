package com.example.demo.web;

import com.example.demo.model.service.UserLoginServiceModel;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users/login")
    public String showLogin() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginServiceModel userLoginServiceModel) {
        if (userService.authenticate(userLoginServiceModel.getUsername(), userLoginServiceModel.getPassword())) {
            userService.loginUser(userLoginServiceModel.getUsername());
            return "redirect:/";
        } else {
            return "redirect:/users/login";
        }
    }

    @PostMapping("/users/logout")
    public String logout() {
        userService.logoutUser();
        return "redirect:/";
    }

}
