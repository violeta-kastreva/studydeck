package com.web.studydeck.web;

import com.web.studydeck.model.entity.Schedule;
import com.web.studydeck.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Schedule>> getUserSchedule(@PathVariable Long userId) {
        // Logic to get the schedule for a specific user
        List<Schedule> schedules = scheduleService.findSchedulesByUserId(userId);
        return ResponseEntity.ok(schedules);
    }

    @PutMapping("/{scheduleId}/edit")
    public ResponseEntity<Schedule> editSchedule(@PathVariable Long scheduleId, @RequestBody Schedule schedule) {
        // Logic to update a schedule
        Schedule updatedSchedule = scheduleService.saveSchedule(schedule);
        return ResponseEntity.ok(updatedSchedule);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Schedule>> viewFriendSchedule(@PathVariable Long userId) {
        // Logic to get a friend's schedule
        List<Schedule> schedules = scheduleService.findSchedulesByUserId(userId);
        return ResponseEntity.ok(schedules);
    }
}
