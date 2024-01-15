package com.theone.nailtherapyspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/services")
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ServiceService serviceService;

    @GetMapping
    public ResponseEntity<List<Service>> getAllServices() {
        return serviceService.getAllServices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseEntity<Optional<Service>>> getServiceById(@PathVariable Integer id) {
        ResponseEntity<Optional<Service>> service = serviceService.getServiceById(id);
        if (service != null) {
            return ResponseEntity.ok(service);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Service> saveService(@RequestBody Service service) {
        Service newService = serviceRepository.save(service);
        return ResponseEntity.ok(newService);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> updateService(@PathVariable Integer id, @RequestBody Service service) {
        return serviceService.updateService(id, service);
    }

    @DeleteMapping("/{id}")
    public String deleteService(@PathVariable Integer id) {
        serviceService.deleteService(id);
        return "Service id " + id + " deleted";
    }
}
