package com.sparta.scheduleappadvance.entity;

import com.sparta.scheduleappadvance.dto.ScheduleRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "schedule")
public class Schedule extends CommonEntity {
    @Column(name = "writeUser", nullable = false)
    private String writeUser;

    @Column(name = "scheduleName", nullable = false)
    private String scheduleName;

    @Column(name = "content", nullable = false)
    private String content;

    public Schedule(ScheduleRequestDto requestDto) {
        this.writeUser = requestDto.getWriteUser();
        this.scheduleName = requestDto.getScheduleName();
        this.content = requestDto.getContent();
    }

    public Schedule update(ScheduleRequestDto requestDto) {
        this.writeUser = requestDto.getWriteUser();
        this.scheduleName = requestDto.getScheduleName();
        this.content = requestDto.getContent();

        return this;
    }
}
