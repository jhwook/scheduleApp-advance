package com.sparta.scheduleappadvance.repository;

import com.sparta.scheduleappadvance.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
