package com.gg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gg.domain.MemberDTO;
import com.gg.service.SearchService;

@Controller
public class SearchController {
    @Autowired
    SearchService searchservice;

    @GetMapping(value = "/search/search")
    public String search(HttpSession session, Model model) {
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");
        //System.out.println(dto.getMem_id());

        //        List<MgmDTO> list = searchservice.gganbuList(dto.getMem_id());

        //        System.out.println("id2=" + list.get(0).getMem_id2());
        //        System.out.println("id2=" + list.get(1).getMem_id2());
        //        System.out.println("리스트사이즈=" + list.size());
        //        for (int i = 0; i < list.size(); i++) {
        //            if (list.get(i).getMem_id().equals(dto.getMem_id())) {
        //                model.addAttribute("mem_id", list.get(i).getMem_id2());
        //                System.out.println("list.get(i).getMem_id2()" + list.get(i).getMem_id2());
        //            } else {
        //                model.addAttribute("mem_id", list.get(i).getMem_id());
        //                System.out.println("list.get(i).getMem_id()" + list.get(i).getMem_id());
        //            }
        //        }
        //        model.addAttribute("list", list);

        return "search/search";
    }

    @RequestMapping(value = "/requestGganbu")
    public String requestGganbu() {
        int result = searchservice.requestGganbu(null);
        return "search/search";
    }

    @PostMapping(value = "/searchWord")
    public String search(String search) {
        System.out.println("검색어=" + search);
        List<MemberDTO> gglist = searchservice.search(search);
        System.out.println("mem=" + gglist.get(0).getMem_id());
        // List<MgmDTO> ggCheck = searchservice.ggCheck();

        return "";
    }

}
