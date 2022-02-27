package com.gg.domain;

import com.gg.paging.Criteria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestDTO extends Criteria {

    private int book_num, rno;
    private String mem_id2, book_content, book_date, book_updatedate, book_secret, book_status;
}
