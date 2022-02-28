package com.gg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gg.domain.MemberDTO;
import com.gg.mapper.JoinMapper;

@Service
public class JoinServiceImpl implements JoinService {

    @Autowired
    private JoinMapper joinmapper;

    @Autowired
    PasswordEncoder pwdEncoder;

    @Override
    public int joinProc(MemberDTO dto) throws Exception {

        System.out.println("joinProc서비스시작");

        System.out.println("암호화전 비밀번호 : " + dto.getMem_pass());

        String encPassword = pwdEncoder.encode(dto.getMem_pass()); // 암호화
        dto.setMem_pass(encPassword);

        System.out.println("암호화된 비밀번호 : " + dto.getMem_pass());

        int result = joinmapper.joinProc(dto);
        return result;
    }

    @Override
    public int checkId(String mem_id) {
        int result = joinmapper.checkId(mem_id);
        return result;
    }

    @Override
    public boolean pwdInsert(MemberDTO dto) {

        try {
            System.out.println("이메일" + dto.getMem_email1());

            PasswordEncoder bCryptPasswordEncoder = pwdEncoder();

        } catch (Exception e) {
            // TODO: handle exception
        }

        return false;
    }

    private BCryptPasswordEncoder pwdEncoder() {
        // TODO Auto-generated method stub
        return null;
    };
}
