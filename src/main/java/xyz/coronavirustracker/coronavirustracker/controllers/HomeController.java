package xyz.coronavirustracker.coronavirustracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import xyz.coronavirustracker.coronavirustracker.services.CoronaVirusDataService;

@Controller
public class HomeController {

    // provides instance
    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/") // '/' means root url
    public String home(Model model) {
        model.addAttribute("locationStats", coronaVirusDataService.getAllStats());
        return "home";
    }
}
