package com.example.shipper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.shipper.entity.User;

@Controller
@RequestMapping("/shipper/login")
public class LoginViewController {

    @GetMapping("")
    public String loginPage() {
        return "login";
    }

    @PostMapping("")
    @ResponseBody
    public User testPassParameters(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

}
