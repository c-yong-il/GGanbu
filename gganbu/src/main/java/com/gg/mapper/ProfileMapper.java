package com.gg.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.ProfileDTO;

@Mapper
public interface ProfileMapper {
    /* 프로필 등록 */
    public ProfileDTO profileAction(ProfileDTO dto);
    
}
