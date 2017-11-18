package org.me.pi4.model;

import java.sql.Date;

/**
 * @author 2016203311
 */
public class Patient {

    private int patientId;
    private int patientCod;
    private String patientName;
    private String patientPhone;
    private String patientEmail;
    private Date patientBirthDate;
    private int PatientAge;
    private String patientBloodType;
    private String partnerBloodType;
    private String patientLastPeriod;
    private Double pregnancyWeek;
    private boolean active;
    private boolean planned;
    private boolean risk;
    private boolean hiv;
    private boolean sifilis;
    private boolean gonorreia;
    private boolean clamidia;
    private boolean diabetes;
    private boolean doencaMental;
    private boolean anomalia;
    private boolean neoplasia;
    private boolean tromboembo;
    private boolean cardiopatia;
    private String patientImage;
            
    public Patient() {
    }

    public String getPatientImage() {
        return patientImage;
    }

    public void setPatientImage(String patientImage) {
        this.patientImage = patientImage;
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

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public int getPatientAge() {
        return PatientAge;
    }

    public void setPatientAge(int PatientAge) {
        this.PatientAge = PatientAge;
    }

    public String getPartnerBloodType() {
        return partnerBloodType;
    }

    public void setPartnerBloodType(String partnerBloodType) {
        this.partnerBloodType = partnerBloodType;
    }

    public boolean isPlanned() {
        return planned;
    }

    public void setPlanned(boolean planned) {
        this.planned = planned;
    }

    public boolean isRisk() {
        return risk;
    }

    public void setRisk(boolean risk) {
        this.risk = risk;
    }

    public boolean isHiv() {
        return hiv;
    }

    public void setHiv(boolean hiv) {
        this.hiv = hiv;
    }

    public boolean isSifilis() {
        return sifilis;
    }

    public void setSifilis(boolean sifilis) {
        this.sifilis = sifilis;
    }

    public boolean isGonorreia() {
        return gonorreia;
    }

    public void setGonorreia(boolean gonorreia) {
        this.gonorreia = gonorreia;
    }

    public boolean isClamidia() {
        return clamidia;
    }

    public void setClamidia(boolean clamidia) {
        this.clamidia = clamidia;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public boolean isDoencaMental() {
        return doencaMental;
    }

    public void setDoencaMental(boolean doencaMental) {
        this.doencaMental = doencaMental;
    }

    public boolean isAnomalia() {
        return anomalia;
    }

    public void setAnomalia(boolean anomalia) {
        this.anomalia = anomalia;
    }

    public boolean isNeoplasia() {
        return neoplasia;
    }

    public void setNeoplasia(boolean neoplasia) {
        this.neoplasia = neoplasia;
    }

    public boolean isTromboembo() {
        return tromboembo;
    }

    public void setTromboembo(boolean tromboembo) {
        this.tromboembo = tromboembo;
    }

    public boolean isCardiopatia() {
        return cardiopatia;
    }

    public void setCardiopatia(boolean cardiopatia) {
        this.cardiopatia = cardiopatia;
    }
    
}
