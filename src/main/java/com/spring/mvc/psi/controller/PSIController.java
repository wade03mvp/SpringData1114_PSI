package com.spring.mvc.psi.controller;

import com.spring.mvc.psi.entities.Product;
import com.spring.mvc.psi.entities.User;
import com.spring.mvc.psi.repository.Inventory2Repository;
import com.spring.mvc.psi.repository.InventoryRepository;
import com.spring.mvc.psi.repository.ProductRepository;
import com.spring.mvc.psi.repository.PurchasetRepository;
import com.spring.mvc.psi.repository.SalesRepository;
import com.spring.mvc.psi.repository.UserRepository;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/psi")
public class PSIController {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PurchasetRepository purchasetRepository;
    
    @Autowired
    private SalesRepository salesRepository;
    
    @Autowired
    private InventoryRepository inventoryRepository;
    
    @Autowired
    private Inventory2Repository inventory2Repository;
    
    
    @GetMapping(value = {"/product", "/product/{id}", "/product/{name}/{id}"})
    public String readProduct(Model model, 
            @PathVariable Optional<Integer> id,
            @PathVariable Optional<String> name) {
        String _method = "POST";
        Product product = new Product();
        if(id.isPresent()) {
            product = productRepository.findOne(id.get());
            _method = "PUT";
            if(name.isPresent() && name.get().equals("delete")) {
                _method = "DELETE";
            }
        }
        model.addAttribute("_method", _method);
        model.addAttribute("product", product);
        model.addAttribute("products", productRepository.findAll());
        return "product";
    }
    
    @PostMapping(value = {"/product"})
    public String createProduct(@ModelAttribute("product") Product product, HttpSession session) {
        // 取得操作的使用者
        User user = userRepository.getByName(session.getAttribute("username")+"");
        product.setUser(user);
        // 將資料存入
        productRepository.save(product);
        // 重導頁面
        return "redirect: ./product";
    }
    
    @PutMapping(value = {"/product"})
    public String updateProduct(@ModelAttribute("product") Product product, HttpSession session) {
        // 取得操作的使用者
        User user = userRepository.getByName(session.getAttribute("username")+"");
        product.setUser(user);
        // 修改資料
        productRepository.saveAndFlush(product);
        // 重導頁面
        return "redirect: ./product";
    }
    
    @DeleteMapping(value = {"/product"})
    public String deleteProduct(@ModelAttribute("product") Product product) {
        // 刪除資料
        productRepository.delete(product.getId());
        // 重導頁面
        return "redirect: ./product";
    }
    
    // 讀取進貨
    @GetMapping(value = {"/purchase"})
    public String readPurchase(Model model) {
        model.addAttribute("purchases", purchasetRepository.findAll());
        model.addAttribute("inventories2", inventory2Repository.findAll());
        return "purchase";
    }
    
    
    
}
