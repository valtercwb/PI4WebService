package org.me.pi4.model;

import java.sql.Date;

/**
 * @author 2016203311
 */
public class Patient {

    private int patientId;
    private int patientCod;
    private String patientName;
    private String patientBloodType; 
    private String patientPhone;
    private Date patientBirthDate;
    private String patientLastPeriod;
    private Double pregnancyWeek;
    private boolean active;
    private Historic historic;

    public Historic getHistoric() {
        return historic;
    }

    public void setHistoric(Historic historic) {
        this.historic = historic;
    }
       
    public Patient() {
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPatientCod() {
        return patientCod;
    }

    public void setPatientCod(int patientCod) {
        this.patientCod = patientCod;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientBloodType() {
        return patientBloodType;
    }

    public void setPatientBloodType(String patientBloodType) {
        this.patientBloodType = patientBloodType;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientLastPeriod() {
        return patientLastPeriod;
    }

    public void setPatientLastPeriod(String patientLastPeriod) {
        this.patientLastPeriod = patientLastPeriod;
    }

    public Date getPatientBirthDate() {
        return patientBirthDate;
    }

    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate = patientBirthDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Double getPregnancyWeek() {
        return pregnancyWeek;
    }

    public void setPregnancyWeek(Double pregnancyWeek) {
        this.pregnancyWeek = pregnancyWeek;
    }
   
}
