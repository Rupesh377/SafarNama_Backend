package com.Rupesh.SafarNama.Controller;

import com.Rupesh.SafarNama.DTO.UpcomingEventRequestDTO;
import com.Rupesh.SafarNama.DTO.UpcomingEventResponseDTO;
import com.Rupesh.SafarNama.DTO.UpcomingTrekRequestDTO;
import com.Rupesh.SafarNama.DTO.UpcomingTrekResponseDTO;
import com.Rupesh.SafarNama.Service.UpcomingEventService;
import com.Rupesh.SafarNama.Service.UpcomingTrekService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/upcoming-events")
@RequiredArgsConstructor
public class UpcomingEventController {

    private final UpcomingEventService service;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UpcomingEventResponseDTO> create( @Valid   @RequestBody UpcomingEventRequestDTO request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/upcoming-event")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UpcomingEventResponseDTO>> getAllUpcomingEvents() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UpcomingEventResponseDTO> getById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(service.getByIdUpcoming(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@Valid @PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
