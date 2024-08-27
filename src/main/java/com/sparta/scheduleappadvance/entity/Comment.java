package com.sparta.scheduleappadvance.entity;

import com.sparta.scheduleappadvance.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "comment")
public class Comment extends CommonEntity {
    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "write_user_id")
    private User writeUser;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Comment(CommentRequestDto requestDto, Schedule schedule, User user) {
        this.writeUser = user;
        this.content = requestDto.getContent();
        this.schedule = schedule;
    }

    public Comment update(CommentRequestDto requestDto) {
        this.content = requestDto.getContent();
        return this;
    }
}
