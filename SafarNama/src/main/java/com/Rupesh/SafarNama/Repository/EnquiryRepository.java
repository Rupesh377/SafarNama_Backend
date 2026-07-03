package com.Rupesh.SafarNama.Repository;

import com.Rupesh.SafarNama.Entity.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry , Long> {
}
