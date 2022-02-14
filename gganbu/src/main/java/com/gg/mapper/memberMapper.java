package com.gg.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.memberDTO;

@Mapper
public interface memberMapper {
    
    public memberDTO selectInfo(String mem_id);
    
}
