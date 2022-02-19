package com.gg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.domain.MemberDTO;
import com.gg.mapper.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	/* 로그인 임시*/
	@Override
	public MemberDTO loginAction(MemberDTO dto) {
		return loginMapper.loginAction(dto);
	}
	
	/* 로그인 */
	@Override
	public MemberDTO loginCheck(String mem_id, String mem_pass) {
		return loginMapper.loginCheck(mem_id, mem_pass);
	}
	
	/* 아이디 찾기 */
	@Override
	public String forgotIdCheck(String mem_name, String mem_hp) {
		return loginMapper.forgotIdCheck(mem_name, mem_hp);
	}
	
	/* 비밀번호 찾기 */
	@Override
	public String forgotPassCheck(MemberDTO dto) {
		return loginMapper.forgotPassCheck(dto);
	}
}
