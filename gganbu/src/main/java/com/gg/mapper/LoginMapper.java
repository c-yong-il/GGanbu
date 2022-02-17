package com.gg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gg.domain.MemberDTO;

@Mapper
public interface LoginMapper {
    
    public MemberDTO loginAction(MemberDTO dto);
    
    public MemberDTO loginCheck(@Param(value = "mem_id") String mem_id, @Param(value = "mem_pass")String mem_pass);
    
}
