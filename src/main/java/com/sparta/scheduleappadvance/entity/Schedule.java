package com.sparta.scheduleappadvance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "schedule")
public class Schedule extends CommonEntity {
    @Column(name = "writeUser", nullable = false)
    private String writeUser;

    @Column(name = "scheduleName", nullable = false)
    private String scheduleName;

    @Column(name = "content", nullable = false)
    private String content;

}
