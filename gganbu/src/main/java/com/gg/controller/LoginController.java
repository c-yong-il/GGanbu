package com.gg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gg.domain.MemberDTO;
import com.gg.service.LoginService;

@Controller 
@RequestMapping("/login/*")
public class LoginController { 
	
	@Autowired
	private LoginService lservice; 
    
    @RequestMapping(value = "/login/login") 
    public String login(){ 
        return "/login/login"; 
    }
    
    @PostMapping(value = "/login/login") 
    public String loginAction(MemberDTO dto, RedirectAttributes rttr, HttpServletRequest request){ 
    	System.out.println("dto="+dto);
    	MemberDTO loginUser = lservice.loginAction(dto);
    	HttpSession session = request.getSession();
    	
    	System.out.println("user="+loginUser);
    	System.out.println("session="+session);
    	return "/login/login"; 
    }
    
}



