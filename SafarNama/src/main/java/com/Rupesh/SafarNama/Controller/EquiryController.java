package com.Rupesh.SafarNama.Controller;

import com.Rupesh.SafarNama.DTO.EnquiryDTO;
import com.Rupesh.SafarNama.DTO.EnquiryResponseDTO;
import com.Rupesh.SafarNama.Entity.Enquiry;
import com.Rupesh.SafarNama.Service.EnquiryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EquiryController {

    private final EnquiryService service;

    @GetMapping("/enquiries")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<EnquiryResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/enquiries/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Enquiry deleted successfully");
    }
}
