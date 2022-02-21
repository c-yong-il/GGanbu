package com.gg.service;

import java.util.List;

import com.gg.domain.MemberDTO;
import com.gg.domain.MgmDTO;

public interface MgmService {
    
    public int MgmQuit();
    
    public int MgmAccept();
    
    public int MgmRefuse();
    
    public List<MemberDTO> search(String mem_name);
    
    public List<MgmDTO> gglist(String mem_id);

}
