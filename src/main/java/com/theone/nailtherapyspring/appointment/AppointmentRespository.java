package com.theone.nailtherapyspring.appointment;

import org.springframework.data.repository.CrudRepository;

public interface AppointmentRespository extends CrudRepository<Appointment, Integer> {
}
