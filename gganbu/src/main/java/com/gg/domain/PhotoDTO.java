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

    /* 내용 */
    private String photo_content;

    /* 등록일 */
    private Date photo_date;

    /* 수정일 */
    private Date photo_updateTime;
    
    /* 삭제 여부 */
    private String photo_status;
    
}
