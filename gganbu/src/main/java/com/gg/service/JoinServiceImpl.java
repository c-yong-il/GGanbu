package com.gg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.domain.MemberDTO;
import com.gg.mapper.JoinMapper;

@Service
public class JoinServiceImpl implements JoinService {

    @Autowired
    private JoinMapper joinMapper;

    @Override
    public int joinProc(MemberDTO dto) {
        int result = 0;

        return result;
    }

    @Override
    public int idCheck(String mem_id) {
        System.out.println(mem_id);
        int result = joinMapper.idCheck(mem_id);
        System.out.println(result);
        return result;
    }
}
