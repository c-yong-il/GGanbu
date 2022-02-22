package com.gg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.MgmDTO;

@Mapper
public interface MgmMapper {
    
    public int MgmQuit(String mem_id, String mem_id2);
    
    public int MgmAccept();
    
    public int MgmRefuse();
    
    public List<MgmDTO> gglist(String mem_id);
    
    public List<MgmDTO> ggwait(String mem_id);

}
