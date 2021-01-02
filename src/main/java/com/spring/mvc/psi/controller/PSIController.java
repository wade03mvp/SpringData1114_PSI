package com.spring.mvc.psi.controller;

import javax.enterprise.inject.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/psi")
public class PSIController {
    
    public String readProduct(Model model) {
        return "product";
    }
    
}
