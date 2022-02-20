package com.gg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gg.service.PhotoCommentService;

@Controller
public class PhotoCommentController {
    
    @Autowired
    private PhotoCommentService photocommentservice;
    
    /*
     * @RequestMapping(value="/mini/photo/photo_list/{mem_id}") private String
     * photocommentList(String mem_id, int photo_num, Model model){
     * List<PhotoCommentDTO> list = photocommentservice.commentList(mem_id,
     * photo_num);
     * 
     * model.addAttribute("list", list);
     * 
     * return "mini/photo/photo_list"; }
     */

}
