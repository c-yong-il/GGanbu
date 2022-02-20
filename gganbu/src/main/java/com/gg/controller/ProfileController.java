package com.gg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gg.service.ProfileService;

@Controller
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping(value = "/mini/profile/profile_update") 
    public String profile(){ 
        return "mini/profile/profile_update"; 
    }
}
