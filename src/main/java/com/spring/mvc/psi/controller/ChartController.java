package com.spring.mvc.psi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class ChartController {
    
    @RequestMapping("/report")
    public String report(Model model) {
        return "chart/report";
    }
}
