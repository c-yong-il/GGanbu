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
    public List<GuestDTO> selectGuest(GuestDTO params) {
        return guestmapper.selectGuest(params);
    }

    @Override
    public String now() {
        return guestmapper.now();
    }

    @Override
    public int insertGuest(GuestDTO dto) {
        return guestmapper.insertGuest(dto);
    }

    @Override
    public int updateGuest(GuestDTO dto) {
        // TODO Auto-generated method stub
        return guestmapper.updateGuest(dto);
    }

    @Override
    public GuestDTO updateGuestMove(int book_num) {
        return guestmapper.updateGuestMove(book_num);
    }

    @Override
    public int deleteGuest(int book_num) {
        return guestmapper.deleteGuest(book_num);
    }

    @Override
    public int selectGuestTotalCount(GuestDTO params) {

        return guestmapper.selectGuestTotalCount(params);
    }

    @Override
    public List<GuestDTO> selectGuest2(GuestDTO params) {

        return guestmapper.selectGuest2(params);
    }

}
