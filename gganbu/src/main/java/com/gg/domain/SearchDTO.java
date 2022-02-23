package com.gg.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDTO {
    private String mem_id, mem_name, mem_date, mem_status, mem_id2, gganbu_requestdate, gganbu_acceptdate;
    private int gganbu_relation;

}
