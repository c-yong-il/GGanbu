package com.gg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gg.domain.DiaryDTO;
import com.gg.paging.PaginationInfo;
import com.gg.service.DiaryService;

@Controller
public class DiaryController {

    @Autowired(required = false)
    private DiaryService diaryService;

    /* 다이어리 메뉴 클릭 시 다이어리 리스트 출력 */
    @RequestMapping(value = "/mini/diary/diary/{mem_id}")
    public String selectDiary(Model model, @PathVariable("mem_id") String mem_id, @ModelAttribute("dto") DiaryDTO dto) {

        LocalDate today = LocalDate.now();

        int diaryTotalCount = diaryService.selectDiaryTotalCount(dto);
        PaginationInfo paginationInfo = new PaginationInfo(dto);
        paginationInfo.setTotalRecordCount(diaryTotalCount);

        dto.setPaginationInfo(paginationInfo);
        dto.setMem_id(mem_id);

        List<DiaryDTO> list = diaryService.selectDiary(dto); //내홈피 다이어리 볼 때
        List<DiaryDTO> list2 = diaryService.selectDiary2(dto); //다른 사람 홈피 다이어리 볼 때

        model.addAttribute("diaryList", list);
        model.addAttribute("diaryList2", list2);
        model.addAttribute("today", today);
        model.addAttribute("dto", dto);
        return "mini/diary/diary";
    }

    /* 다이어리 글쓰기 눌렀을 때 글쓰기 폼 상단에 오늘 날짜 넣기 */
    @RequestMapping(value = "/mini/diary/diary_write/{mem_id}")
    public String writeDiary(@PathVariable("mem_id") String mem_id, Model model) {
        String todayDate = diaryService.now();
        model.addAttribute("todayDate", todayDate);
        return "mini/diary/diary_write";
    }

    /* 다이어리 글쓰고 등록 버튼 눌렀을 때 */
    @PostMapping(value = "/diaryInsert/{mem_id}")
    public String insertDiary(@PathVariable("mem_id") String mem_id, DiaryDTO dto, Model model) {
        int result = diaryService.insertDiary(dto);
        if (result == 1) {
            return "redirect:/mini/diary/diary/{mem_id}";
        }
        return "mini/diary/diary_write";
    }

    /* 다이어리 수정 버튼 눌렀을 때 화면 이동 */
    @PostMapping(value = "/diary_update/{mem_id}/{diary_num}")
    public String updateDiaryMove(@PathVariable("diary_num") int diary_num, Model model) {
        DiaryDTO dto = diaryService.updateDiaryMove(diary_num);
        model.addAttribute("dto", dto);
        return "mini/diary/diary_update";
    }

    /* 다이어리 글 수정->수정완료버튼 눌렀을 때 */
    @PostMapping(value = "/diaryUpdate/{mem_id}")
    public String updateDiary(@PathVariable("mem_id") String mem_id, DiaryDTO dto, Model model, RedirectAttributes rttr) {

        int result = diaryService.updateDiary(dto);
        if (result == 1) {
            rttr.addAttribute("diary_num", dto.getDiary_num());
            return "redirect:/showResultDiary/{mem_id}"; // "redirect:/mini/diary/diary/{mem_id}"
        }
        return "mini/diary/diary_update";
    }

    /* 글 수정 완료 후 그 글만 출력 */
    @RequestMapping(value = "/showResultDiary/{mem_id}")
    public String selectResultDiary(@PathVariable("mem_id") String mem_id, @RequestParam("diary_num") int diary_num, Model model) {
        List<DiaryDTO> list = diaryService.selectResultDiary(diary_num);
        LocalDate today = LocalDate.now();
        model.addAttribute("diaryList", list);
        model.addAttribute("today", today);
        return "mini/diary/diary2";
    }

    /* 다이어리 글 삭제 버튼 눌렀을 때 */
    @PostMapping(value = "/diaryDelete/{mem_id}/{diary_num}")
    public String DeleteDiary(@PathVariable("diary_num") int diary_num, @PathVariable("mem_id") String mem_id, Model model) {
        diaryService.deleteDiary(diary_num);
        //if (result == 1) {
        //redirect.addAttribute("diary_num", diary_num);
        //}
        //return "redirect:/showResultDiary/{mem_id}";
        return "redirect:/mini/diary/diary/{mem_id}";
    }

    /* 다이어리 날짜선택 했을 때 */
    @PostMapping(value = "/diarySelect/{mem_id}")
    public String SelectDate(@PathVariable("mem_id") String mem_id, @RequestParam(required = false) String diary_date, Model model) {
        DiaryDTO dto2 = new DiaryDTO();
        dto2.setMem_id(mem_id);
        dto2.setDiary_date(diary_date);
        LocalDate today = LocalDate.now();
        if (!diary_date.equals("")) {
            List<DiaryDTO> list = diaryService.selectDate(dto2);
            model.addAttribute("diaryList", list);
            model.addAttribute("today", today);
        }
        return "mini/diary/diary";
    }

}
