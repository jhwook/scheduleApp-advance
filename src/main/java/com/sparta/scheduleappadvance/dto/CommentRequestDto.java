package com.sparta.scheduleappadvance.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private Long writeUserId;
    private String content;
}
