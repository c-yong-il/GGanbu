package com.gg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gg.domain.PhotoDTO;

@Mapper
public interface PhotoMapper {
    
    /* 사진첩 게시글 리스트 출력 */
    public List<PhotoDTO> listTest(PhotoDTO params); 
    
    /* 깐부테이블에서 관계 여부 받아오기 */
    public int gganbu_relation(@Param(value = "mem_id") String mem_id, @Param(value = "mem_id2") String mem_id2);
    
    /*
     * public int ggcheck(@Param(value = "mem_id") String mem_id, @Param(value =
     * "mem_id2") String mem_id2);
     */
    
    /* 사진첩 총 게시글 카운트 */
    public int selectPhotoTotalCount(PhotoDTO params);
    
    /* 수정화면으로 넘어갈때 게시글 번호로 조회 */
    public PhotoDTO selectTest(int photo_num);
    
    /* 게시글 수정 */
    public int updateTest(PhotoDTO params);
    
    /* 게시글 등록 */
    public int insertTest(PhotoDTO params);
    
    /* 게시글 삭제 */
    public int deleteTest(int photo_num);
    
}
