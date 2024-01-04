package com.web.studydeck.service.impl;
import com.web.studydeck.model.entity.Schedule;
import com.web.studydeck.model.service.ScheduleDTO;
import com.web.studydeck.repository.ScheduleRepository;
import com.web.studydeck.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Flux<ScheduleDTO> findAllSchedules() {
        return scheduleRepository.findAll()
                .map(schedule -> modelMapper.map(schedule, ScheduleDTO.class));
    }

    @Override
    public Mono<ScheduleDTO> findScheduleById(Long id) {
        return scheduleRepository.findById(id)
                .map(schedule -> modelMapper.map(schedule, ScheduleDTO.class));
    }

    @Override
    public Mono<ScheduleDTO> saveSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = modelMapper.map(scheduleDTO, Schedule.class);
        return scheduleRepository.save(schedule)
                .map(savedSchedule -> modelMapper.map(savedSchedule, ScheduleDTO.class));
    }

    @Override
    public Mono<Void> deleteSchedule(Long id) {
        return scheduleRepository.deleteById(id);
    }

    @Override
    public Flux<ScheduleDTO> findSchedulesByUserId(Long userId) {
        return scheduleRepository.findAllByUserId(userId)
                .map(schedule -> modelMapper.map(schedule, ScheduleDTO.class));
    }
}
