package com.Rupesh.SafarNama.Controller;

import com.Rupesh.SafarNama.DTO.CompletedEventResponseDTO;
import com.Rupesh.SafarNama.DTO.EnquiryDTO;
import com.Rupesh.SafarNama.DTO.UpcomingEventResponseDTO;
import com.Rupesh.SafarNama.DTO.UpcomingTrekResponseDTO;
import com.Rupesh.SafarNama.Entity.Enquiry;
import com.Rupesh.SafarNama.Service.CompletedEventsService;
import com.Rupesh.SafarNama.Service.EnquiryService;
import com.Rupesh.SafarNama.Service.UpcomingEventService;
import com.Rupesh.SafarNama.Service.UpcomingTrekService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class PublicController {

    private final CompletedEventsService completedEventsService;
    private final UpcomingTrekService upcomingTrekService;
    private final UpcomingEventService upcomingEventService;
    private final EnquiryService service;

    @PostMapping("/enquiry")
    public ResponseEntity<Enquiry> create(@Valid @RequestBody EnquiryDTO request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/completed-event")
    public ResponseEntity<List<CompletedEventResponseDTO>> getAllCompleted() {
        return ResponseEntity.ok(completedEventsService.getAll());
    }
    @GetMapping("/upcoming-trek")
    public ResponseEntity<List<UpcomingTrekResponseDTO>> getAllUpcoming() {
        return ResponseEntity.ok(upcomingTrekService.getAll());
    }

    @GetMapping("/upcoming-event")
    public ResponseEntity<List<UpcomingEventResponseDTO>> getAllUpcomingEvents() {
        return ResponseEntity.ok(upcomingEventService.getAll());
    }
}
