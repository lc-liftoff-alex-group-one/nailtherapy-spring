package com.theone.nailtherapyspring.appointment;


import com.theone.nailtherapyspring.service.Service;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

public class Appointment {

    @Id
    @GeneratedValue
    private int id;

   private String day;
   private String time;
   private Service service;

   public Appointment(String day, String time, Service service){
       this.day = day;
       this.time = time;
       this.service = service;

   }


   public Appointment(){}

    public int getId() {
        return id;
    }

    public Appointment(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
