package com.gg.service;

import com.gg.domain.MemberDTO;

public interface MyInfoService {

    public MemberDTO showInfo(String mem_id); // 내정보 조회

    public int editInfo(MemberDTO dto); // 내정보 수정

    public int exitMember(String mem_id); // 회원탈퇴

}
