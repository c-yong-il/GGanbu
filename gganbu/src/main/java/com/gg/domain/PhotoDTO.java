package com.gg.domain;

import java.sql.Date;

import com.gg.paging.Criteria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoDTO extends Criteria{
    
    /* 번호 (PK) */
    private int photo_num;
    
    /* rno */
    private int rownum;
    
    /* 공개여부 */
    private int photo_open;

    /* 내용 */
    private String photo_content;

    /* 등록일 */
    private Date photo_date;

    /* 수정일 */
    private Date photo_updateTime;
    
    /* 삭제 여부 */
    private String photo_status;
    
    /* 깐부 여부 확인용 */
    private int gganbu_relation;
    
    /* private int ggcheck; */
    
    
}
