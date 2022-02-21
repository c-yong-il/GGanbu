package com.gg.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class MgmDTO {
    
    private String mem_id;
    
    private String mem_id2;
    
    private Date gganbu_acceptdate;
    
    private Date gganbu_requestdate;
    
    private int gganbu_relation;
    
}
