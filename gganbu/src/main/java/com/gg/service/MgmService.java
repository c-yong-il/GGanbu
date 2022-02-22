package com.gg.service;

import java.util.List;

import com.gg.domain.MgmDTO;

public interface MgmService {
    
    public int MgmQuit(String mem_id, String mem_id2);
    
    public int MgmAccept();
    
    public int MgmRefuse();
    
    public List<MgmDTO> gglist(String mem_id);
    
    public List<MgmDTO> ggwait(String mem_id);

}
