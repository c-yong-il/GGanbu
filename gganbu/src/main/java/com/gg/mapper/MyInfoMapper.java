package com.gg.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.MemberDTO;

@Mapper
public interface MyInfoMapper {

    public MemberDTO showInfo(String mem_id);

    public int editInfo(MemberDTO dto);

    public int exitMember(String mem_id);

}
