package com.gg.service;

import java.util.List;

import com.gg.domain.PhotoDTO;


public interface PhotoService {
    
    public List<PhotoDTO> listTest(PhotoDTO params);
    
    public int selectPhotoTotalCount(PhotoDTO params);
    
    public PhotoDTO selectTest(int photo_num);
    
    public int updateTest(PhotoDTO params);
    
    public int insertTest(PhotoDTO params);
    
    public int deleteTest(int photo_num);
    
}
