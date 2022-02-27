package com.gg.domain;

import lombok.Data;

@Data
public class DiaryDTO {

    private int diary_num, rno;
    private String mem_id, diary_content, diary_secret, diary_status, diary_date, diary_updatedate;

}
