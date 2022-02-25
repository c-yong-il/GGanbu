package com.gg.domain;

import lombok.Data;

@Data
public class GuestDTO {

    private int book_num, rno;
    private String mem_id, mem_id2, book_content, book_date, book_updatedate, book_status;
}
