package com.gg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class ggController { 
    
    @RequestMapping(value = "/mini/pop_main") 
    public String pop_main(){ 
        return "/mini/pop_main"; 
    }

    @RequestMapping(value = "/main") 
    public String main(){ 
        return "main"; 
    }
    
    @RequestMapping(value = "/mini/profile") 
    public String profile(){ 
        return "/mini/profile"; 
    }
    
    @RequestMapping(value = "/mini/diary") 
    public String diary(){ 
        return "/mini/diary"; 
    }
    
    @RequestMapping(value = "/mini/guest") 
    public String guest(){ 
        return "/mini/guest"; 
    }
    
    @RequestMapping(value = "/mini/photo") 
    public String photo(){ 
        return "/mini/photo"; 
    }
}



