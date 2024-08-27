package com.sparta.scheduleappadvance.dto;

import com.sparta.scheduleappadvance.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDto extends CommonDto {
    private String writeUserName;
    private String content;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.writeUserName = comment.getWriteUser().getUsername();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
    }
}
