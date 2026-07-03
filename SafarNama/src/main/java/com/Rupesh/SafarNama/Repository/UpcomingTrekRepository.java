package com.Rupesh.SafarNama.Repository;

import com.Rupesh.SafarNama.Entity.UpcomingTrek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UpcomingTrekRepository extends JpaRepository<UpcomingTrek,Long> {
    Optional<UpcomingTrek> findByTitle(String title);
}
