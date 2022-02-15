package com.gg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class LoginController { 
    
    @RequestMapping(value = "/login/login") 
    public String pop_main(){ 
        return "/login/login"; 
    }
    
}



