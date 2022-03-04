package com.gg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gg.domain.MemberDTO;
import com.gg.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/login/login")
    public String login() {
        return "/login/login";
    }

    @GetMapping(value = "/login/forgotId")
    public String forgotId() {
        return "/login/forgotId";
    }

    @GetMapping(value = "/login/forgotPass")
    public String forgotPass() {
        return "/login/forgotPass";
    }

    @GetMapping(value = "/logout/logout")
    public String logoutAction(HttpSession session) {
        session.invalidate();
        return "main";
    }

    /* 로그인 체크 */
    @ResponseBody
    @PostMapping(value = "/login/loginCheck")
    public int loginCheck(@RequestParam(required = false) String mem_id,
            @RequestParam(required = false) String mem_pass, RedirectAttributes rttr, HttpServletRequest request) {
        int result;
        MemberDTO loginUser = loginService.loginAction(mem_id);
        int resultCheck = loginService.loginCheck(mem_id, mem_pass);
        HttpSession session = request.getSession();
        
        if (resultCheck == 0) {	//아이디 혹은 비밀번호가 일치하지 않습니다
            session.setAttribute("loginUser", null);
            rttr.addFlashAttribute("result", "login fail");
            result = 0;
        } else if (resultCheck==2) {	//존재하지 않는 아이디입니다
            session.setAttribute("loginUser", null);
            rttr.addFlashAttribute("result", "login fail");
            result = 3;
        } else if (loginUser.getMem_status().equals("Y")) {	//탈퇴한 회원입니다
            session.setAttribute("loginUser", null);
            rttr.addFlashAttribute("result", "login fail");
            result = 2;
        } else {	//로그인 성공
            session.setAttribute("loginUser", loginUser);
            rttr.addFlashAttribute("result", "login success");
            result = 1;
        }

        return result;
    }

    /* 아이디 찾기 체크 */
    @ResponseBody
    @PostMapping(value = "/login/forgotIdCheck")
    public String forgotIdCheck(@RequestParam(required = false) String mem_name,
            @RequestParam(required = false) String mem_hp, RedirectAttributes rttr, Model model) {
        String result;
        String userId = loginService.forgotIdCheck(mem_name, mem_hp);

        if (userId == null) {
            model.addAttribute("userId", null);
            rttr.addFlashAttribute("result", "forgotId fail");
            result = "";
        } else {
            model.addAttribute("userId", userId);
            rttr.addFlashAttribute("result", "forgotId success");
            result = userId;
        }

        return result;
    }

    /* 비밀번호 찾기 체크 */
    @ResponseBody
    @PostMapping(value = "/login/forgotPassCheck")
    public int forgotPassCheck(MemberDTO dto, RedirectAttributes rttr, Model model) {
        int result;
        int userPass = loginService.forgotPassCheck(dto);

        if (userPass == 0) {
            model.addAttribute("userPass", null);
            rttr.addFlashAttribute("result", "forgotId fail");
            result = 0;
        } else {
            model.addAttribute("userPass", userPass);
            rttr.addFlashAttribute("result", "forgotId success");
            result = userPass;
        }

        return result;
    }

}
