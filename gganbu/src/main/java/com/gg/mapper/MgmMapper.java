package com.gg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.MemberDTO;
import com.gg.domain.MgmDTO;

@Mapper
public interface MgmMapper {
    
    public int MgmQuit(String mem_id, String mem_id2);
    
    public int MgmAccept();
    
    public int MgmRefuse();
    
    public List<MemberDTO> search(String mem_name);
    
    public List<MgmDTO> gglist(String mem_id);

}
