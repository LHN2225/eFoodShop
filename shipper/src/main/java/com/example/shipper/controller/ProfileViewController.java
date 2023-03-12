package com.example.shipper.controller;

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

    // Test for shipper id before authentication and authorization handling by security
    public Long shipper_id_test = 1L;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String profilePage() {
        return "profile";
    }

    @GetMapping("/profile-box")
    public String getProfilePBox(Model model) {


        User user = userService.findById(shipper_id_test);
        model.addAttribute("user", user);
        return "fragment/profile-box";
    }
    
}
