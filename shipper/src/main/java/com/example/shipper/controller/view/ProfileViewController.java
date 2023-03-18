package com.example.shipper.controller.view;

import com.example.shipper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/profile")
public class ProfileViewController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String profilePage() {
        return "profile";
    }

    @GetMapping("/profile-box")
    public String getProfileBox(Model model) {
        // Rest template ...
//        ResponseEntity<UserDto> responseEntity = restTemplate.getForEntity(
//                "http://localhost:9000/api/user/profile",
//                UserDto.class
//        );
//        UserDto userDto = responseEntity.getBody();
        // ...

        model.addAttribute("user", userService.findById());
        return "fragment/profile-box";
    }
    
}
