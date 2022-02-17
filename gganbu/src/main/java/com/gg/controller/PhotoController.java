package com.gg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gg.domain.MemberDTO;
import com.gg.domain.PhotoDTO;
import com.gg.service.PhotoService;

@Controller
public class PhotoController {
    
    @Autowired
    private PhotoService photoService;
    
    @RequestMapping(value="/mini/photo/photo_list/{mem_id}")
    public String listTest(HttpSession session,PhotoDTO params, Model model) {
        
        MemberDTO dto = (MemberDTO)session.getAttribute("loginUser");
        
        params.setMem_id(dto.getMem_id());
        
        List<PhotoDTO> list = photoService.listTest(params.getMem_id());
        
        model.addAttribute("dto", dto);
        model.addAttribute("list", list);
        
        return "mini/photo/photo_list";
    }
    
    
    @GetMapping("/mini/photo/photo_write/{mem_id}")
    public String write() {
        
        return "mini/photo/photo_write";
    }

    // 글을 쓴 뒤 POST 메서드로 글 쓴 내용을 DB에 저장
    // 그 후에는 /list 경로로 리디렉션해준다.
    
    @PostMapping("/mini/photo/photo_write/{mem_id}")
    public String write(PhotoDTO params) {
        photoService.insertTest(params);
        return "redirect:/mini/photo/photo_list";
    }

    
    @GetMapping("/mini/photo/photo_update/{photo_num}")
    public String update(@PathVariable("photo_num") int photo_num, Model model) {
        PhotoDTO params = photoService.selectTest(photo_num);
        model.addAttribute("params", params);
        return "mini/photo/photo_update";
    }


    @PostMapping("/mini/photo/photo_update/{photo_num}")
    public String update(PhotoDTO params) {
        photoService.updateTest(params);
        
        return "redirect:/mini/photo/photo_list";
    }
    
    
    @PostMapping("/mini/photo/delete/{photo_num}")
    public String delete(@PathVariable("photo_num") int photo_num) {
        photoService.deleteTest(photo_num);

        return "redirect:/mini/photo/photo_list";
    }

}
