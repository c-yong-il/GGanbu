package com.gg.domain;

import lombok.Data;

@Data
public class DiaryDTO {
    int diary_num;
    String mem_id, diary_content, diary_status;
    String diary_date, diary_updatedate;

}
