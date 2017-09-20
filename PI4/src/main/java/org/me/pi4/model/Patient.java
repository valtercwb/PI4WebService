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
    private Date patientLastPeriod;
    private boolean patientStatus;
        
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

    public Date getPatientLastPeriod() {
        return patientLastPeriod;
    }

    public void setPatientLastPeriod(Date patientLastPeriod) {
        this.patientLastPeriod = patientLastPeriod;
    }

    public boolean isPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(boolean patientStatus) {
        this.patientStatus = patientStatus;
    }

    public Date getPatientBirthDate() {
        return patientBirthDate;
    }

    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate = patientBirthDate;
    }
   
}
