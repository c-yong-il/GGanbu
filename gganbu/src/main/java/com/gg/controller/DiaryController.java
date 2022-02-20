package com.gg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("diaryList", list);
        return "mini/diary/diary";
    }

    /* 다이어리 글쓰기 눌렀을 때 글쓰기 폼 상단에 오늘 날짜 넣기 */
    @RequestMapping(value = "/mini/diary/diary_write/{mem_id}")
    public String writeDiary(HttpSession session, Model model) {
        String todayDate = diaryService.now();
        model.addAttribute("todayDate", todayDate);
        return "mini/diary/diary_write";
    }

    /* 다이어리 글쓰고 등록 버튼 눌렀을 때 */
    @PostMapping(value = "/diaryInsert/{mem_id}")
    public String insertDiary(DiaryDTO dto, Model model) {
        int result = diaryService.insertDiary(dto);
        if (result == 1) {
            //            DiaryDTO dto2 = diaryService.selectDiary(dto.getMem_id());
            //            model.addAttribute("dto", dto2);

            //            List<DiaryDTO> list = diaryService.selectDiary(dto.getMem_id());
            //            model.addAttribute("list", list);
            return "redirect:/mini/diary/diary/{mem_id}";
        }
        return "mini/diary/diary_write";

    }

    /* 다이어리 수정 버튼 눌렀을 때 화면 이동 */
    @PostMapping(value = "/diary_update/{diary_num}")
    public String updateDiaryMove(@PathVariable("diary_num") int diary_num, Model model) {
        DiaryDTO dto = diaryService.updateDiaryMove(diary_num);
        model.addAttribute("dto", dto);
        return "mini/diary/diary_update";
    }

    /* 다이어리 글 수정->수정완료버튼 눌렀을 때 */
    @PostMapping(value = "/diaryUpdate/{mem_id}")
    public String updateDiary(DiaryDTO dto, Model model, RedirectAttributes redirect) {
        int result = diaryService.updateDiary(dto);
        if (result == 1) {
            redirect.addAttribute("diary_num", dto.getDiary_num());
            //redirect.addAttribute("mem_id", dto.getMem_id());
            return "redirect:/showResultDiary/{mem_id}"; // "redirect:/mini/diary/diary/{mem_id}"
        }
        return "mini/diary/diary_update";
    }

    /* 글 수정이나 삭제 눌렀을 때 그 글만 출력(즉, 삭제는 화면에 띄워지는게 없음) */
    @RequestMapping(value = "/showResultDiary/{mem_id}")
    public String selectResultDiary(@RequestParam("diary_num") int diary_num, Model model) {
        List<DiaryDTO> list = diaryService.selectResultDiary(diary_num);
        model.addAttribute("diaryList", list);
        return "mini/diary/diary2";
    }

    /* 다이어리 글 삭제 버튼 눌렀을 때 */
    @PostMapping(value = "/diaryDelete/{mem_id}/{diary_num}")
    public String DeleteDiary(@PathVariable("diary_num") int diary_num, @PathVariable("mem_id") String mem_id, Model model,
            RedirectAttributes redirect) {
        int result = diaryService.deleteDiary(diary_num);
        if (result == 1) {
            redirect.addAttribute("diary_num", diary_num);
        }
        return "redirect:/showResultDiary/{mem_id}";
        // return "redirect:/mini/diary/diary/{mem_id}";
    }

    /* 다이어리 날짜선택 했을 때 */
    @PostMapping(value = "/diarySelect/{mem_id}")
    public String SelectDate(@RequestParam(required = false) String diary_date, HttpSession session, Model model) {
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");
        DiaryDTO dto2 = new DiaryDTO();
        dto2.setMem_id(dto.getMem_id());
        dto2.setDiary_date(diary_date);
        if (!diary_date.equals("")) {
            List<DiaryDTO> list = diaryService.selectDate(dto2);
            model.addAttribute("diaryList", list);
        }
        return "mini/diary/diary";
    }

}
