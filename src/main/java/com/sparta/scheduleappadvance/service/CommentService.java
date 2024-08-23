package com.sparta.scheduleappadvance.service;

import com.sparta.scheduleappadvance.dto.CommentRequestDto;
import com.sparta.scheduleappadvance.dto.CommentResponseDto;
import com.sparta.scheduleappadvance.entity.Comment;
import com.sparta.scheduleappadvance.entity.Schedule;
import com.sparta.scheduleappadvance.repository.CommentRepository;
import com.sparta.scheduleappadvance.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

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
}
