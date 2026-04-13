package com.kirill.aws_example_project.controller;

import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("projectName", "AWS S3 Example Project");
        model.addAttribute("today", LocalDate.now());
        return "home";
    }
}
