package com.gg.service;

import java.util.List;

import com.gg.domain.GganbuCommentDTO;
import com.gg.domain.MemberDTO;

public interface GganbuCommentService {

    public List<GganbuCommentDTO> selectGganbuComment(String mem_id);

    public MemberDTO selectMemInfo(String mem_id);

    public int deleteGganbuComment(String mem_id2);

    public int insertORupdateGganbuComment(GganbuCommentDTO dto);

    public int gganbuCheck(String mem_id, String mem_id2);

    public int ggRelationCheck(String mem_id, String mem_id2);

}
