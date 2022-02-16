package com.gg.mapper;

import com.gg.domain.DiaryDTO;

public interface DiaryMapper {

    public int insertDiary(DiaryDTO dto);

    public DiaryDTO selectDiary(String mem_id);
}
