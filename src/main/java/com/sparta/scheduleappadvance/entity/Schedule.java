package com.sparta.scheduleappadvance.entity;

import com.sparta.scheduleappadvance.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "schedule")
public class Schedule extends CommonEntity {
    @Column(name = "scheduleName", nullable = false)
    private String scheduleName;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "write_user_id", nullable = false)
    private User writeUser;


    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<Comment> commentList;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<ScheduleAddedUser> scheduleAddedUsers;

    public Schedule(ScheduleRequestDto requestDto, User user) {
        this.writeUser = user;
        this.scheduleName = requestDto.getScheduleName();
        this.content = requestDto.getContent();
    }

    public Schedule update(ScheduleRequestDto requestDto, User user) {
        this.writeUser = user;
        this.scheduleName = requestDto.getScheduleName();
        this.content = requestDto.getContent();

        return this;
    }

    public void addCommentList(Comment comment) {
        this.commentList.add(comment);
        comment.setSchedule(this);
    }
}
