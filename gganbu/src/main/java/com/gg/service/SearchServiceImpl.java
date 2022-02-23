package com.gg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.domain.MemberDTO;
import com.gg.domain.MgmDTO;
import com.gg.mapper.SearchMapper;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    SearchMapper searchmapper;

    @Override
    public int insertGganbu(String myid, String yid) {
        return searchmapper.insertGganbu(myid, yid);
    }

    @Override
    public int updateGganbu(String myid, String yid) {
        return searchmapper.updateGganbu(myid, yid);
    }

    @Override
    public List<MgmDTO> gganbuList(String mem_id) {
        return searchmapper.gganbuList(mem_id);
    }

    @Override
    public List<MemberDTO> search(String search) {
        return searchmapper.search(search);
    }

    @Override
    public int ggCheck(String myid, String yid) {
        return searchmapper.ggCheck(myid, yid);
    }

}
