package com.gg.service;

import com.gg.domain.MemberDTO;

public interface JoinService {
    public int joinProc(MemberDTO dto) throws Exception;

    public int checkId(String mem_id);

}
