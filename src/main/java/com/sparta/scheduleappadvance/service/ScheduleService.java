package com.sparta.scheduleappadvance.service;

import com.sparta.scheduleappadvance.dto.ScheduleRequestDto;
import com.sparta.scheduleappadvance.dto.ScheduleResponseDto;
import com.sparta.scheduleappadvance.dto.UserRequestDto;
import com.sparta.scheduleappadvance.entity.Schedule;
import com.sparta.scheduleappadvance.entity.ScheduleAddedUser;
import com.sparta.scheduleappadvance.entity.User;
import com.sparta.scheduleappadvance.repository.ScheduleAddedUserRepository;
import com.sparta.scheduleappadvance.repository.ScheduleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserService userService;
    private final ScheduleAddedUserRepository scheduleAddedUserRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, UserService userService, ScheduleAddedUserRepository scheduleAddedUserRepository) {
        this.scheduleRepository = scheduleRepository;
        this.userService = userService;
        this.scheduleAddedUserRepository = scheduleAddedUserRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        User user = userService.findUser(requestDto.getWriteUserId());
        Schedule schedule = new Schedule(requestDto, user);

        Schedule saveSchedule =  scheduleRepository.save(schedule);

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(saveSchedule);

        return scheduleResponseDto;
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(ScheduleRequestDto requestDto, Long id) {
        User user = userService.findUser(requestDto.getWriteUserId());
        Schedule schedule = getSchedule(id);

        Schedule updatedSchedule = schedule.update(requestDto, user);

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(updatedSchedule);

        return scheduleResponseDto;
    }

    public Schedule getSchedule(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 스케줄이 존재하지 않습니다."));
    }

    public List<ScheduleResponseDto> getPaginatedSchedules(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return scheduleRepository.findAllByOrderByUpdatedAtDesc(pageable)
                .stream().map(ScheduleResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void deleteSchedule(Long id) {
        Schedule schedule = getSchedule(id);
        scheduleRepository.delete(schedule);
    }

    public String addUserOnSchedule(List<Long> userIdList, Long scheduleId) {
        Schedule schedule = getSchedule(scheduleId);

        for(Long userId : userIdList) {
            User user = userService.findUser(userId);
            ScheduleAddedUser scheduleAddedUser = new ScheduleAddedUser(schedule, user);
            scheduleAddedUserRepository.save(scheduleAddedUser);
        }

        return "Successfully saved";
    }
}
