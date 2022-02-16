package com.gg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gg.domain.MemberDTO;
import com.gg.service.MyInfoService;

@Controller 
public class MyInfoController { 
    
    @Autowired
    private MyInfoService myinfo;

    @RequestMapping(value = "/myinfo/myinfo")
    public String main(HttpSession session, Model model){
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");
        System.out.println(dto.getMem_id());
        MemberDTO dto2 = myinfo.showInfo(dto.getMem_id());
        model.addAttribute("dto", dto2);
        return "myinfo/myinfo"; 
    }
    
    @PostMapping(" myinfo/myinfo")
    public String myinfoAction(MemberDTO dto) {
        return null;
        
    }
    
    
    
}



