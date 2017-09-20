package org.me.pi4.modeldao;

import java.sql.Connection;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import org.me.pi4.model.Appointment;

/**
 * @author 2016203311
 */

public class AppointmentDAO extends DAO{

    public AppointmentDAO() {
        super();
    }
    
    public void addAppointment(Connection conector, Appointment a) throws SQLException {
     }
     
     public int updateAppointment(Connection conector, Appointment a, int resultado) {
     return 0;
     }
     
     public int DeleteAppointment(int pId) {
     return 0;
     }
     
     public static void getAppointment(Connection conector, ObservableList<Appointment> list) {
     }
     
     public static void getAllAppointments(Connection conector, ObservableList<Appointment> list) {
     }
}
