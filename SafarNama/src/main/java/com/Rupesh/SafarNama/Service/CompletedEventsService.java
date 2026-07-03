package com.Rupesh.SafarNama.Service;

import com.Rupesh.SafarNama.DTO.CompletedEventRequestDTO;
import com.Rupesh.SafarNama.DTO.CompletedEventResponseDTO;
import com.Rupesh.SafarNama.Entity.CompletedEvent;
import com.Rupesh.SafarNama.Exception.ResourceNotFoundException;
import com.Rupesh.SafarNama.Repository.CompletedEventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompletedEventsService {

    private final CompletedEventRepository repository;
    private final ModelMapper modelMapper;

    public CompletedEventResponseDTO create(CompletedEventRequestDTO request) {

        repository.findByTitle(request.getTitle())
                .ifPresent(event -> {
                    throw new RuntimeException("Event already present with title: " + request.getTitle());
                });

        CompletedEvent event=CompletedEvent.builder()
                .title(request.getTitle())
        .location(request.getLocation())
        .duration(request.getDuration())
        .price(request.getPrice())
        .imageUrl(request.getImageUrl())
        .description(request.getDescription())
        .itinerary(request.getItinerary())
        .totalMembers(request.getTotalMembers())
        .build();

        repository.save(event);
        return modelMapper.map(event , CompletedEventResponseDTO.class);
    }

    public List<CompletedEventResponseDTO> getAll() {
        List<CompletedEvent> dto = repository.findAll();
        return dto.stream().map(DTO -> modelMapper.map(DTO, CompletedEventResponseDTO.class))
                .collect(Collectors.toList());
    }

    public CompletedEventResponseDTO getByIdCompleted(Long id) {
         CompletedEvent completedEvent=repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Completed Event not found"));

         return modelMapper.map(completedEvent , CompletedEventResponseDTO.class);
    }

    public void delete(Long id) {
        CompletedEvent completedEvent=repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Completed Event not found"));

        repository.deleteById(id);
    }
}
