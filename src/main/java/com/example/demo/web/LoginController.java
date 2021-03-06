package com.example.demo.web;

import com.example.demo.model.service.UserLoginServiceModel;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userModel")
    public UserLoginServiceModel userModel() {
        return new UserLoginServiceModel();
    }


    @GetMapping("/users/login")
    public String showLogin() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(@Valid @ModelAttribute UserLoginServiceModel userLoginServiceModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
        redirectAttributes.addFlashAttribute("userModel", userLoginServiceModel);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);

            return "redirect:/users/login";
        }
        if (userService.authenticate(userLoginServiceModel.getUsername(), userLoginServiceModel.getPassword())) {
            userService.loginUser(userLoginServiceModel.getUsername());
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("userModel", userLoginServiceModel);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:/users/login";
        }
    }

    @PostMapping("/users/logout")
    public String logout() {
        userService.logoutUser();
        return "redirect:/";
    }

}
