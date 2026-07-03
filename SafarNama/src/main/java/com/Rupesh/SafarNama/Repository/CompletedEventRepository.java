package com.Rupesh.SafarNama.Repository;

import com.Rupesh.SafarNama.DTO.CompletedEventRequestDTO;
import com.Rupesh.SafarNama.Entity.CompletedEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompletedEventRepository extends JpaRepository<CompletedEvent,Long> {

    Optional<CompletedEvent> findByTitle(String title);
}
