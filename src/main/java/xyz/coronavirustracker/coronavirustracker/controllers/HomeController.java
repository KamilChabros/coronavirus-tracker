package xyz.coronavirustracker.coronavirustracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import xyz.coronavirustracker.coronavirustracker.models.LocationStats;
import xyz.coronavirustracker.coronavirustracker.services.CoronaVirusDataService;

import java.util.List;

@Controller
public class HomeController {

    // provides instance
    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/") // '/' means root url
    public String home(Model model) {
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        return "home";
    }
}
