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
	
	@PostMapping(value = "/mini/profile/profile_write/") 
	public String writeProfile(){ 
		return "mini/profile/profile_write/{mem_id}"; 
	}
	
	@PostMapping(value = "/mini/profile/profile_update/*") 
	public String updateProfile(){ 
		return "mini/profile/profile_update/{mem_id}"; 
	}
	
}
