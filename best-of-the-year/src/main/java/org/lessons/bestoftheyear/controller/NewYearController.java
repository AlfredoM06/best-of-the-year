package org.lessons.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class NewYearController {
    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("year", 2023);
        model.addAttribute("name", "Alfredo");

        return "home";
    }
}
