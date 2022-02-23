package com.gg.service;

import java.util.List;

import com.gg.domain.MemberDTO;
import com.gg.domain.MgmDTO;

public interface SearchService {

    public int insertGganbu(String myid, String yid);

    public int updateGganbu(String myid, String yid);

    public List<MgmDTO> gganbuList(String mem_id);

    public List<MemberDTO> search(String search);

    public int ggCheck(String myid, String yid);
}
