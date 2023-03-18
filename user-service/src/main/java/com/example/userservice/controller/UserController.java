package com.example.userservice.controller;

import com.example.userservice.entity.Role;
import com.example.userservice.entity.User;
import com.example.userservice.service.CustomUserDetails;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
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

    @GetMapping("/main")
    public String mainView(){
        return "main";
    }

    @GetMapping("/header")
    public String headerView(@PathVariable("id") Long id, Model model){
        User user = service.get(id);
        List<Role> roles = service.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "fragment/header";
    }

    @GetMapping("/account-form")
    public String accountFormView(@AuthenticationPrincipal CustomUserDetails userDetails, Model model){
        String email = userDetails.getUsername();
        List<Role> listRoles = service.listRoles();
        User user = service.getByEmail(email);
        model.addAttribute("account", user);
        model.addAttribute("listRoles", listRoles);
        return "account-form";
    }

    @PostMapping("/account/save")
    public String saveProfile(User user, RedirectAttributes redirectAttributes, @AuthenticationPrincipal CustomUserDetails userDetails) throws IOException{
        service.save(user);
        userDetails.setFullname(user.getFullname());
        redirectAttributes.addFlashAttribute("message", "Update account success");
        return "redirect:/users";
    }


    @GetMapping("/403")
    public String error403(){
        return "error/403";
    }

}
