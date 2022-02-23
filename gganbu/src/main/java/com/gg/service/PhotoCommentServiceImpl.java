package com.gg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.domain.PhotoCommentDTO;
import com.gg.mapper.PhotoCommentMapper;

@Service
public class PhotoCommentServiceImpl implements PhotoCommentService{
    
    @Autowired
    private PhotoCommentMapper photocommentmapper;

    @Override
    public List<PhotoCommentDTO> commentList(String mem_id) {
        List<PhotoCommentDTO> list = photocommentmapper.commentList(mem_id);
        
        return list;
    }

    @Override
    public int commentInsert(PhotoCommentDTO comment) {
        int result = 0;
        result = photocommentmapper.commentInsert(comment);
        return result;
    }

    @Override
    public int commentUpdate(PhotoCommentDTO comment) {
        int result = 0;
        result = photocommentmapper.commentUpdate(comment);
        return result;
    }

    @Override
    public int commentDelete(int photo_comment_num) {
        int result = 0;
        result = photocommentmapper.commentDelete(photo_comment_num);
        return result;
    }
    
}
