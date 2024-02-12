package com.web.studydeck.service.impl;

import com.web.studydeck.model.entity.Schedule;
import com.web.studydeck.model.service.ScheduleDTO;
import com.web.studydeck.repository.ScheduleRepository;
import com.web.studydeck.service.ScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private ScheduleRepository scheduleRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ScheduleDTO> findAllSchedules() {
        return scheduleRepository.findAll().stream()
                .map(schedule -> modelMapper.map(schedule, ScheduleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ScheduleDTO findScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Schedule not found with id: " + id));
        return modelMapper.map(schedule, ScheduleDTO.class);
    }

    @Override
    public ScheduleDTO saveSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = modelMapper.map(scheduleDTO, Schedule.class);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return modelMapper.map(savedSchedule, ScheduleDTO.class);
    }

    @Override
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public List<ScheduleDTO> findSchedulesByUserId(Long userId) {
        return scheduleRepository.findAllByUserId(userId).stream()
                .map(schedule -> modelMapper.map(schedule, ScheduleDTO.class))
                .collect(Collectors.toList());
    }
}
