package com.gg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.MemberDTO;
import com.gg.domain.MgmDTO;

@Mapper
public interface SearchMapper {

    public int requestGganbu(MgmDTO dto);

    public List<MgmDTO> gganbuList(String mem_id);

    public List<MemberDTO> search(String search);
}
