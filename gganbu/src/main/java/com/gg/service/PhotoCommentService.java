package com.gg.service;

import java.util.List;

import com.gg.domain.PhotoCommentDTO;

public interface PhotoCommentService {
    
    public List<PhotoCommentDTO> commentList(String mem_id);
    
    public int commentInsert(PhotoCommentDTO comment);
    
    public int commentUpdate(PhotoCommentDTO comment);
    
    public int commentDelete(int photo_comment_num);

}
