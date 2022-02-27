package com.gg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.domain.PhotoDTO;
import com.gg.mapper.PhotoMapper;

@Service
public class PhotoServiceImpl implements PhotoService{
    
    @Autowired
    private PhotoMapper photomapper;
    
    @Override
    public PhotoDTO selectTest(int photo_num) {
        
        return photomapper.selectTest(photo_num);
        
    }
    
    @Override
    public List<PhotoDTO> listTest(PhotoDTO params){  
        
        List<PhotoDTO> list = photomapper.listTest(params);
        
        return list; 
    }
    
    @Override
    public int updateTest(PhotoDTO params) {
           int result =0;
        
        result = photomapper.updateTest(params);
        
        return result;
        
    }
    
    @Override
    public int insertTest(PhotoDTO params) {
        int result =0;
        
        result = photomapper.insertTest(params);
        
        return result;
    }
    
    @Override
    public int deleteTest(int photo_num) {
        int result =0;
        
        result = photomapper.deleteTest(photo_num);
        
        return result;
    }

    @Override
    public int selectBoardTotalCount(PhotoDTO params) {
        
        
        return photomapper.selectBoardTotalCount(params);
    }

}
