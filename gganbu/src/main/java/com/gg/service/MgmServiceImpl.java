package com.gg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.domain.MgmDTO;
import com.gg.mapper.MgmMapper;

@Service
public class MgmServiceImpl implements MgmService {

    @Autowired
    private MgmMapper mgmmapper;

    @Override
    public int MgmQuit(String mem_id, String mem_id2) {
        return 0;
    }

    @Override
    public int MgmAccept(String myid, String yid) {
        return mgmmapper.MgmAccept(myid, yid);
    }

    @Override
    public int MgmRefuse(String myid, String yid) {
        return mgmmapper.MgmRefuse(myid, yid);
    }

    @Override
    public List<MgmDTO> gglist(String mem_id) {

        return mgmmapper.gglist(mem_id);
    }

    @Override
    public List<MgmDTO> ggwait(String mem_id) {

        return mgmmapper.ggwait(mem_id);
    }

}
