package com.gg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.domain.MemberDTO;
import com.gg.mapper.loginMapper;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private loginMapper loginMapper;
	
	@Override
	public MemberDTO loginAction(MemberDTO dto) {
		return loginMapper.loginAction(dto);
	}
}
