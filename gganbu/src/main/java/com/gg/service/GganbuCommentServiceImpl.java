package com.gg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.domain.GganbuCommentDTO;
import com.gg.mapper.GganbuCommentMapper;

@Service
public class GganbuCommentServiceImpl implements GganbuCommentService{
	
	@Autowired
	private GganbuCommentMapper gganbucommentmapper;
	
	@Override
	public List<GganbuCommentDTO> listTest(String mem_id){
        List<GganbuCommentDTO> list = gganbucommentmapper.listTest(mem_id);
        
        return list; 
    }

}
