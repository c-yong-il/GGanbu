package com.gg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.GuestDTO;

@Mapper
public interface GuestMapper {
    public List<GuestDTO> selectGuest(String mem_id);

    public List<GuestDTO> getList();

    public String now();

    public int insertGuest(GuestDTO dto);
}
