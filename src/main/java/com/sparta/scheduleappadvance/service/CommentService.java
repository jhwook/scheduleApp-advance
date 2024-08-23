package com.sparta.scheduleappadvance.service;

import com.sparta.scheduleappadvance.dto.CommentRequestDto;
import com.sparta.scheduleappadvance.dto.CommentResponseDto;
import com.sparta.scheduleappadvance.entity.Comment;
import com.sparta.scheduleappadvance.entity.Schedule;
import com.sparta.scheduleappadvance.repository.CommentRepository;
import com.sparta.scheduleappadvance.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleService scheduleService;

    public CommentService(CommentRepository commentRepository, ScheduleService scheduleService) {
        this.commentRepository = commentRepository;
        this.scheduleService = scheduleService;
    }

    public CommentResponseDto createComment(Long scheduleId, CommentRequestDto requestDto) {
        Schedule schedule = scheduleService.getSchedule(scheduleId);

        Comment comment = new Comment(requestDto, schedule);

        commentRepository.save(comment);

        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);

        return commentResponseDto;
    }

    @Transactional
    public CommentResponseDto updateComment(Long comment_id, CommentRequestDto requestDto) {
        Comment comment = getComment(comment_id);

       Comment updateComment = comment.update(requestDto);

       CommentResponseDto commentResponseDto = new CommentResponseDto(updateComment);
       return  commentResponseDto;
    }

    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(()-> new IllegalArgumentException("해당 댓글은 존재하지 않습니다."));
    }

    public String deleteComment(Long commentId) {
        Comment comment = getComment(commentId);

        commentRepository.delete(comment);

        return "ok";
    }

    public List<CommentResponseDto> getAllComment(Long scheduleId) {
        Schedule schedule = scheduleService.getSchedule(scheduleId);

        return schedule.getCommentList().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}
