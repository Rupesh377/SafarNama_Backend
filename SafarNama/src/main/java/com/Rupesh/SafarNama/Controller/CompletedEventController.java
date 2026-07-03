package com.Rupesh.SafarNama.Controller;

import com.Rupesh.SafarNama.DTO.CompletedEventRequestDTO;
import com.Rupesh.SafarNama.DTO.CompletedEventResponseDTO;
import com.Rupesh.SafarNama.Service.CompletedEventsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/completed-events")
@RequiredArgsConstructor
public class CompletedEventController {

    private final CompletedEventsService service;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CompletedEventResponseDTO> create(@Valid @RequestBody CompletedEventRequestDTO request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/completed")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<CompletedEventResponseDTO>> getAllCompleted() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CompletedEventResponseDTO> getById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(service.getByIdCompleted(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@Valid @PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

}
