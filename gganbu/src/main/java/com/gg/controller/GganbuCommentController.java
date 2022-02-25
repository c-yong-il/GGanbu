package com.gg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gg.domain.GganbuCommentDTO;
import com.gg.service.GganbuCommentService;

@Controller
public class GganbuCommentController {

    @Autowired
    private GganbuCommentService gganbucommentservice;

//    @RequestMapping(value = "/mini/pop_main/{mem_id}")
//    public String selectGganbuComment(Model model, @PathVariable("mem_id") String mem_id) {
//        model.addAttribute("id", mem_id);
//        List<GganbuCommentDTO> GganbuCommentList = gganbucommentservice.selectGganbuComment(mem_id);
//        model.addAttribute("list", GganbuCommentList);
//        return "mini/pop_main";
//    }

    // mini/pop_main/${mem_id}

    @RequestMapping(value = "/mini/pop_main/deleteGganBuComment/{id}/{mem_id2}")
    public String deleteGganbuComment(@PathVariable("id") String mem_id, @PathVariable("mem_id2") String mem_id2,
            Model model) {
        System.out.println("mem_id2" + mem_id2);
        System.out.println("id1" + mem_id);
        gganbucommentservice.deleteGganbuComment(mem_id2);

        List<GganbuCommentDTO> GganbuCommentList = gganbucommentservice.selectGganbuComment(mem_id);
        model.addAttribute("list", GganbuCommentList);

        System.out.println(mem_id + "login");
        System.out.println(mem_id2 + "writer");
        System.out.println(GganbuCommentList + "list");

        return "/mini/pop_main";
    }

    @RequestMapping(value = "/mini/pop_main/insertORupdateGganbuComment/{id}")
    public String insertORupdateGganbuComment(Model model, @PathVariable("id") String mem_id, GganbuCommentDTO dto) {

        System.out.println("dto=" + dto);

        gganbucommentservice.insertORupdateGganbuComment(dto);

        return "/mini/pop_main";
    }

}
