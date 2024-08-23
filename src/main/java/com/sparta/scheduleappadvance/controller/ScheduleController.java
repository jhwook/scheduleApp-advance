package com.sparta.scheduleappadvance.controller;

import com.sparta.scheduleappadvance.dto.ScheduleRequestDto;
import com.sparta.scheduleappadvance.dto.ScheduleResponseDto;
import com.sparta.scheduleappadvance.entity.Schedule;
import com.sparta.scheduleappadvance.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/create")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }
    @GetMapping("/{id}")
    public Schedule getSchedule(@PathVariable Long id) {
        return scheduleService.getSchedule(id);
    }

    @PutMapping("/update/{id}")
    public ScheduleResponseDto updateSchedule(@RequestBody ScheduleRequestDto requestDto, @PathVariable Long id) {
        return scheduleService.updateSchedule(requestDto, id);
    }
}
