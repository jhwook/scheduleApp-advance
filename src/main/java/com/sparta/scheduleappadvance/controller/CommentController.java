package com.sparta.scheduleappadvance.controller;

import com.sparta.scheduleappadvance.dto.CommentRequestDto;
import com.sparta.scheduleappadvance.dto.CommentResponseDto;
import com.sparta.scheduleappadvance.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create/{schedule_id}")
    public CommentResponseDto createComment(@PathVariable Long schedule_id, @RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(schedule_id, requestDto);
    }
}
