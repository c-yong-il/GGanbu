package com.gg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gg.domain.GganbuCommentDTO;
import com.gg.domain.MemberDTO;

@Mapper
public interface GganbuCommentMapper {

    public List<GganbuCommentDTO> selectGganbuComment(String mem_id);

    public MemberDTO selectMemInfo(String mem_id);

    public int deleteGganbuComment(String mem_id2);

    public int insertORupdateGganbuComment(GganbuCommentDTO dto);

    public int gganbuCheck(@Param(value = "mem_id") String mem_id, @Param(value = "mem_id2") String mem_id2);

    public int ggRelationCheck(@Param(value = "mem_id") String mem_id, @Param(value = "mem_id2") String mem_id2);

}
