package com.gg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class InfoController { 

    @RequestMapping(value = "/info_update/info_update") 
    public String main(){ 
        return "info_update/info_update"; 
    }
    
}



