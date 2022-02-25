package com.gg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gg.domain.GganbuCommentDTO;

@Mapper
public interface GganbuCommentMapper {

    public List<GganbuCommentDTO> selectGganbuComment(String mem_id);

    public int deleteGganbuComment(String mem_id2);

    public int insertORupdateGganbuComment(GganbuCommentDTO dto);

}
