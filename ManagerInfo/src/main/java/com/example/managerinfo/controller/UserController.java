package com.example.managerinfo.controller;

import com.example.managerinfo.dto.UserDto;
import com.example.managerinfo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("get-manager-info")
    public String getManagerInfo(Model model) throws Exception {
        // hard-code id of user
        Long userId = Long.valueOf(5);

        UserDto userDto = userService.findByIdAndRoleId(userId, "MANAGER");
        model.addAttribute("manager", userDto);

        return "ManagerInfo";
    }

    @PostMapping("update-manager-info")
    public String updateManagerInfo(Model model, @ModelAttribute("manager") UserDto userDto) {
//        model.addAttribute("manager", new UserDto());
        try {
            userService.update(userDto);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
}
