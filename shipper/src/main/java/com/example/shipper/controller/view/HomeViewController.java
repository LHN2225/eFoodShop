package com.example.shipper.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/home")
public class HomeViewController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("")
    public String home(Model model) {
        // Rest template ...
        //RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> responseEntity = restTemplate.getForEntity(
                "lb://VIRTUAL/api/page/not-busy",
                Integer.class
        );
        int totalPageNumber = responseEntity.getBody();
        // ...

        int[] paginationItems = new int[totalPageNumber];
        for (int i = 1; i <= totalPageNumber; i++) {
            paginationItems[i-1] = i;
        }
        model.addAttribute("paginationItems", paginationItems);
        return "home";
    }
}
