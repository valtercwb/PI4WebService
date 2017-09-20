package org.me.pi4.database;

import org.me.pi4.modeldao.AppointmentDAO;
import org.me.pi4.modeldao.DoctorDAO;
import org.me.pi4.modeldao.HistoricDAO;
import org.me.pi4.modeldao.PatientDAO;
import org.me.pi4.modeldao.UserDAO;

/**
 * Deal with taking care of the DAO objects and a lot of database operations filtering these operations.
 * @autor valterFranco<uncuritibaAds>
 */

public class DaoController {

    private static DaoController banco = new DaoController();

    private final UserDAO userDAO = new UserDAO();
    private final PatientDAO patientDAO = new PatientDAO();
    private final AppointmentDAO appointmentDAO = new AppointmentDAO();
    private final DoctorDAO doctorDAO = new DoctorDAO();
    private final HistoricDAO historicDAO = new HistoricDAO();

    public static DaoController getBanco() {
        return banco;
    }
}
