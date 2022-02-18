package com.gg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.domain.MemberDTO;
import com.gg.mapper.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public MemberDTO loginAction(MemberDTO dto) {
		return loginMapper.loginAction(dto);
	}
	
	@Override
	public MemberDTO loginCheck(String mem_id, String mem_pass) {
		return loginMapper.loginCheck(mem_id, mem_pass);
	}
	
	@Override
	public MemberDTO forgotIdCheck(String mem_name, String mem_hp) {
		return loginMapper.forgotIdCheck(mem_name, mem_hp);
	}
}
