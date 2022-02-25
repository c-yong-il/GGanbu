package com.gg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.domain.GuestDTO;
import com.gg.mapper.GuestMapper;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired(required = false)
    private GuestMapper guestmapper;

    @Override
    public List<GuestDTO> selectGuest(String mem_id) {
        return guestmapper.selectGuest(mem_id);
    }

    @Override
    public String now() {
        return guestmapper.now();
    }

    @Override
    public int insertGuest(GuestDTO dto) {
        return guestmapper.insertGuest(dto);
    }

}
