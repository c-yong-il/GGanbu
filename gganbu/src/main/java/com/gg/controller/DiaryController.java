package com.gg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gg.domain.DiaryDTO;
import com.gg.domain.MemberDTO;
import com.gg.service.DiaryService;

@Controller
public class DiaryController {

    @Autowired(required = false)
    private DiaryService diaryService;

    @GetMapping(value = "/mini/diary/diary")
    public String selectDiary(HttpSession session, Model model) {
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");
        DiaryDTO dto2 = diaryService.selectDiary("id");
        model.addAttribute("dto", dto2);
        return "mini/diary/diary";
    }

}
