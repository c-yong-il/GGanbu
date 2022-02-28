package com.gg.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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
    public int gganbu_relation(@Param(value = "mem_id") String mem_id, @Param(value = "mem_id2") String mem_id2) {
        int result = 0;
        result = photomapper.gganbu_relation(mem_id,mem_id2);
        return result;
    }
    
    /*
     * @Override public int ggcheck(@Param(value = "mem_id") String
     * mem_id, @Param(value = "mem_id2") String mem_id2) { int result = 0; result =
     * photomapper.ggcheck(mem_id,mem_id2); return result; };
     */
    
    
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
    public int selectPhotoTotalCount(PhotoDTO params) {
        
        
        return photomapper.selectPhotoTotalCount(params);
    }

}
