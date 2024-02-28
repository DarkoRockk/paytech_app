package com.example.paytechapp.controller;

import com.example.paytechapp.dto.UserRegistrationDto;
import com.example.paytechapp.entity.UserEntity;
import com.example.paytechapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserRegistrationDto user = new UserRegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserRegistrationDto userDto,
                               BindingResult result,
                               Model model) {
        UserEntity existingUser = userService.getUserByEmail(userDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }
        userService.save(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
