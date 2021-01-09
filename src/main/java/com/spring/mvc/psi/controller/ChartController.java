package com.spring.mvc.psi.controller;

import com.spring.mvc.psi.repository.Inventory2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class ChartController {
    
    @Autowired
    private Inventory2Repository inventory2Repository;
    
    @RequestMapping("/report")
    public String report(Model model) {
        model.addAttribute("inventories2", inventory2Repository.findAll());
        return "chart/report";
    }
}
