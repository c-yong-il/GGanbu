package com.gg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GgController {

    @RequestMapping(value = "/mini/pop_main/{mem_id}")
    public String pop_main(@PathVariable("mem_id") String mem_id, Model model) {

        model.addAttribute("id", mem_id);

        return "mini/pop_main";
    }

    @RequestMapping(value = "/main")
    public String main() {
        return "main";
    }

    @RequestMapping(value = "/mini/profile/profile")
    public String profile() {
        return "mini/profile/profile";
    }

    @RequestMapping(value = "/mini/diary/diary")
    public String diary() {
        return "mini/diary/diary";
    }

    @RequestMapping(value = "/mini/guest/guest")
    public String guest() {
        return "mini/guest/guest";
    }

    @RequestMapping(value = "/mini/photo/photo_list")
    public String photo() {
        return "mini/photo/photo_list";
    }

    @RequestMapping(value = "/mini/upop_main/{mem_id}")
    public String upop_main() {
        return "mini/upop_main/{mem_id}";
    }
}
