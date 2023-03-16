package com.example.shipper.controller;

import com.example.shipper.config.AppConfig;
import com.example.shipper.dto.UserDto;
import com.example.shipper.entity.User;
import com.example.shipper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipper/profile")
public class ProfileViewController {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String profilePage() {
        return "profile";
    }

    @GetMapping("/profile-box")
    public String getProfilePBox(Model model) {
        UserDto userDto = userService.findById(appConfig.shipperId);
        model.addAttribute("user", userDto);
        return "fragment/profile-box";
    }
    
}
