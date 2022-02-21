package com.gg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.MemberDTO;

@Mapper
public interface MgmMapper {
    
    public int MgmQuit();
    
    public int MgmAccept();
    
    public int MgmRefuse();
    
    public List<MemberDTO> search(String mem_name);

}
