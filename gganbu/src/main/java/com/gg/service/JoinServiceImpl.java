package com.gg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.domain.MemberDTO;
import com.gg.mapper.JoinMapper;

@Service
public class JoinServiceImpl implements JoinService {

    @Autowired
    private JoinMapper joinmapper;

    @Override
    public int joinProc(MemberDTO dto) {
        int result = 0;

        return result;
    }

    @Override
    public int checkId(String mem_id) {
        int result = joinmapper.checkId(mem_id);
        return result;
    }
}
