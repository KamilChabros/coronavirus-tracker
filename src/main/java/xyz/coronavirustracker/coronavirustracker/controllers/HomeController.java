package xyz.coronavirustracker.coronavirustracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // '/' means root url
    public String home() {
        return "home";
    }
}
