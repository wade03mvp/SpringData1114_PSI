package com.spring.mvc.psi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/check")
    @ResponseBody
    public String check(@RequestParam("id_token") String id_token) {
        return id_token;
    }
}
