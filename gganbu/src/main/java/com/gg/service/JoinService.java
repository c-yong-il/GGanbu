package com.gg.service;

import com.gg.domain.MemberDTO;

public interface JoinService {
    public int joinProc(MemberDTO dto);

    public int idCheck(String mem_id);
}
