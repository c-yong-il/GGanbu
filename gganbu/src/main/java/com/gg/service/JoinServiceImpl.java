package com.gg.service;

import org.springframework.beans.factory.annotation.Autowired;
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

        String encPassword = pwdEncoder.encode(dto.getMem_pass()); // 암호화
        dto.setMem_pass(encPassword);

        int result = joinmapper.joinProc(dto);
        return result;
    }

    @Override
    public int checkId(String mem_id) {
        int result = joinmapper.checkId(mem_id);
        return result;
    }

}
