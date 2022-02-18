package com.gg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public int loginCheck(@RequestParam(required = false) String mem_id, @RequestParam(required = false) String mem_pass, RedirectAttributes rttr, HttpServletRequest request) {
        int result;
    	MemberDTO loginUser = loginService.loginCheck(mem_id, mem_pass);
        HttpSession session = request.getSession();
        
        if(loginUser == null) {
    		session.setAttribute("loginUser", null);
    		rttr.addFlashAttribute("result", "login fail");
    		result = 0; 
    	}else if(loginUser.getMem_status().equals("Y")){
    		session.setAttribute("loginUser", null);
    		rttr.addFlashAttribute("result", "login fail");
    		result = 2; 
    	}else {
    		session.setAttribute("loginUser", loginUser);
    		rttr.addFlashAttribute("result", "login success");
    		result = 1; 
    	}
        
        return result;
    }
    
    /* 아이디 찾기 체크 */
    @ResponseBody
    @RequestMapping(value = "/login/forgotIdCheck", method = RequestMethod.POST)
    public String forgotIdCheck(@RequestParam(required = false) String mem_name, @RequestParam(required = false) String mem_hp, RedirectAttributes rttr, Model model) {
    	String result;
    	String userId = loginService.forgotIdCheck(mem_name, mem_hp);
    	
    	System.out.println("id="+userId);
    	if(userId == null) {
    		model.addAttribute("userId", null);
    		rttr.addFlashAttribute("result", "forgotId fail");
    		result = ""; 
    	}else {
    		model.addAttribute("userId", userId);
    		rttr.addFlashAttribute("result", "forgotId success");
    		result = userId;
    	}
    	
    	return result;
    }
    
}



