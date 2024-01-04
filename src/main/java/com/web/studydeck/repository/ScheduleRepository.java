package com.web.studydeck.repository;

import com.web.studydeck.model.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByUserId(Long userId);
    // Custom queries for schedules
}

