package com.gg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.domain.GganbuCommentDTO;
import com.gg.domain.MemberDTO;
import com.gg.mapper.GganbuCommentMapper;

@Service
public class GganbuCommentServiceImpl implements GganbuCommentService {

    @Autowired
    private GganbuCommentMapper gganbucommentmapper;

    @Override
    public List<GganbuCommentDTO> selectGganbuComment(String mem_id) {
        // List<GganbuCommentDTO> GganbuCommentList = Collections.emptyList();

        return gganbucommentmapper.selectGganbuComment(mem_id);
    }

    @Override
    public MemberDTO selectMemInfo(String mem_id) {
        return gganbucommentmapper.selectMemInfo(mem_id);
    }

    @Override
    public int deleteGganbuComment(String mem_id2) {

        return gganbucommentmapper.deleteGganbuComment(mem_id2);
    }

    @Override
    public int insertORupdateGganbuComment(GganbuCommentDTO dto) {

        return gganbucommentmapper.insertORupdateGganbuComment(dto);
    };

    @Override
    public int gganbuCheck(String mem_id, String mem_id2) {

        return gganbucommentmapper.gganbuCheck(mem_id, mem_id2);
    }

    @Override
    public int ggRelationCheck(String mem_id, String mem_id2) {
        return gganbucommentmapper.ggRelationCheck(mem_id, mem_id2);
    }

}
