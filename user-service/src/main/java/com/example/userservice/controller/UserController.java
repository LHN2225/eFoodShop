package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.Role;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("")
    public String login(){
        return "login-page";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register-page";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        service.registerDefaultUser(user);

        return "register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = service.get(id);
        List<Role> listRoles = service.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user) {
        service.save(user);

        return "redirect:/users";
    }



    @GetMapping("/403")
    public String error403(){
        return "403";
    }

}
