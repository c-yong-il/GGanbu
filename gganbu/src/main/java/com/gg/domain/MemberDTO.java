package com.gg.domain;

import lombok.Data;

@Data
public class MemberDTO {
    String mem_id, mem_pass, mem_name, mem_email1, mem_email2, 
    mem_hp, mem_birth, mem_gender, mem_date, mem_status;
}
