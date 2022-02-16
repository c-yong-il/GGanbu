package com.gg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GgController {

    @RequestMapping(value = "/mini/pop_main")
    public String pop_main() {
        return "/mini/pop_main";
    }

    @RequestMapping(value = "/main")
    public String main() {
        return "main";
    }

    @RequestMapping(value = "/mini/profile/profile")
    public String profile() {
        return "/mini/profile/profile";
    }

    @RequestMapping(value = "/mini/diary/diary")
    public String diary() {
        return "/mini/diary/diary";
    }

    @RequestMapping(value = "/mini/guest/guest")
    public String guest() {
        return "/mini/guest/guest";
    }

    @RequestMapping(value = "/mini/photo/photo_list")
    public String photo() {
        return "/mini/photo/photo_list";
    }
}
