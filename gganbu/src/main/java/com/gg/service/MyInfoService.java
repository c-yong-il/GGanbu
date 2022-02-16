package com.gg.service;

import com.gg.domain.MemberDTO;

public interface MyInfoService {

    public MemberDTO myinfoAction(MemberDTO dto);
    
    public MemberDTO showInfo(String mem_id);
    
    public int editInfo(MemberDTO dto);
    
    public int exitMember(MemberDTO dto);
    
}
