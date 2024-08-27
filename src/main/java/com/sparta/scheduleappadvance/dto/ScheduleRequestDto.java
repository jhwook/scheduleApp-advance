package com.sparta.scheduleappadvance.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private Long writeUserId;
    private String scheduleName;
    private String content;
}
