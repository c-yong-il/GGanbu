package com.gg.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.MemberDTO;

@Mapper
public interface MemberMapper {
    
    public MemberDTO selectInfo(String mem_id);
    
}
