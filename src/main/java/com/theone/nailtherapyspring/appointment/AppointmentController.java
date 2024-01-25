package com.theone.nailtherapyspring.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("schedule")
public class AppointmentController {

    @Autowired
    private AppointmentRespository appointmentRespository;

    @GetMapping
    public String displayAppointments(){

    }
}
