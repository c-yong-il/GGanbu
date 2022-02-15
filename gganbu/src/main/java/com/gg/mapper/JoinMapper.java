package com.gg.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.MemberDTO;

@Mapper
public interface JoinMapper {
    public int joinProc(MemberDTO dto);

    public int idCheck(String mem_id);

}
