package com.web.studydeck.service;

import com.web.studydeck.model.entity.Schedule;

import java.util.List;

import com.web.studydeck.model.service.ScheduleDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ScheduleService {
    Flux<ScheduleDTO> findAllSchedules();
    Mono<ScheduleDTO> findScheduleById(Long id);
    Mono<ScheduleDTO> saveSchedule(ScheduleDTO scheduleDTO);
    Mono<Void> deleteSchedule(Long id);
    Flux<ScheduleDTO> findSchedulesByUserId(Long userId);
}
