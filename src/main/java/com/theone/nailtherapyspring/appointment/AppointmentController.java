package com.theone.nailtherapyspring.appointment;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("appointments")
    public String displayAppointments(Model model){
        model.addAttribute("title", "Appointments");
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "appointments/index";
    }

    @PostMapping("book")
    public String bookAppointment(@ModelAttribute @Valid Appointment newAppointment, Errors errors, Model model){

        if (errors.hasErrors()) {
            model.addAttribute("title", "Book Appointment");
            return "appointments/details";
        }
        appointmentRepository.save(newAppointment);
        return "redirect:/index";
    }

    @GetMapping("cancel")
    public String cancelAppointment(Model model){
      model.addAttribute("title", "Cancel Appointment");
      model.addAttribute("appointments", appointmentRepository.findAll());
      return "appointments/cancel";
    }

    @PostMapping("delete")
    public String processCancellation(int[] appointmentIds){
        if (appointmentIds != null){
            for (int id : appointmentIds){
                appointmentRepository.deleteById(id);
            }
        }
        return "redirect:/appointments";
    }

}
