package com.gg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gg.domain.MemberDTO;

@Mapper
public interface LoginMapper {

    public MemberDTO loginAction(String mem_id);

    public MemberDTO loginCheck(@Param(value = "mem_id") String mem_id, @Param(value = "mem_pass") String mem_pass);

    public String forgotIdCheck(@Param(value = "mem_name") String mem_name, @Param(value = "mem_hp") String mem_hp);

    public int forgotPassCheck(MemberDTO dto);

    public MemberDTO mailAction(MemberDTO dto);
}
