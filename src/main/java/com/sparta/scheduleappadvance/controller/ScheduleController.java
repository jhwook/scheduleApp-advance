package com.sparta.scheduleappadvance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("schedules")
public class ScheduleController {
    @GetMapping("/get")
    public void getSchedule() {}
}
