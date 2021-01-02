package com.spring.mvc.psi.controller;

import com.spring.mvc.psi.entities.Product;
import com.spring.mvc.psi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/psi")
public class PSIController {
    
    @Autowired
    private ProductRepository productRepository;
    
    @GetMapping(value = {"/product"})
    public String readProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product";
    }
    
    @PostMapping(value = {"/product"})
    public String createProduct(@ModelAttribute("product") Product product) {
        // 將資料存入
        productRepository.save(product);
        
        // 重導頁面
        return "redirect: ./product";
    }
    
    
}
