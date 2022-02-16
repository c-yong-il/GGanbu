package com.gg.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class DiaryDTO {
    int diary_num;
    String mem_id, diary_content, diary_status;
    Date diary_date, diary_updatedate;

}
