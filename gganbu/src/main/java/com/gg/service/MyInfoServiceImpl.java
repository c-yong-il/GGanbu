package com.gg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.domain.MemberDTO;
import com.gg.mapper.MyInfoMapper;

@Service
public class MyInfoServiceImpl implements MyInfoService{
    
    @Autowired
    private MyInfoMapper myinfomapper;
    
    @Override
    public MemberDTO myinfoAction(MemberDTO dto) {
        return myinfomapper.myinfoAction(dto);
    }

    @Override
    public MemberDTO showInfo(String mem_id) {
        
        return myinfomapper.showInfo(mem_id);
    }

    @Override
    public int editInfo(MemberDTO dto) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int exitMember(String mem_id) {
        
        return myinfomapper.exitMember(mem_id);
    }

}
