
package org.me.pi4.model;

public class Attendance {
    private int attendanceId;
    private int attendancePatientId;
    private int attendanceDocId;
    private String attendancePatientName;
    private String attendanceDoctorName;
    private String attendanceDate;
    private String attendanceHour;
    
    /////////////////////////////////////
    private String attendanceUser;
    private String attendanceUserImei;
    private String attendanceUserNet;

    public Attendance() {
    }

    public String getAttendanceUser() {
        return attendanceUser;
    }

    public void setAttendanceUser(String attendanceUser) {
        this.attendanceUser = attendanceUser;
    }

    public String getAttendanceUserImei() {
        return attendanceUserImei;
    }

    public void setAttendanceUserImei(String attendanceUserImei) {
        this.attendanceUserImei = attendanceUserImei;
    }

    public String getAttendanceUserNet() {
        return attendanceUserNet;
    }

    public void setAttendanceUserNet(String attendanceUserNet) {
        this.attendanceUserNet = attendanceUserNet;
    }

    public String getAttendancePatientName() {
        return attendancePatientName;
    }

    public void setAttendancePatientName(String attendancePatientName) {
        this.attendancePatientName = attendancePatientName;
    }

    public String getAttendanceDoctorName() {
        return attendanceDoctorName;
    }

    public void setAttendanceDoctorName(String attendanceDoctorName) {
        this.attendanceDoctorName = attendanceDoctorName;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getAttendancePatientId() {
        return attendancePatientId;
    }

    public void setAttendancePatientId(int attendancePatientId) {
        this.attendancePatientId = attendancePatientId;
    }

    public int getAttendanceDocId() {
        return attendanceDocId;
    }

    public void setAttendanceDocId(int attendanceDocId) {
        this.attendanceDocId = attendanceDocId;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getAttendanceHour() {
        return attendanceHour;
    }

    public void setAttendanceHour(String attendanceHour) {
        this.attendanceHour = attendanceHour;
    }
    
    
}
