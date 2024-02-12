package com.web.studydeck.service;

import com.web.studydeck.model.service.ScheduleDTO;

import java.util.List;

public interface ScheduleService {
    List<ScheduleDTO> findAllSchedules();
    ScheduleDTO findScheduleById(Long id);
    ScheduleDTO saveSchedule(ScheduleDTO scheduleDTO);
    void deleteSchedule(Long id);
    List<ScheduleDTO> findSchedulesByUserId(Long userId);
}

