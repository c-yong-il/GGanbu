package com.gg.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberGganbuJoinDTO {
    private String mem_id, mem_name, mem_date, mem_status;
    private String mem_id2, gganbu_requestdate, gganbu_acceptdate;
    private int gganbu_relation;

}
