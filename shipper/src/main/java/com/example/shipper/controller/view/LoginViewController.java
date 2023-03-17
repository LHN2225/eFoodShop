package com.example.shipper.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.shipper.entity.User;

@Controller
@RequestMapping("/login")
public class LoginViewController {

    @GetMapping("")
    public String loginPage() {
        return "login";
    }

    @PostMapping("")
    @ResponseBody
    public User testPassParameters(@RequestParam String email, @RequestParam String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }

}
