package com.gg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

        List<MgmDTO> list = mgmservice.gglist(dto.getMem_id());

        model.addAttribute("list", list);

        return "mgm/mgm";
    }
    
    @PostMapping(value = "/quit/{mem_id}/{mem_id2}")
    public String mgmQuit(@PathVariable("mem_id") String mem_id, @PathVariable("mem_id2") String mem_id2, Model model) {
        System.out.println(mem_id+mem_id2);
        mgmservice.MgmQuit(mem_id,mem_id2);
        
        return "redirect:/mgm/mgm";
    }


}
