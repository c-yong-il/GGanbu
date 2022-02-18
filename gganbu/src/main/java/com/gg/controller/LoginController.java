package com.gg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gg.domain.MemberDTO;
import com.gg.service.LoginService;

@Controller 
@RequestMapping/*("/login/*")*/
public class LoginController { 
	
	@Autowired
	private LoginService loginService; 
    
    @GetMapping(value = "/login/login") 
    public String login(){ 
        return "/login/login"; 
    }
    @GetMapping(value = "/login/forgotId") 
    public String forgotId(){ 
    	return "/login/forgotId"; 
    }
    @GetMapping(value = "/login/forgotPass") 
    public String forgotPass(){ 
    	return "/login/forgotPass"; 
    }
    
    @GetMapping(value = "/logout") 
    public String logoutAction(HttpSession session){ 
    	session.invalidate();
    	return "main"; 
    }
    
    /*
    @PostMapping(value = "/login/login") 
    public String loginAction(MemberDTO dto, RedirectAttributes rttr, HttpServletRequest request){ 
    	MemberDTO loginUser = loginService.loginAction(dto);
    	HttpSession session = request.getSession();
    	
    	if(loginUser==null) {
    		session.setAttribute("loginUser", null);
    		rttr.addFlashAttribute("result", "login fail");
    		return "redirect:/login/login"; 
    	}else {
    		session.setAttribute("loginUser", loginUser);
    		rttr.addFlashAttribute("result", "login success");
    		return "redirect:/main"; 
    	}
    }
    */
    
    /* 로그인 체크 */
    @ResponseBody
    @RequestMapping(value = "/login/loginCheck", method = RequestMethod.POST)
    public int loginCheck(@RequestParam String mem_id, @RequestParam String mem_pass, RedirectAttributes rttr, HttpServletRequest request) {
        int result;
    	MemberDTO loginUser = loginService.loginCheck(mem_id, mem_pass);
        HttpSession session = request.getSession();
        
        if(loginUser == null) {
    		session.setAttribute("loginUser", null);
    		rttr.addFlashAttribute("result", "login fail");
    		result = 0; 
    	}else {
    		session.setAttribute("loginUser", loginUser);
    		rttr.addFlashAttribute("result", "login success");
    		result = 1; 
    	}
        
        return result;
    }
    
}



