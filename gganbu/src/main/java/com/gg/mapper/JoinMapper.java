package com.gg.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.MemberDTO;

@Mapper
public interface JoinMapper {

    public int joinProc(MemberDTO dto);

    public int checkId(String mem_id);

}
