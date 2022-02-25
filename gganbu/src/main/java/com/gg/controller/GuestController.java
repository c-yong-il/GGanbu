package com.gg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gg.domain.GuestDTO;
import com.gg.service.GuestService;

@Controller
public class GuestController {

    @Autowired(required = false)
    private GuestService guestService;

    /* 방명록 메뉴 클릭 시 방명록 리스트 출력 */
    @RequestMapping(value = "/mini/guest/guest/{mem_id}")
    public String selectGuest(Model model, @PathVariable("mem_id") String mem_id) {
        LocalDate today = LocalDate.now();
        List<GuestDTO> list = guestService.selectGuest(mem_id);

        model.addAttribute("guestList", list);
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

}
