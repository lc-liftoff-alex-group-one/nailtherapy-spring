package com.theone.nailtherapyspring.scheduling;

import org.springframework.data.repository.CrudRepository;

public interface AppointmentRespository extends CrudRepository<Appointment, Integer> {
}
