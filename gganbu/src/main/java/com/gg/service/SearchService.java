package com.gg.service;

import java.util.List;

import com.gg.domain.MemberDTO;
import com.gg.domain.MgmDTO;

public interface SearchService {

    public int requestGganbu(MgmDTO dto);

    public List<MgmDTO> gganbuList(String mem_id);

    public List<MemberDTO> search(String search);
}
