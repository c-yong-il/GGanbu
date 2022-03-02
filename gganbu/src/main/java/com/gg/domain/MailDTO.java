package com.gg.domain;

import lombok.Data;

@Data
public class MailDTO {
    private String subject;
    private String content;
    private String receiver;
}
