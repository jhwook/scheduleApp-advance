package com.sparta.scheduleappadvance.controller;

import com.sparta.scheduleappadvance.dto.ScheduleRequestDto;
import com.sparta.scheduleappadvance.dto.ScheduleResponseDto;
import com.sparta.scheduleappadvance.dto.UserRequestDto;
import com.sparta.scheduleappadvance.entity.Schedule;
import com.sparta.scheduleappadvance.service.ScheduleService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/create")
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.createSchedule(requestDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getSchedule(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.getSchedule(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@RequestBody ScheduleRequestDto requestDto, @PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.updateSchedule(requestDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.ok("Successfully deleted");
    }

    @GetMapping("/pagination")
    public ResponseEntity<List<ScheduleResponseDto>> getSchedules(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(scheduleService.getPaginatedSchedules(page, size));
    }

    @PostMapping("/{scheduleId}/add/user")
    public ResponseEntity<String> addUserOnSchedule(@RequestBody ScheduleRequestDto requestDto, @PathVariable Long scheduleId) {
        return ResponseEntity.ok(scheduleService.addUserOnSchedule(requestDto.getUserIdList(), scheduleId));
    }
}
