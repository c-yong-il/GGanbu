package com.gg.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gg.domain.GuestDTO;
import com.gg.domain.MemberDTO;
import com.gg.paging.PaginationInfo;
import com.gg.service.GuestService;

@Controller
public class GuestController {

    @Autowired(required = false)
    private GuestService guestService;

    /* 방명록 메뉴 클릭 시 방명록 리스트 출력 */
    @RequestMapping(value = "/mini/guest/guest/{mem_id}")
    public String selectGuest(Model model, @PathVariable("mem_id") String mem_id, HttpSession session,
            @ModelAttribute("params") GuestDTO params) {
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");

        params.setMem_id2(dto.getMem_id());

        LocalDate today = LocalDate.now();

        int guestTotalCount = guestService.selectGuestTotalCount(params);
        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(guestTotalCount);

        params.setPaginationInfo(paginationInfo);

        params.setMem_id(mem_id);

        List<GuestDTO> list = guestService.selectGuest(params);
        List<GuestDTO> list2 = guestService.selectGuest2(params);

        model.addAttribute("params", params);
        model.addAttribute("guestList", list);
        model.addAttribute("guestList2", list2);
        model.addAttribute("today", today);

        return "mini/guest/guest";
    }

    /* 방명록 글쓰고 등록 버튼 눌렀을 때 */
    @PostMapping(value = "/guestInsert/{mem_id}/{mem_id2}")
    public String insertGuest(@PathVariable("mem_id") String mem_id, @PathVariable("mem_id2") String mem_id2,
            GuestDTO dto, Model model) {
        int result = guestService.insertGuest(dto);
        if (result == 1) {
            return "redirect:/mini/guest/guest/{mem_id}";
        }
        return "mini/guest/guest_write";
    }

    /* 방명록 글쓰기 눌렀을 때 (글쓰기 폼 상단에 오늘 날짜 넣는거 포함) */
    @RequestMapping(value = "/mini/guest/guest_write/{mem_id}/{mem_id2}")
    public String writeGuest(@PathVariable("mem_id") String mem_id, @PathVariable("mem_id2") String mem_id2,
            Model model) {

        String todayDate = guestService.now();

        model.addAttribute("todayDate", todayDate);
        return "mini/guest/guest_write";
    }

    /* 방명록 수정 버튼 눌렀을 때 화면 이동 */
    @PostMapping(value = "/guest_update/{mem_id}/{book_num}")
    public String updateGuestMove(@PathVariable("book_num") int book_num, Model model) {
        GuestDTO dto = guestService.updateGuestMove(book_num);
        model.addAttribute("dto", dto);
        return "mini/guest/guest_update";
    }

    /* 방명록 글 수정에서 수정완료버튼 눌렀을 때 */
    @PostMapping(value = "/guestUpdate/{mem_id}")
    public String updateGuest(@PathVariable("mem_id") String mem_id, GuestDTO dto, Model model,
            RedirectAttributes rttr) {

        int result = guestService.updateGuest(dto);
        if (result == 1) {
            rttr.addAttribute("book_num", dto.getBook_num());
            return "redirect:/mini/guest/guest/{mem_id}";
        }
        return "mini/guest/guest";
    }

    /* 방명록 글 중 삭제 버튼 눌렀을 때 */
    @PostMapping(value = "/guestDelete/{mem_id}/{book_num}")
    public String DeleteGuest(@PathVariable("book_num") int book_num, @PathVariable("mem_id") String mem_id,
            Model model, RedirectAttributes redirect) {
        int result = guestService.deleteGuest(book_num);
        if (result == 1) {
            redirect.addAttribute("book_num", book_num);
        }
        return "redirect:/mini/guest/guest/{mem_id}";
    }

}
