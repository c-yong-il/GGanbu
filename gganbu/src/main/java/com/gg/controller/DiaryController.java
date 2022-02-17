package com.gg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gg.domain.DiaryDTO;
import com.gg.domain.MemberDTO;
import com.gg.service.DiaryService;

@Controller
public class DiaryController {

    @Autowired(required = false)
    private DiaryService diaryService;

    @RequestMapping(value = "/mini/diary/diary/{mem_id}")
    public String selectDiary(HttpSession session, Model model) {
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");

        DiaryDTO dto2 = diaryService.selectDiary(dto.getMem_id());
        model.addAttribute("dto", dto2);
        return "mini/diary/diary";
    }

    @RequestMapping(value = "/mini/diary/diary_write/{mem_id}")
    public String writeDiary(HttpSession session, Model model) {

        String todayDate = diaryService.now();
        model.addAttribute("todayDate", todayDate);
        return "mini/diary/diary_write";
    }

}
