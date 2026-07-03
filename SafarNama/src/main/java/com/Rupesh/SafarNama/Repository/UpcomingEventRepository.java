package com.Rupesh.SafarNama.Repository;

import com.Rupesh.SafarNama.Entity.UpcomingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UpcomingEventRepository extends JpaRepository<UpcomingEvent , Long> {
    Optional<UpcomingEvent> findByTitle(String title);
}
