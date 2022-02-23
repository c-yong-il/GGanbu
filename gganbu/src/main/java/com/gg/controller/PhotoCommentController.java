package com.gg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gg.domain.PhotoCommentDTO;
import com.gg.service.PhotoCommentService;

@Controller
public class PhotoCommentController {

    @Autowired
    private PhotoCommentService photocommentservice;
    
    @PostMapping(value="/cinsert/{mem_id}/{photo_num}/{mem_id2}")
    public String cinsert(@PathVariable("mem_id") String mem_id, @PathVariable("photo_num") int photo_num, @PathVariable("mem_id2") String mem_id2, PhotoCommentDTO comment) {
       
        System.out.println(comment.getMem_id());
        System.out.println(comment.getPhoto_num());
        System.out.println(comment.getMem_id2());
        
        photocommentservice.commentInsert(comment);
        
        return "redirect:/mini/photo/photo_list/{mem_id}";
    }

   
     

}
