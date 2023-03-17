package com.example.shipper.controller.view;

import com.example.shipper.config.AppConfig;
import com.example.shipper.config.VirtualFoodCartOrderConfig;
import com.example.shipper.dto.UserDto;
import com.example.shipper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/profile")
public class ProfileViewController {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private VirtualFoodCartOrderConfig virtualFoodCartOrderConfig;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String profilePage() {
        return "profile";
    }

    @GetMapping("/profile-box")
    public String getProfileBox(Model model) {
        // Rest template ...
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDto> responseEntity = restTemplate.getForEntity(
                appConfig.getDomain() + "/api/user/profile",
                UserDto.class
        );
        UserDto userDto = responseEntity.getBody();
        // ...

        model.addAttribute("user", userDto);
        return "fragment/profile-box";
    }
    
}
