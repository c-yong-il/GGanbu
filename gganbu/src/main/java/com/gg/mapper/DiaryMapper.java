package com.gg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.DiaryDTO;

@Mapper
public interface DiaryMapper {

    public int insertDiary(DiaryDTO dto);

    //    public DiaryDTO selectDiary(String mem_id);

    public List<DiaryDTO> selectDiary(DiaryDTO dto);

    public List<DiaryDTO> selectDiary2(DiaryDTO dto);

    //    public List<DiaryDTO> selectDate(String mem_id, String diary_date);
    public List<DiaryDTO> selectDate(DiaryDTO dto);

    public List<DiaryDTO> selectResultDiary(int diary_num);

    public String now();

    public int updateDiary(DiaryDTO dto);

    public DiaryDTO updateDiaryMove(int diary_num);

    public int deleteDiary(int diary_num);

    public int selectDiaryTotalCount(DiaryDTO dto);
}
