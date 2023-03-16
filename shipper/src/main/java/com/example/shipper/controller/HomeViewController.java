package com.example.shipper.controller;

import com.example.shipper.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipper/home")
public class HomeViewController {

    // Page size
    public int pageSize = 5;

    @Autowired
    private PageRepository pageRepository;

    @GetMapping("")
    public String home(Model model) {
        int totalPageNumber = pageRepository.findNotBusyOrderTotalPageNumber("IN_PROGRESS", pageSize);
        int[] paginationItems = new int[totalPageNumber];
        for (int i = 1; i <= totalPageNumber; i++) {
            paginationItems[i-1] = i;
        }
        model.addAttribute("paginationItems", paginationItems);
        return "home";
    }
}
