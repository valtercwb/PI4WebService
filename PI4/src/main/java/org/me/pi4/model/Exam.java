package org.me.pi4.model;

/**
 *
 * @author valter.franco
 */
public class Exam {
    
    private int examId;
    private int examPatient;
    private String examDoctor;
    private String examReason;
    private int examMedia;
    private String examDate;
    private String examPlace;

    public Exam() {
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getExamPatient() {
        return examPatient;
    }

    public void setExamPatient(int examPatient) {
        this.examPatient = examPatient;
    }

    public String getExamDoctor() {
        return examDoctor;
    }

    public void setExamDoctor(String examDoctor) {
        this.examDoctor = examDoctor;
    }

    public String getExamReason() {
        return examReason;
    }

    public void setExamReason(String examReason) {
        this.examReason = examReason;
    }

    public int getExamMedia() {
        return examMedia;
    }

    public void setExamMedia(int examMedia) {
        this.examMedia = examMedia;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamPlace() {
        return examPlace;
    }

    public void setExamPlace(String examPlace) {
        this.examPlace = examPlace;
    }
    
    
    
}
