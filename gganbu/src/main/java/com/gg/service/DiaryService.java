package com.gg.service;

import com.gg.domain.DiaryDTO;

public interface DiaryService {

    public int insertDiary(DiaryDTO dto);

    public DiaryDTO selectDiary(String mem_id);

    public String now();
}
