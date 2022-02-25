package com.gg.service;

import java.util.List;

import com.gg.domain.GuestDTO;

public interface GuestService {

    public List<GuestDTO> selectGuest(String mem_id);

    public String now();

    public int insertGuest(GuestDTO dto);
}
