package com.gg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.PhotoCommentDTO;

@Mapper
public interface PhotoCommentMapper {
    
    public List<PhotoCommentDTO> commentList(String mem_id);
    
    public int commentInsert(PhotoCommentDTO comment);
    
    public int commentUpdate(PhotoCommentDTO comment);
    
    public int commentDelete(int photo_comment_num);

}
