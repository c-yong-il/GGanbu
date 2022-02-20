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
	public ProfileDTO profileAction(ProfileDTO dto) {
		return profileMapper.profileAction(dto);
	}
	
}
