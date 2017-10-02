package org.me.pi4.model;

/**
 * @author 2016203311
 */

public class Appointment {

    private int appointId;
    private Patient appPatient;
    private Doctor appDoctor; 
    private String appDate;
    private String appDescr;
    private int appPatWeight;
    private String appPatBloodPres;
    private String appPatUterusHeight;
    private String appBabyHeartBeat;
    private String appPatImc;   
 
    public Appointment() {
    }

    public int getAppointId() {
        return appointId;
    }

    public void setAppointId(int appointId) {
        this.appointId = appointId;
    }

    public Patient getAppPatient() {
        return appPatient;
    }

    public void setAppPatient(Patient appPatient) {
        this.appPatient = appPatient;
    }

    public Doctor getAppDoctor() {
        return appDoctor;
    }

    public void setAppDoctor(Doctor appDoctor) {
        this.appDoctor = appDoctor;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public String getAppDescr() {
        return appDescr;
    }

    public void setAppDescr(String appDescr) {
        this.appDescr = appDescr;
    }

    public int getAppPatWeight() {
        return appPatWeight;
    }

    public void setAppPatWeight(int appPatWeight) {
        this.appPatWeight = appPatWeight;
    }

    public String getAppPatBloodPres() {
        return appPatBloodPres;
    }

    public void setAppPatBloodPres(String appPatBloodPres) {
        this.appPatBloodPres = appPatBloodPres;
    }

    public String getAppPatUterusHeight() {
        return appPatUterusHeight;
    }

    public void setAppPatUterusHeight(String appPatUterusHeight) {
        this.appPatUterusHeight = appPatUterusHeight;
    }

    public String getAppBabyHeartBeat() {
        return appBabyHeartBeat;
    }

    public void setAppBabyHeartBeat(String appBabyHeartBeat) {
        this.appBabyHeartBeat = appBabyHeartBeat;
    }

    public String getAppPatImc() {
        return appPatImc;
    }

    public void setAppPatImc(String appPatImc) {
        this.appPatImc = appPatImc;
    }
   
}
