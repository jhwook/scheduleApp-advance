package com.sparta.scheduleappadvance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class ScheduleAddedUser extends CommonEntity {
    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public ScheduleAddedUser(Schedule schedule, User user) {
        this.schedule = schedule;
        this.user = user;
    }
}
