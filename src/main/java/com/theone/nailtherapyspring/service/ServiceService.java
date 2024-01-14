package com.theone.nailtherapyspring.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public ResponseEntity<com.theone.nailtherapyspring.service.Service> saveService(@RequestBody com.theone.nailtherapyspring.service.Service service) {
        com.theone.nailtherapyspring.service.Service newService = serviceRepository.save(service);
        return ResponseEntity.ok(newService);
    }

    public ResponseEntity<List<com.theone.nailtherapyspring.service.Service>> getAllServices() {
        return ResponseEntity.ok((List<com.theone.nailtherapyspring.service.Service>) serviceRepository.findAll());
    }

    public ResponseEntity<Optional<com.theone.nailtherapyspring.service.Service>> getServiceById(Integer id) {
        Optional<com.theone.nailtherapyspring.service.Service> service = serviceRepository.findById(id);
        if (service.isPresent()) {
            return ResponseEntity.ok(service);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<com.theone.nailtherapyspring.service.Service> updateService(Integer id, com.theone.nailtherapyspring.service.Service updatedService) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        com.theone.nailtherapyspring.service.Service service = serviceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException((String.valueOf(id))));
        service.setName(updatedService.getName());
        service.setDescription(updatedService.getDescription());
        service.setPrice(updatedService.getPrice());
        service.setAvailable(updatedService.getAvailable());

        com.theone.nailtherapyspring.service.Service savedService = serviceRepository.save(service);
        return ResponseEntity.ok(savedService);
    }

    public ResponseEntity<String> deleteService(Integer id) {
        serviceRepository.deleteById(id);
        return ResponseEntity.ok("Service deleted");
    }
}
