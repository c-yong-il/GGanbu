package com.gg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gg.domain.MgmDTO;

@Mapper
public interface MgmMapper {

    public int MgmQuit(String mem_id, String mem_id2);

    public int MgmAccept(@Param(value = "myid") String myid, @Param(value = "yid") String yid);

    public int MgmRefuse(@Param(value = "myid") String myid, @Param(value = "yid") String yid);

    public List<MgmDTO> gglist(String mem_id);

    public List<MgmDTO> ggwait(String mem_id);

}
