package com.gg.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class PhotoCommentDTO {
    
    private int photo_comment_num;
    
    private String mem_id;
    
    private String comment_content;
    
    private Date comment_date;
    
    private Date comment_updatedate;
    
    private String comment_status;
    
    private int photo_num;
    
    private String mem_id2;

}
