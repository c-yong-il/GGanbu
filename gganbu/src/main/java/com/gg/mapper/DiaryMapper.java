package com.gg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.DiaryDTO;

@Mapper
public interface DiaryMapper {

    public int insertDiary(DiaryDTO dto);

    //    public DiaryDTO selectDiary(String mem_id);

    public List<DiaryDTO> selectDiary(String mem_id);

    public String now();

    public int updateDiary(DiaryDTO dto);

    public DiaryDTO updateDiaryMove(int diary_num);
}
