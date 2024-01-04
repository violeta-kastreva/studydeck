package com.web.studydeck.service;

import com.web.studydeck.model.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> findAllSchedules();
    Schedule findScheduleById(Long id);
    Schedule saveSchedule(Schedule schedule);
    void deleteSchedule(Long id);

    List<Schedule> findSchedulesByUserId(Long userId);
    // Other necessary methods
}
