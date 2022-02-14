package com.gg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class loginController { 
    
    @RequestMapping(value = "/login/login") 
    public String pop_main(){ 
        return "/login/login"; 
    }
    
}



