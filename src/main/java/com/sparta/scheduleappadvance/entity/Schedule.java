package com.sparta.scheduleappadvance.entity;

import com.sparta.scheduleappadvance.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


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

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<Comment> commentList;


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

    public void addCommentList(Comment comment) {
        this.commentList.add(comment);
        comment.setSchedule(this);
    }
}
