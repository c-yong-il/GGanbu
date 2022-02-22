package com.gg.service;

import com.gg.domain.ProfileDTO;

public interface ProfileService {
	/* 프로필 등록 */
	public int profileInsert(ProfileDTO dto);
	
	/* 프로필 수정 */
	public int profileUpdate(ProfileDTO dto);
	
	/* 프로필 조회 */
	public ProfileDTO profileSelect(String mem_id);
	
    /* 프로필 체크 */
    public int profileCheck(String mem_id);
	
}
