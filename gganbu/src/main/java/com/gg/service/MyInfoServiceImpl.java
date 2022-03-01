package com.gg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gg.domain.MemberDTO;
import com.gg.mapper.MyInfoMapper;

@Service
public class MyInfoServiceImpl implements MyInfoService {

    @Autowired
    private MyInfoMapper myinfomapper;

    @Autowired
    PasswordEncoder pwdEncoder;

    @Override
    public MemberDTO showInfo(String mem_id) {

        return myinfomapper.showInfo(mem_id);
    }

    @Override
    public int editInfo(MemberDTO dto) {

        String encPassword = pwdEncoder.encode(dto.getMem_pass()); // 암호화
        dto.setMem_pass(encPassword);

        return myinfomapper.editInfo(dto);
    }

    @Override
    public int exitMember(String mem_id) {

        return myinfomapper.exitMember(mem_id);
    }

}
