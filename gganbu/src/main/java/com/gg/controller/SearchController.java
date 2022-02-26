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

    /* 깐부신청 눌렀을 때 */
    @ResponseBody
    @RequestMapping(value = "/requestGganbu/{mem_id}")
    public int requestGganbu(@PathVariable("mem_id") String yid, Model model, HttpSession session, RedirectAttributes rttr) {
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");
        int result = -1;
        int ggCheck = searchservice.ggCheck(dto.getMem_id(), yid);

        if (ggCheck == 0) { //insert
            searchservice.insertGganbu(dto.getMem_id(), yid);
            result = 0;
            //System.out.println("깐부 신청 insert");
        } else if (ggCheck == 1) {
            result = 1;
            //System.out.println("이미 깐부야!!");
        }
        return result;
    }

    /* 검색 버튼 눌렀을 때 */
    @PostMapping(value = "/searchWord")
    public String search(String search, HttpSession session, Model model) {
        //System.out.println("검색어=" + search);
        List<MemberDTO> gglist = searchservice.search(search.trim());
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser"); //로그인유저랑 search해서 나온 사람이랑 깐부인지 확인해서 뷰에 보내려했으나 뷰에서 받으면 이중for문 돼서 거지같아짐
        //        System.out.println("gglist size=" + gglist.size());
        //        System.out.println("1번=" + gglist.get(0).getMem_id());
        //        System.out.println("2번" + gglist.get(1).getMem_id());
        //        System.out.println("3번" + gglist.get(2).getMem_id());

        //        int ggCheck = -1;
        //        List<Integer> ggCheckList = new ArrayList<>();
        //        if (gglist.size() != 0) {
        //            String myid = dto.getMem_id();
        //            for (int i = 0; i < gglist.size(); i++) {
        //                String yid = gglist.get(i).getMem_id();
        //
        //                ggCheck = searchservice.ggCheck(myid, yid);
        //                ggCheckList.add(ggCheck);
        //            }
        //        }

        //        System.out.println("ggCheck0=" + ggCheckList.get(0));
        //        System.out.println("ggCheck1=" + ggCheckList.get(1));
        //        System.out.println("ggCheck2=" + ggCheckList.get(2));
        //        System.out.println("ggCheck3=" + ggCheckList.get(3));

        //model.addAttribute("ggCheckList", ggCheckList);
        /*
         * System.out.println("id1=" + gglist.get(0).getMem_id());
         * System.out.println("id2=" + gglist.get(0).getMem_id2());
         * System.out.println("관계=" + gglist.get(0).getGganbu_relation());
         * System.out.println("id1=" + gglist.get(1).getMem_id());
         * System.out.println("id2=" + gglist.get(1).getMem_id2());
         * System.out.println("관계=" + gglist.get(1).getGganbu_relation());
         */
        model.addAttribute("gglist", gglist);

        return "search/search";

    }

}
