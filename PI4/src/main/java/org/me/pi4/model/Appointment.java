package org.me.pi4.model;

import java.sql.Date;

/**
 * @author 2016203311
 */

public class Appointment {

    private int appointId;
    private Patient patient;
    private Doctor doctor; 
    private String desc;
    private Date scheduledDate;
    private Date appointmentDay;

    public Appointment() {
    }
   
}
