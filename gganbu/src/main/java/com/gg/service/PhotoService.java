package com.gg.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gg.domain.PhotoDTO;


public interface PhotoService {
    
    public List<PhotoDTO> listTest(PhotoDTO params);
    
    public int gganbu_relation(@Param(value = "mem_id") String mem_id, @Param(value = "mem_id2") String mem_id2);
    
    /*
     * public int ggcheck(@Param(value = "mem_id") String mem_id, @Param(value =
     * "mem_id2") String mem_id2);
     */
    
    public int selectPhotoTotalCount(PhotoDTO params);
    
    public PhotoDTO selectTest(int photo_num);
    
    public int updateTest(PhotoDTO params);
    
    public int insertTest(PhotoDTO params);
    
    public int deleteTest(int photo_num);
    
}
