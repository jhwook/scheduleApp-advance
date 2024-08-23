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
    @Column(name = "writeUser", nullable = false)
    private String writeUser;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Comment(CommentRequestDto requestDto, Schedule schedule) {
        this.writeUser = requestDto.getWriteUser();
        this.content = requestDto.getContent();
        this.schedule = schedule;
    }

    public Comment update(CommentRequestDto requestDto) {
        this.writeUser = requestDto.getWriteUser();
        this.content = requestDto.getContent();
        return this;
    }
}
