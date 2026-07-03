package com.Rupesh.SafarNama.Controller;

import com.Rupesh.SafarNama.DTO.UpcomingTrekRequestDTO;
import com.Rupesh.SafarNama.DTO.UpcomingTrekResponseDTO;
import com.Rupesh.SafarNama.Service.UpcomingTrekService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/upcoming-trek")
@RequiredArgsConstructor
public class UpcomingTrekController {

    private final UpcomingTrekService service;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UpcomingTrekResponseDTO> create(@Valid  @RequestBody UpcomingTrekRequestDTO request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/upcoming-trek")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UpcomingTrekResponseDTO>> getAllUpcoming() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UpcomingTrekResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getByIdUpcoming(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
