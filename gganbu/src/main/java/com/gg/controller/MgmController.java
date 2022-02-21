package com.gg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gg.service.MgmService;

@Controller
public class MgmController {
    
    @Autowired
    private MgmService mgmservice;
    
    @GetMapping(value = "/mgm/mgm")
    public String join() {
        return "mgm/mgm";
    }
    
    

}
