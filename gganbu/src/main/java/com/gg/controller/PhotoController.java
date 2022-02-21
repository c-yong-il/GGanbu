package com.gg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    
    
    /* 사진첩 버튼 클릭 시 게시글 리스트 출력 */
    @RequestMapping(value="/mini/photo/photo_list/{mem_id}")
    public String listTest(HttpSession session, Model model) {
        
        MemberDTO dto = (MemberDTO)session.getAttribute("loginUser");
        
        
        List<PhotoDTO> list = photoService.listTest(dto.getMem_id());
        
        model.addAttribute("list", list);
        
        return "mini/photo/photo_list";
    }
    
    /* 글쓰기 버튼 클릭 시 글쓰기 화면 출력 */
    @RequestMapping(value="/mini/photo/photo_write/{mem_id}")
    public String write() {
        return "mini/photo/photo_write";
    }

    /* 글쓰기 화면에서 등록 버튼 클릭 시 insert 후 리스트 화면으로 돌아감 */
    @PostMapping("/photoInsert/{mem_id}")
    public String write(HttpSession session, PhotoDTO params) {
        MemberDTO dto = (MemberDTO)session.getAttribute("loginUser");
        params.setMem_id(dto.getMem_id());
        photoService.insertTest(params);
        return "redirect:/mini/photo/photo_list/{mem_id}";
    }

    /* 리스트에서 수정버튼 클릭 시 글수정 화면 출력 */
    @PostMapping(value="/photo_update/{photo_num}")
    public String update(@PathVariable("photo_num") int photo_num, Model model) {
        PhotoDTO params = photoService.selectTest(photo_num);
        model.addAttribute("params", params);
        return "mini/photo/photo_update";
    }

    /* 글수정 화면에서 수정하기 버튼 클릭시 update 실행 후 리스트로 돌아감 */
    @PostMapping("/photoupdate/{mem_id}")
    public String update(PhotoDTO params) {
        photoService.updateTest(params);
        
        return "redirect:/mini/photo/photo_list/{mem_id}";
    }
    
    /* 리스트화면에서 삭제 버튼 클릭 시 delete 실행 */
    @PostMapping(value="/delete/{mem_id}/{photo_num}")
    public String delete(@PathVariable("photo_num") int photo_num, @PathVariable("mem_id") String mem_id, Model model) {
        
            photoService.deleteTest(photo_num);
            
            List<PhotoDTO> list = photoService.listTest(mem_id);
            
            model.addAttribute("list", list);
            
            return "redirect:/mini/photo/photo_list/{mem_id}";

    }
    
}
