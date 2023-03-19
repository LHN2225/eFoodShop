package com.example.shipper.controller.view;

import com.example.shipper.config.AppConfig;
import com.example.shipper.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/home")
public class HomeViewController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @GetMapping("/redirect/{userIdParam}")
    public void redirectHome(@PathVariable Long userIdParam, HttpServletResponse response) throws IOException {
        appConfig.shipperId = userIdParam;
        response.sendRedirect("http://localhost:8765/shipper/home");
    }

    @GetMapping("")
    public String home(Model model, HttpServletResponse response) {
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

        // Add cookie
        Cookie cookie = new Cookie("jwtToken",
                tokenProvider.miniGenerateToken(appConfig.shipperId));
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60 * 60);
        cookie.setSecure(false);
        cookie.setPath("/");

        response.addCookie(cookie);

        return "home";
    }
}
