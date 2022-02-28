package com.gg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gg.domain.MemberDTO;
import com.gg.mapper.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    PasswordEncoder pwdEncoder;

    /* 로그인 임시 */
    @Override
    public MemberDTO loginAction(String mem_id) {
        return loginMapper.loginAction(mem_id);
    }

    /* 로그인 */
    @Override
    public MemberDTO loginCheck(String mem_id, String mem_pass) {
        System.out.println("로그인시작");
        System.out.println("아이디= " + mem_id + "pass= " + mem_pass);

        MemberDTO matchDTO = loginMapper.loginAction(mem_id);

        System.out.println("dto= " + matchDTO);

        if (!pwdEncoder.matches(mem_pass, matchDTO.getMem_pass())) {
            System.out.println("로그인 실패");
        }
        System.out.println("2아이디= " + mem_id + "2pass= " + mem_pass);
        System.out.println("이게 되냐?= " + matchDTO.getMem_pass());
        return loginMapper.loginCheck(mem_id, matchDTO.getMem_pass());
    }

    /* 아이디 찾기 */
    @Override
    public String forgotIdCheck(String mem_name, String mem_hp) {
        return loginMapper.forgotIdCheck(mem_name, mem_hp);
    }

    /* 비밀번호 찾기 */
    @Override
    public String forgotPassCheck(MemberDTO dto) {
        return loginMapper.forgotPassCheck(dto);
    }
}
