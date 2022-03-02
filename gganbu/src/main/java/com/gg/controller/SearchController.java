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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gg.domain.MemberDTO;
import com.gg.service.SearchService;

@Controller
public class SearchController {
    @Autowired
    SearchService searchservice;

    @GetMapping(value = "/search/search")
    public String search() {

        return "search/search";
    }

    /* 깐부신청 눌렀을 때 */
    @ResponseBody
    @RequestMapping(value = "/requestGganbu/{mem_id}")
    public int requestGganbu(@PathVariable("mem_id") String yid, Model model, HttpSession session, RedirectAttributes rttr) {
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");

        int ggCheck = searchservice.ggCheck(dto.getMem_id(), yid);
        int result = -1;
        if (ggCheck == 2) { //insert 
            searchservice.insertGganbu(dto.getMem_id(), yid);
            result = 0;
        } else if (ggCheck == 1) { //이미 깐부관계
            result = 1;
        } else if (ggCheck == 0) { //깐부 수락 대기 중
            result = 2;
        }
        return result;
    }

    /* 검색 버튼 눌렀을 때 */
    @PostMapping(value = "/searchWord")
    public String search(String search, HttpSession session, Model model) {
        //System.out.println("검색어=" + search);
        List<MemberDTO> gglist = searchservice.search(search.trim());
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser"); //로그인유저랑 search해서 나온 사람이랑 깐부인지 확인해서 뷰에 보내려했으나 뷰에서 받으면 이중for문 돼서 거지같아짐

        model.addAttribute("gglist", gglist);

        return "search/search";
    }
}
