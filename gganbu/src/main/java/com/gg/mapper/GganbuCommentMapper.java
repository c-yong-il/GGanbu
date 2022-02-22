package com.gg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.GganbuCommentDTO;

@Mapper
public interface GganbuCommentMapper {
	
	public List<GganbuCommentDTO> listTest(String mem_id);

}
