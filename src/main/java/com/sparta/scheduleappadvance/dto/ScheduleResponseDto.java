package com.sparta.scheduleappadvance.dto;

import com.sparta.scheduleappadvance.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto extends CommonDto {
    private String writeUserName;
    private String scheduleName;
    private String content;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.writeUserName = schedule.getWriteUser().getUsername();
        this.scheduleName = schedule.getScheduleName();
        this.content = schedule.getContent();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }
}
