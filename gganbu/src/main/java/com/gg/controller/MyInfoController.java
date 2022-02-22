package com.gg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gg.domain.MemberDTO;
import com.gg.service.MyInfoService;

@Controller
public class MyInfoController {

    @Autowired
    private MyInfoService myinfoservice;

    @RequestMapping(value = "/myinfo/myinfo")
    public String main(HttpSession session, Model model) {
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");
        MemberDTO dto2 = myinfoservice.showInfo(dto.getMem_id());
        model.addAttribute("dto", dto2);
        return "myinfo/myinfo";
    }

    @RequestMapping(value = "/myinfo/exit")
    public String withdrawal(HttpSession session, Model model) {
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");
        System.out.println(dto.getMem_id());
        session.invalidate();
        int delete = myinfoservice.exitMember(dto.getMem_id());
        System.out.println(dto.getMem_status());
        System.out.println(delete);
        return "/main";
    }

    @RequestMapping(value = "myinfo/edit")
    public String update(MemberDTO dto) {
        int edit = myinfoservice.editInfo(dto);
        if (edit == 1) {
            return "/main";
        }
        return "myinfo/edit";
    }

//    @PostMapping(" myinfo/myinfo")
//    public String myinfoAction(MemberDTO dto) {
//        return null;
//        
//    }

}
