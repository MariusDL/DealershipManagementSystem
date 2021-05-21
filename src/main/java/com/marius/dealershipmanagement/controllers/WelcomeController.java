package com.marius.dealershipmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping({"/", "index", "index.html"})
    public String welcome() {
        return "welcome";
    }

}
