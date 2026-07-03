package com.Rupesh.SafarNama.Service;

import com.Rupesh.SafarNama.DTO.UpcomingEventRequestDTO;
import com.Rupesh.SafarNama.DTO.UpcomingEventResponseDTO;
import com.Rupesh.SafarNama.Entity.UpcomingEvent;
import com.Rupesh.SafarNama.Exception.BadRequestException;
import com.Rupesh.SafarNama.Exception.ResourceNotFoundException;
import com.Rupesh.SafarNama.Repository.UpcomingEventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UpcomingEventService {

    private final ModelMapper modelMapper;
    private final UpcomingEventRepository repository;

    public UpcomingEventResponseDTO create(UpcomingEventRequestDTO request) {
        repository.findByTitle(request.getTitle())
                .ifPresent(event -> {
                    throw new BadRequestException("Event already present with title: " + request.getTitle());
                });

        UpcomingEvent event = new UpcomingEvent();

        event.setTitle(request.getTitle());
        event.setLocation(request.getLocation());
        event.setTime(request.getTime());
        event.setPrice(request.getPrice());
        event.setImageUrl(request.getImageUrl());
        event.setDescription(request.getDescription());
        event.setItinerary(request.getItinerary());

        repository.save(event);
        return modelMapper.map(event , UpcomingEventResponseDTO.class);
    }

    public List<UpcomingEventResponseDTO> getAll() {
        List<UpcomingEvent> upcomingEvents =repository.findAll();

        return upcomingEvents.stream().map(UpcomingEvents ->
                        modelMapper.map(UpcomingEvents, UpcomingEventResponseDTO.class))
                .collect(Collectors.toList());
    }

    public UpcomingEventResponseDTO getByIdUpcoming(Long id) {
        UpcomingEvent upcomingEvent = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        return modelMapper.map(upcomingEvent, UpcomingEventResponseDTO.class);
    }

    public void delete(Long id) {
        UpcomingEvent upcomingEvent =repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Event not found"));
        repository.deleteById(id);
    }
}
