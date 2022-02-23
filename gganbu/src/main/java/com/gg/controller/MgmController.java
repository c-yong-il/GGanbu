package com.gg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gg.domain.MemberDTO;
import com.gg.domain.MgmDTO;
import com.gg.service.MgmService;

@Controller
public class MgmController {

    @Autowired
    private MgmService mgmservice;

    @GetMapping(value = "/mgm/mgm")
    public String mgm(Model model, HttpSession session) {
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");

        List<MgmDTO> list = mgmservice.gglist(dto.getMem_id()); //깐부관계일때

        List<MgmDTO> wait = mgmservice.ggwait(dto.getMem_id()); //깐부요청대기일때

        model.addAttribute("list", list);
        model.addAttribute("wait", wait);

        return "mgm/mgm";
    }

    /* 깐부 수락 했을 때 */
    @RequestMapping(value = "/acceptGganbu/{mem_id}")
    public String acceptGganbu(@PathVariable("mem_id") String mem_id, HttpSession session) {
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");
        String myid = dto.getMem_id();
        String yid = mem_id;
        mgmservice.MgmAccept(myid, yid);

        return "redirect:/mgm/mgm";
    }

    /* 깐부 거절 or 끊기 눌렀을 때 */
    @RequestMapping(value = "/refuseGganbu/{mem_id}")
    public String refuseGganbu(@PathVariable("mem_id") String mem_id, HttpSession session) {
        MemberDTO dto = (MemberDTO) session.getAttribute("loginUser");
        String myid = dto.getMem_id();
        String yid = mem_id;
        mgmservice.MgmRefuse(myid, yid);
        return "redirect:/mgm/mgm";
    }

}
