package com.Rupesh.SafarNama.Service;

import com.Rupesh.SafarNama.DTO.UpcomingTrekRequestDTO;
import com.Rupesh.SafarNama.DTO.UpcomingTrekResponseDTO;
import com.Rupesh.SafarNama.Entity.UpcomingTrek;
import com.Rupesh.SafarNama.Exception.ResourceNotFoundException;
import com.Rupesh.SafarNama.Repository.UpcomingTrekRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UpcomingTrekService {

    private final ModelMapper modelMapper;
    private final UpcomingTrekRepository repository;

    public UpcomingTrekResponseDTO create(UpcomingTrekRequestDTO request) {

        repository.findByTitle(request.getTitle())
                .ifPresent(event -> {
                    throw new RuntimeException("Event already present with title: " + request.getTitle());
                });
        UpcomingTrek event = new UpcomingTrek();

        event.setTitle(request.getTitle());
        event.setLocation(request.getLocation());
        event.setStartDate(request.getStartDate());
        event.setEndDate(request.getEndDate());
        event.setPrice(request.getPrice());
        event.setImageUrl(request.getImageUrl());
        event.setDescription(request.getDescription());
        event.setItinerary(request.getItinerary());
        event.setInclusion(request.getInclusion());
        event.setDifficultyLevel(request.getDifficultyLevel());
        event.setMeetingPoint(request.getMeetingPoint());

        repository.save(event);
        return modelMapper.map(event , UpcomingTrekResponseDTO.class);
    }

    public List<UpcomingTrekResponseDTO> getAll() {
         List<UpcomingTrek> upcomingTrek =repository.findAll();

         return upcomingTrek.stream().map(UpcomingTrek ->
                         modelMapper.map(UpcomingTrek, UpcomingTrekResponseDTO.class))
                 .collect(Collectors.toList());
    }

    public UpcomingTrekResponseDTO getByIdUpcoming(Long id) {
        UpcomingTrek upcomingTrek = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        return modelMapper.map(upcomingTrek, UpcomingTrekResponseDTO.class);
    }

    public void delete(Long id) {
        UpcomingTrek upcomingTrek =repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Event not found"));
        repository.deleteById(id);
    }
}
