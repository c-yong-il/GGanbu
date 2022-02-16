package com.gg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gg.domain.PhotoDTO;
import com.gg.service.PhotoService;

@Controller
public class PhotoController {
    
    @Autowired
    private PhotoService photoService;
    
    
    @GetMapping(value="/photo_list")
    public String listTest(@ModelAttribute("params") PhotoDTO params,Model model) {
        
        List<PhotoDTO> list = photoService.listTest(params.getMem_id());
        
        model.addAttribute("list", list);
        
        return "photo_list";
    }
    
    /*
     * @GetMapping(value="/test2") public String listTest1(String mem_id, Model
     * model) {
     * 
     * model.addAttribute("id",mem_id);
     * 
     * return "test2"; }
     */
    
    
    @GetMapping("/photo_write/{mem_id}")
    public String write() {
        
        return "photo_write";
    }

    // 글을 쓴 뒤 POST 메서드로 글 쓴 내용을 DB에 저장
    // 그 후에는 /list 경로로 리디렉션해준다.
    
    @PostMapping("/photo_write/{mem_id}")
    public String write(PhotoDTO params) {
        photoService.insertTest(params);
        return "redirect:/photo_list";
    }

    
    @GetMapping("/photo_update/{photo_num}")
    public String update(@PathVariable("photo_num") int photo_num, Model model) {
        PhotoDTO params = photoService.selectTest(photo_num);
        model.addAttribute("params", params);
        return "photo_update";
    }


    @PostMapping("/photo_update/{photo_num}")
    public String update(PhotoDTO params) {
        photoService.updateTest(params);
        
        return "redirect:/photo_list";
    }
    
    
    @PostMapping("/delete/{photo_num}")
    public String delete(@PathVariable("photo_num") int photo_num) {
        photoService.deleteTest(photo_num);

        return "redirect:/photo_list";
    }

}
