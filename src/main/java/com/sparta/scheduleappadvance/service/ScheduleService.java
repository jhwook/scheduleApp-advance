package com.sparta.scheduleappadvance.service;

import com.sparta.scheduleappadvance.dto.ScheduleRequestDto;
import com.sparta.scheduleappadvance.dto.ScheduleResponseDto;
import com.sparta.scheduleappadvance.entity.Schedule;
import com.sparta.scheduleappadvance.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto);

        Schedule saveSchedule =  scheduleRepository.save(schedule);

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(saveSchedule);

        return scheduleResponseDto;
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(ScheduleRequestDto requestDto, Long id) {
        Schedule schedule = getSchedule(id);

        Schedule updatedSchedule = schedule.update(requestDto);

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(updatedSchedule);

        return scheduleResponseDto;
    }

    public Schedule getSchedule(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 스케줄이 존재하지 않습니다."));
    }
}
