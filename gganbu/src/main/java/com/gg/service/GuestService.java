package com.gg.service;

import java.util.List;

import com.gg.domain.GuestDTO;

public interface GuestService {

    public List<GuestDTO> selectGuest(GuestDTO params);

    public List<GuestDTO> selectGuest2(GuestDTO params);

    public int selectGuestTotalCount(GuestDTO params);

    public String now();

    public int insertGuest(GuestDTO dto);

    public int updateGuest(GuestDTO dto);

    public GuestDTO updateGuestMove(int book_num);

    public int deleteGuest(int book_num);
}
