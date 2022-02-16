package com.gg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gg.domain.MemberDTO;

@Controller 
public class MyInfoController { 

    @RequestMapping(value = "/myinfo/myinfo") 
    public String main(){ 
        return "myinfo/myinfo"; 
    }
    
    @PostMapping(" myinfo/myinfo")
    public String myinfoAction(MemberDTO dto) {
        return null;
        
    }
    
    
    
}



