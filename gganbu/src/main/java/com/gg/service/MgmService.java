package com.gg.service;

import java.util.List;

import com.gg.domain.MemberDTO;

public interface MgmService {
    
    public int MgmQuit();
    
    public int MgmAccept();
    
    public int MgmRefuse();
    
    public List<MemberDTO> search(String mem_name);

}
