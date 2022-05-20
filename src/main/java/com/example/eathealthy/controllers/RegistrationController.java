package com.example.eathealthy.controllers;

import com.example.eathealthy.dto.UserDTO;
import com.example.eathealthy.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserDTO userRegistrationDTO() {
        return new UserDTO();
    }

    @GetMapping
    public String showRegistrationPage(){
        return "registration";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user")UserDTO userRegistrationDTO) {
        userService.save(userRegistrationDTO);
        return "redirect:/login";
    }
}
