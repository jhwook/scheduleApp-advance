package com.sparta.scheduleappadvance.dto;

import com.sparta.scheduleappadvance.entity.Schedule;
import com.sparta.scheduleappadvance.entity.User;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ScheduleResponseDto extends CommonDto {
    private String writeUserName;
    private String scheduleName;
    private String content;
    private List<UserInfoDto> addedUserInfo;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.writeUserName = schedule.getWriteUser().getUsername();
        this.scheduleName = schedule.getScheduleName();
        this.content = schedule.getContent();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();

        this.addedUserInfo = schedule.getScheduleAddedUsers().stream()
                .map(addedUser -> new UserInfoDto(addedUser.getUser())).collect(Collectors.toList());
    }
}


