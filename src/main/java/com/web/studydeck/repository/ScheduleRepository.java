package com.web.studydeck.repository;

import com.web.studydeck.model.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ScheduleRepository extends ReactiveCrudRepository<Schedule, Long> {
    Flux<Schedule> findAllByUserId(Long userId);
    // Custom queries
}
