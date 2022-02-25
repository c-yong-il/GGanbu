package com.gg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gg.domain.GuestDTO;
import com.gg.service.GuestService;

@Controller
public class GuestController {

    @Autowired(required = false)
    private GuestService guestService;

    @RequestMapping(value = "/mini/guest/guest/{mem_id}")
    public String selectGuest(Model model, @PathVariable("mem_id") String mem_id) {

        List<GuestDTO> list = guestService.selectGuest(mem_id);

        model.addAttribute("guestList", list);

        return "mini/guest/guest";
    }

}
