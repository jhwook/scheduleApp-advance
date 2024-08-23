package com.sparta.scheduleappadvance.controller;

import com.sparta.scheduleappadvance.dto.CommentRequestDto;
import com.sparta.scheduleappadvance.dto.CommentResponseDto;
import com.sparta.scheduleappadvance.entity.Comment;
import com.sparta.scheduleappadvance.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/get/{comment_id}")
    public ResponseEntity<CommentResponseDto> getComment(@PathVariable Long comment_id) {
        CommentResponseDto commentResponseDto = new CommentResponseDto(commentService.getComment(comment_id));
        return ResponseEntity.ok(commentResponseDto);
    }

    @GetMapping("/get/all/{schedule_id}")
    public ResponseEntity<List<CommentResponseDto>> getAllComment(@PathVariable Long schedule_id) {
        return ResponseEntity.ok(commentService.getAllComment(schedule_id));
    }

    @PostMapping("/create/{schedule_id}")
    public ResponseEntity<CommentResponseDto> createComment(@PathVariable Long schedule_id, @RequestBody CommentRequestDto requestDto) {
        return ResponseEntity.ok(commentService.createComment(schedule_id, requestDto));
    }

    @PutMapping("/update/{comment_id}")
    public ResponseEntity<CommentResponseDto> updateComment(@PathVariable Long comment_id, @RequestBody CommentRequestDto requestDto) {
        return ResponseEntity.ok(commentService.updateComment(comment_id, requestDto));
    }

    @DeleteMapping("/delete/{comment_id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long comment_id) {
        return ResponseEntity.ok(commentService.deleteComment(comment_id));
    }


}
