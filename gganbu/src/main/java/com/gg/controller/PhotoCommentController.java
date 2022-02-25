package com.gg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        photocommentservice.commentInsert(comment);
        
        return "redirect:/mini/photo/photo_list/{mem_id}";
    }
    
    @PostMapping(value="/cdelete/{mem_id}/{mem_id2}/{photo_comment_num}")
    public String delete(@PathVariable("photo_comment_num") int photo_comment_num, @PathVariable("mem_id2") String mem_id2, @PathVariable("mem_id") String mem_id, Model model) {
        
        photocommentservice.commentDelete(photo_comment_num);
            
        return "redirect:/mini/photo/photo_list/{mem_id}";
    }

   
     

}
