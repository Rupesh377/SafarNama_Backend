package com.Rupesh.SafarNama.Controller;
import com.Rupesh.SafarNama.DTO.DashBoardDTO;
import com.Rupesh.SafarNama.Repository.CompletedEventRepository;
import com.Rupesh.SafarNama.Repository.EnquiryRepository;
import com.Rupesh.SafarNama.Repository.UpcomingEventRepository;
import com.Rupesh.SafarNama.Repository.UpcomingTrekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dashboard")
public class DashBoardController {

    private final UpcomingEventRepository upcomingEventRepository;
    private final UpcomingTrekRepository upcomingTrekRepository;
    private final CompletedEventRepository completedEventRepository;
    private final EnquiryRepository enquiryRepository;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DashBoardDTO> getDashboardStats() {

        DashBoardDTO response = new DashBoardDTO(upcomingEventRepository.count(), completedEventRepository.count(),
                upcomingTrekRepository.count(), enquiryRepository.count());
        return ResponseEntity.ok(response);
    }
}
