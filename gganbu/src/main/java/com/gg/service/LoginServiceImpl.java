package com.gg.service;

import java.util.Random;

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
        MemberDTO matchDTO = loginMapper.loginAction(mem_id);
        MemberDTO anonDTO = new MemberDTO();

        if (matchDTO == null) {
            anonDTO.setMem_id("없는아이디");
            return anonDTO;
        } else if (!pwdEncoder.matches(mem_pass, matchDTO.getMem_pass())) {
            return null;
        }

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

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 8;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        System.out.println(generatedString);

        String newPass = generatedString;

        String encNewPassword = pwdEncoder.encode(newPass); // 암호화
        dto.setMem_pass(encNewPassword);

        System.out.println(dto);

        return loginMapper.forgotPassCheck(dto);

    }

}