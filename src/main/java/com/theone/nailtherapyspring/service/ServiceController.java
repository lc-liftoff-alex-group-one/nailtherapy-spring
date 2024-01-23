package com.theone.nailtherapyspring.service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Services", description = "Client services management API endpoints")
@RestController
@RequestMapping("/api/v1/services")
public class ServiceController {
    private final ServiceRepository serviceRepository;
    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceRepository serviceRepository, ServiceService serviceService) {
        this.serviceRepository = serviceRepository;
        this.serviceService = serviceService;
    }

    @Operation(
            summary = "Retrieve all services",
            description = "Responds with a list of all service objects with id, name, description, price, and available status.",
            tags = { "services", "get" }
    )
    @GetMapping
    public ResponseEntity<List<Service>> getAllServices() {
        return serviceService.getAllServices();
    }

    @Operation(
            summary = "Retrieve a service by id",
            description = "Get a service object by specifying its id.  Responds with a Service object with id, name, description, price, and available status.",
            tags = { "services", "get" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Service.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/{id}")
    public ResponseEntity<ResponseEntity<Optional<Service>>> getServiceById(@PathVariable Integer id) {
        ResponseEntity<Optional<Service>> service = serviceService.getServiceById(id);
        if (service != null) {
            return ResponseEntity.ok(service);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Save a new service",
            description = "Save a new service object.  Responds with the new Service object with id, name, description, price, and available status.",
            tags = { "services", "post" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Service.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping
    public ResponseEntity<Service> saveService(@RequestBody Service service) {
        Service newService = serviceRepository.save(service);
        return ResponseEntity.ok(newService);
    }

    @Operation(
            summary = "Update a service",
            description = "Update a service object by specifying its id.  Responds with the updated Service object with id, name, description, price, and available status.",
            tags = { "services", "put" }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Service.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping("/{id}")
    public ResponseEntity<Service> updateService(@PathVariable Integer id, @RequestBody Service service) {
        return serviceService.updateService(id, service);
    }

    @Operation(
            summary = "Delete a service by id",
            description = "Delete a service object by specifying its id.",
            tags = { "services", "delete" }
    )
    @DeleteMapping("/{id}")
    public String deleteService(@PathVariable Integer id) {
        serviceService.deleteService(id);
        return "Service id " + id + " deleted";
    }
}
