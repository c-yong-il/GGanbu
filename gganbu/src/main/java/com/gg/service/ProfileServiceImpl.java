package com.gg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.domain.ProfileDTO;
import com.gg.mapper.ProfileMapper;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileMapper profileMapper;
	
	/* 프로필 등록 */
	@Override
	public int profileInsert(ProfileDTO dto) {
		return profileMapper.profileInsert(dto);
	}
	
	/* 프로필 수정 */
	@Override
	public int profileUpdate(ProfileDTO dto) {
		return profileMapper.profileUpdate(dto);
	}
	
	/* 프로필 조회 */
	@Override
	public ProfileDTO profileSelect(String mem_id) {
		return profileMapper.profileSelect(mem_id);
	}
	
    /* 프로필 체크 */
    public int profileCheck(String mem_id) {
    	return profileMapper.profileCheck(mem_id);
    }
	
}
