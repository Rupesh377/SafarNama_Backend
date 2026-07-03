package com.Rupesh.SafarNama.Service;

import com.Rupesh.SafarNama.DTO.EnquiryDTO;
import com.Rupesh.SafarNama.DTO.EnquiryResponseDTO;
import com.Rupesh.SafarNama.Entity.Enquiry;
import com.Rupesh.SafarNama.Exception.ResourceNotFoundException;
import com.Rupesh.SafarNama.Repository.EnquiryRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnquiryService {

    private final EnquiryRepository repository;
    private final EmailService emailService;
    private final ModelMapper modelMapper;

    public Enquiry create(EnquiryDTO request) {
        Enquiry enquiry = new Enquiry();
        enquiry.setName(request.getName());
        enquiry.setEmail(request.getEmail());
        enquiry.setPhone(request.getPhone());
        enquiry.setSubject(request.getSubject());
        enquiry.setMessage(request.getMessage());

        Enquiry saved = repository.save(enquiry);

        emailService.sendEnquiryEmail(request.getName(), request.getEmail(),
                request.getPhone(),request.getSubject() , request.getMessage());
        return saved;
    }

    public List<EnquiryResponseDTO> getAll() {
        return repository.findAll().stream().map(
                enquiry -> modelMapper.map(enquiry, EnquiryResponseDTO.class)).toList();
    }

    public void delete(Long id) {
        Enquiry enquiry = repository.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Enquiry not found with id: " + id));
        repository.delete(enquiry);
    }
}
