package com.gg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gg.domain.MemberDTO;
import com.gg.domain.MgmDTO;
import com.gg.service.MgmService;

@Controller
public class MgmController {
    
    @Autowired
    private MgmService mgmservice;
    
    
    @GetMapping(value = "/mgm/mgm")
    public String mgm(Model model, HttpSession session) {
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");
        System.out.println(dto.getMem_id());
        
        List<MgmDTO> list = mgmservice.gglist(dto.getMem_id());
        
        System.out.println(list);
        
        model.addAttribute("list", list);
        
        return "mgm/mgm";
    }
    
    @GetMapping(value = "/mini/pop_main1/{mem_id2}")
    public String pop_main(@PathVariable("mem_id2") String mem_id2) {
        
        return "mini/pop_main";
    }
    
    @GetMapping(value = "/mini/pop_main1/{mem_id}")
    public String pop_main2(@PathVariable("mem_id") String mem_id) {
        
        return "mini/pop_main";
    }
    
    
    @GetMapping(value = "/search/search")
    public String search() {
        return "search/search";
    }
    
    

}
