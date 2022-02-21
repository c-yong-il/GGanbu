package com.gg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.domain.MemberDTO;
import com.gg.domain.MgmDTO;
import com.gg.mapper.MgmMapper;

@Service
public class MgmServiceImpl implements MgmService{

    @Autowired
    private MgmMapper mgmmapper;
    
    @Override
    public int MgmQuit() {
        return 0;
    }

    @Override
    public int MgmAccept() {
        return 0;
    }

    @Override
    public int MgmRefuse() {
        return 0;
    }

    @Override
    public List<MemberDTO> search(String mem_name) {
        return null;
    }

    @Override
    public List<MgmDTO> gglist(String mem_id) {
        
        return mgmmapper.gglist(mem_id);
    }
    
    

}
