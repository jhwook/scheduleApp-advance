package com.sparta.scheduleappadvance.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ScheduleRequestDto {
    private Long writeUserId;
    private String scheduleName;
    private String content;
    private List<Long> userIdList;
}
