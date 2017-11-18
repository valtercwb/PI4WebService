
package org.me.pi4.model;

public class Attendance {
    private int attendanceId;
    private int attendancePatientId;
    private int attendanceDocId;
    private String attendanceDate;
    private String attendanceHour;

    public Attendance() {
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
