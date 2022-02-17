package com.gg.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.DiaryDTO;

@Mapper
public interface DiaryMapper {

    public int insertDiary(DiaryDTO dto);

    public DiaryDTO selectDiary(String mem_id);
}
