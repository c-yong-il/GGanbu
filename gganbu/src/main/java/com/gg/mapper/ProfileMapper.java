package com.gg.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.ProfileDTO;

@Mapper
public interface ProfileMapper {
    /* 프로필 등록 */
    public int profileInsert(ProfileDTO dto);
    
    /* 프로필 수정 */
    public int profileUpdate(ProfileDTO dto);
    
    /* 프로필 조회 */
    public ProfileDTO profileSelect(String mem_id);
    
    /* 프로필 체크 */
    public int profileCheck(String mem_id);
    
}
