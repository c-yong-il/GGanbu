package com.gg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.domain.DiaryDTO;
import com.gg.mapper.DiaryMapper;

@Service
public class DiaryServiceImpl implements DiaryService {
    @Autowired(required = false)
    private DiaryMapper diarymapper;

    @Override
    public int insertDiary(DiaryDTO dto) {
        return diarymapper.insertDiary(dto);
    }

    //    @Override
    //    public DiaryDTO selectDiary(String mem_id) {
    //        return diarymapper.selectDiary(mem_id);
    //
    //    }

    @Override
    public List<DiaryDTO> selectDiary(DiaryDTO dto) {
        return diarymapper.selectDiary(dto);
    }

    @Override
    public List<DiaryDTO> selectDiary2(DiaryDTO dto) {
        return diarymapper.selectDiary2(dto);
    }

    @Override
    public String now() {
        return diarymapper.now();
    }

    @Override
    public int updateDiary(DiaryDTO dto) {
        // TODO Auto-generated method stub
        return diarymapper.updateDiary(dto);
    }

    @Override
    public DiaryDTO updateDiaryMove(int diary_num) {

        return diarymapper.updateDiaryMove(diary_num);
    }

    @Override
    public int deleteDiary(int diary_num) {
        return diarymapper.deleteDiary(diary_num);
    }

    //    @Override
    //    public List<DiaryDTO> selectDate(String mem_id, String diary_date) {
    //        return diarymapper.selectDate(mem_id, diary_date);
    //    }
    @Override
    public List<DiaryDTO> selectDate(DiaryDTO dto) {
        return diarymapper.selectDate(dto);
    }

    @Override
    public List<DiaryDTO> selectResultDiary(int diary_num) {

        return diarymapper.selectResultDiary(diary_num);
    }

    @Override
    public int selectDiaryTotalCount(DiaryDTO dto) {
        return diarymapper.selectDiaryTotalCount(dto);
    }

}
