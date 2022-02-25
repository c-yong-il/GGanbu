package com.gg.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class GganbuCommentDTO {
    String mem_id, mem_id2, gganbu_comment_content, gganbu_comment_status;
    Date gganbu_comment_date, gganbu_comment_updatedate;
}
