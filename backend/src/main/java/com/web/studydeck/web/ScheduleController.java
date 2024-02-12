package com.web.studydeck.web;

import com.web.studydeck.model.service.ScheduleDTO;
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
    public ResponseEntity<List<ScheduleDTO>> getUserSchedule(@PathVariable Long userId) {
        List<ScheduleDTO> schedules = scheduleService.findSchedulesByUserId(userId);
        return ResponseEntity.ok(schedules);
    }

    @PostMapping
    public ResponseEntity<ScheduleDTO> createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        ScheduleDTO savedSchedule = scheduleService.saveSchedule(scheduleDTO);
        return ResponseEntity.ok(savedSchedule);
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<ScheduleDTO> updateSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleDTO scheduleDTO) {
        scheduleDTO.setId(scheduleId);
        ScheduleDTO updatedSchedule = scheduleService.saveSchedule(scheduleDTO);
        return ResponseEntity.ok(updatedSchedule);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.ok().build();
    }
}

