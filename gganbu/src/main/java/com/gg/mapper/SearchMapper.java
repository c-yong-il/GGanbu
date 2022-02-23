package com.gg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gg.domain.MemberDTO;
import com.gg.domain.MgmDTO;

@Mapper
public interface SearchMapper {

    public int insertGganbu(@Param(value = "myid") String myid, @Param(value = "yid") String yid);

    public int updateGganbu(@Param(value = "myid") String myid, @Param(value = "yid") String yid);

    public List<MgmDTO> gganbuList(String mem_id);

    public List<MemberDTO> search(String search);

    public int ggCheck(@Param(value = "myid") String myid, @Param(value = "yid") String yid);
}
