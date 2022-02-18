package com.gg.service;

import java.util.List;

import com.gg.domain.DiaryDTO;

public interface DiaryService {

    public int insertDiary(DiaryDTO dto);

    //   public DiaryDTO selectDiary(String mem_id);

    public List<DiaryDTO> selectDiary(String mem_id);

    public String now();

    public int updateDiary(DiaryDTO dto);

    public DiaryDTO updateDiaryMove(int diary_num);

}
