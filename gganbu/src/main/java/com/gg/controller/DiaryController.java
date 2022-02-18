package com.gg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gg.domain.DiaryDTO;
import com.gg.domain.MemberDTO;
import com.gg.service.DiaryService;

@Controller
public class DiaryController {

    @Autowired(required = false)
    private DiaryService diaryService;

    /* 다이어리 메뉴 클릭 시 다이어리 리스트 출력 */
    @RequestMapping(value = "/mini/diary/diary/{mem_id}")
    public String selectDiary(HttpSession session, Model model) {
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");

        //        DiaryDTO dto2 = diaryService.selectDiary(dto.getMem_id());
        //        model.addAttribute("dto", dto2);
        List<DiaryDTO> list = diaryService.selectDiary(dto.getMem_id());
        model.addAttribute("list", list);
        return "mini/diary/diary";
    }

    /* 다이어리 글쓰기 눌렀을 때 글쓰기 폼 상단에 오늘 날짜 넣기 */
    @RequestMapping(value = "/mini/diary/diary_write/{mem_id}")
    public String writeDiary(HttpSession session, Model model) {
        String todayDate = diaryService.now();
        model.addAttribute("todayDate", todayDate);
        return "mini/diary/diary_write";
    }

    /* 다이어리 글쓰기 */
    @PostMapping(value = "/diaryInsert/{mem_id}")
    public String insertDiary(DiaryDTO dto, Model model) {
        int result = diaryService.insertDiary(dto);
        if (result == 1) {
            //            DiaryDTO dto2 = diaryService.selectDiary(dto.getMem_id());
            //            model.addAttribute("dto", dto2);
            List<DiaryDTO> list = diaryService.selectDiary(dto.getMem_id());
            model.addAttribute("list", list);
            return "redirect:/mini/diary/diary/{mem_id}";
        }
        return "mini/diary/diary_write";

    }

    /* 다이어리 수정 버튼 눌렀을 때 화면 이동 */
    @PostMapping(value = "/diary_update/{mem_id}")
    public String updateDiaryMove(@RequestParam int diary_num, Model model) {
        DiaryDTO dto = diaryService.updateDiaryMove(diary_num);
        model.addAttribute("dto", dto);
        return "mini/diary/diary_update";
    }

    /* 다이어리 글 수정->수정완료버튼 눌렀을 때 */
    @PostMapping(value = "/diaryUpdate/{mem_id}")
    public String updateDiary(DiaryDTO dto, Model model) {
        int result = diaryService.updateDiary(dto);
        if (result == 1) {
            //            DiaryDTO dto2 = diaryService.selectDiary(dto.getMem_id());
            //            model.addAttribute("dto", dto2);
            List<DiaryDTO> list = diaryService.selectDiary(dto.getMem_id());
            model.addAttribute("list", list);
            return "redirect:/mini/diary/diary/{mem_id}";
        }
        return "mini/diary/diary_update";
    }

    /* 글쓰기 등록 버튼 클릭 후 리스트 화면으로 이동 */
    //        @RequestMapping(value = "/mini/diary/diary/{mem_id}")
    //        public String insertDiaryFinish() {
    //    
    //        }

}
