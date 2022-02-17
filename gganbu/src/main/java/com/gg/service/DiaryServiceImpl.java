package com.gg.service;

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
        int result = 0;

        return result;
    }

    @Override
    public DiaryDTO selectDiary(String mem_id) {
        return diarymapper.selectDiary(mem_id);

    }

    @Override
    public String now() {
        return diarymapper.now();
    }

}
