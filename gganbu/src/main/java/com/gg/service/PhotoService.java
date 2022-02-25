package com.gg.service;

import java.util.List;

import com.gg.domain.PhotoDTO;


public interface PhotoService {
    
    public PhotoDTO selectTest(int photo_num);
    
    public List<PhotoDTO> listTest(String mem_id);
    
    public int updateTest(PhotoDTO params);
    
    public int insertTest(PhotoDTO params);
    
    public int deleteTest(int photo_num);
    
}
