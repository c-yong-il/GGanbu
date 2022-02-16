package com.gg.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class PhotoDTO {
    
    /* 번호 (PK) */
    private int photo_num;
    
    /* rno */
    private int rownum;

    /* 주인장id(작성자) (FK) */
    private String mem_id;

    /* 내용 */
    private String photo_content;

    /* 등록일 */
    private Date photo_date;

    /* 수정일 */
    private Date photo_updateTime;
    
    /* 삭제 여부 */
    private String photo_status;

}
