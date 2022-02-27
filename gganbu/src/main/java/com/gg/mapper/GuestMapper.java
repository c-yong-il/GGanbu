package com.gg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.GuestDTO;

@Mapper
public interface GuestMapper {
    public List<GuestDTO> selectGuest(GuestDTO params);

    public List<GuestDTO> selectGuest2(GuestDTO params);

    public int selectGuestTotalCount(GuestDTO params);

    public List<GuestDTO> getList();

    public String now();

    public int insertGuest(GuestDTO dto);

    public int updateGuest(GuestDTO dto);

    public GuestDTO updateGuestMove(int book_num);

    public int deleteGuest(int book_num);
}
