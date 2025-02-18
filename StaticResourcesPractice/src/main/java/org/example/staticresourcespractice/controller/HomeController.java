package org.example.staticresourcespractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/a")
    public String home() {
        return "index";
    }
}
