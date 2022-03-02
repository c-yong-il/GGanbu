package com.gg.service;

import com.gg.domain.MemberDTO;

public interface LoginService {

    public MemberDTO loginAction(String mem_id);

    public MemberDTO loginCheck(String mem_id, String mem_pass);

    public String forgotIdCheck(String mem_name, String mem_hp);

    public int forgotPassCheck(MemberDTO dto);
}
