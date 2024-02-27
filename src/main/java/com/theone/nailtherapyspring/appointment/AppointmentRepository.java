package com.theone.nailtherapyspring.appointment;

import com.theone.nailtherapyspring.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
}


