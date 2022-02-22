package com.gg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gg.domain.ProfileDTO;
import com.gg.service.ProfileService;

@Controller
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	/* 프로필 메뉴 클릭 - 프로필 불러오고 있으면 프로필 조회 없으면 없는 표시와 등록 버튼 표시 */
	@GetMapping(value = "/mini/profile/profile/{mem_id}")
	public String profileGet(@PathVariable("mem_id") String mem_id, Model model) {
		
		ProfileDTO dto = profileService.profileSelect(mem_id);
		model.addAttribute("id", mem_id);
		model.addAttribute("dto", dto);
		
		return "mini/profile/profile";
	}
	
	/* 프로필 메뉴 클릭 */
    @PostMapping(value = "/mini/profile/profile/{mem_id}")
    public String profilePost(@PathVariable("mem_id") String mem_id, Model model) {
    	
    	ProfileDTO dto = profileService.profileSelect(mem_id);
    	model.addAttribute("id", mem_id);
    	model.addAttribute("dto", dto);
    	
        return "mini/profile/profile";
    }
    
    /* 프로필 글쓰기,수정 화면 이동 - 수정일때는 프로필 불러옴 */
	@PostMapping(value = "/mini/profile/profile_write/{mem_id}") 
	public String writeProfile(@PathVariable("mem_id") String mem_id, Model model){ 
		
		ProfileDTO dto = profileService.profileSelect(mem_id);
		model.addAttribute("id", mem_id);
		if(dto!=null) {
			model.addAttribute("dto", dto);
			return "mini/profile/profile_update"; 
		}else {
			return "mini/profile/profile_write"; 
		}
	}
	
	/* 프로필 작성,수정 후 조회 화면 이동*/
	@PostMapping(value = "/mini/profile/profile_update/{mem_id}") 
	public String updateProfile(@PathVariable("mem_id") String mem_id, ProfileDTO dto, Model model){ 
		int result = 0;
		int checkProfile = profileService.profileCheck(mem_id);
		if(checkProfile==0) {
			result = profileService.profileInsert(dto);
		}else {
			result = profileService.profileUpdate(dto);
		}
		model.addAttribute("id", mem_id);
		model.addAttribute("result", result);
		
		return "redirect:/mini/profile/profile/{mem_id}"; 
	}
	
}
