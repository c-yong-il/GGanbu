package com.gg.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.MemberDTO;

@Mapper
public interface LoginMapper {
    
    public MemberDTO loginAction(MemberDTO dto);
    
}
