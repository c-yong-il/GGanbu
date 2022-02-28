package com.gg.domain;

import com.gg.paging.Criteria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryDTO extends Criteria {

    private int diary_num, rno;
    private String diary_content, diary_secret, diary_status, diary_date, diary_updatedate;

}
