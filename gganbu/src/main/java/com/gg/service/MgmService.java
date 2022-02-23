package com.gg.service;

import java.util.List;

import com.gg.domain.MgmDTO;

public interface MgmService {

    public int MgmQuit(String mem_id, String mem_id2);

    public int MgmAccept(String myid, String yid);

    public int MgmRefuse(String myid, String yid);

    public List<MgmDTO> gglist(String mem_id);

    public List<MgmDTO> ggwait(String mem_id);

}
