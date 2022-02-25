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

    /* 내정보수정 클릭 시 내정보 출력 */
    @RequestMapping(value = "/myinfo/myinfo")
    public String print(HttpSession session, Model model) {
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");
        MemberDTO dto2 = myinfoservice.showInfo(dto.getMem_id());
        model.addAttribute("dto", dto2);
        return "myinfo/myinfo";
    }

    /* 탈퇴버튼 클릭 시 탈퇴 */
    @RequestMapping(value = "/myinfo/exit")
    public String withdrawal(HttpSession session, Model model) {
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");
        session.invalidate();
        int delete = myinfoservice.exitMember(dto.getMem_id());
        if (delete == 1) {
            return "/main";
        }
        return "myinfo/exit";
    }

    /* 수정버튼 클릭 시 수정 */
    @RequestMapping(value = "myinfo/edit")
    public String update(MemberDTO dto) {
        int edit = myinfoservice.editInfo(dto);
        if (edit == 1) {
            return "/main";
        }
        return "myinfo/edit";
    }

}
