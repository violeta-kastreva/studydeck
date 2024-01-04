package com.web.studydeck.web;

import com.web.studydeck.model.entity.Schedule;
import com.web.studydeck.model.service.ScheduleDTO;
import com.web.studydeck.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/{userId}")
    public Flux<ScheduleDTO> getUserSchedule(@PathVariable Long userId) {
        return scheduleService.findSchedulesByUserId(userId);
    }

    @PostMapping
    public Mono<ScheduleDTO> createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.saveSchedule(scheduleDTO);
    }

    @PutMapping("/{scheduleId}")
    public Mono<ScheduleDTO> updateSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleDTO scheduleDTO) {
        scheduleDTO.setId(scheduleId);
        return scheduleService.saveSchedule(scheduleDTO);
    }

    @DeleteMapping("/{scheduleId}")
    public Mono<ResponseEntity<Void>> deleteSchedule(@PathVariable Long scheduleId) {
        return scheduleService.deleteSchedule(scheduleId)
                .thenReturn(ResponseEntity.ok().<Void>build());
    }
}
