package com.gg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.PhotoDTO;

@Mapper
public interface PhotoMapper {
    
public List<PhotoDTO> listTest(String mem_id);
    
    public PhotoDTO selectTest(int photo_num);
    
    public int updateTest(PhotoDTO params);
    
    public int insertTest(PhotoDTO params);
    
    public int deleteTest(int photo_num);

}
