package com.gg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gg.domain.MemberDTO;
import com.gg.service.JoinService;

@Controller
public class JoinController {
    @Autowired
    private JoinService joinService;

    @GetMapping(value = "/join/join")
    public String pop_main() {
        return "join/join";
    }

    @PostMapping(value = "/join/proc")
    public String registerMember(MemberDTO dto) {
        int result = joinService.joinProc(dto);
        if (result == 0) {
            System.out.println("안들어갔어");
        }
        //        System.out.println(dto.getMem_id());
        //        System.out.println(dto.getMem_pass());
        //        System.out.println(dto.getMem_email1());
        //        System.out.println(dto.getMem_gender());
        return "login/login";
    }

    @ResponseBody
    @RequestMapping(value = "/idCheck", method = RequestMethod.POST)
    public int checkId(@RequestParam String mem_id) {

        int result = joinService.checkId(mem_id);
        return result;
    }

}
