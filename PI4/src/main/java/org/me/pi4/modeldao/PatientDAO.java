package org.me.pi4.modeldao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.me.pi4.database.DbConnection;
import org.me.pi4.model.Patient;

/**
 * @author 2016203311
 */
public class PatientDAO extends DAO {

    public PatientDAO() {
        super();
    }

    public void addUser(Connection conector, Patient p) throws SQLException {
    }

    public int updateUser(Connection conector, Patient p, int resultado) {
        return 0;
    }

    public static Patient GetPatient(int patientId) throws SQLException {

        DbConnection.instancia();
        Connection con = DbConnection.instancia().getConnection();
        Patient p = null;
        Statement stm = null;

        stm = con.createStatement();
        ResultSet resultado = stm.executeQuery(
                "SELECT *,DATEDIFF(now(),pac_dum)/7 as semana_gestacao FROM appdatabase.paciente a \n"
                + "inner join appdatabase.historico_medico b\n"
                + "on a.pac_id = b.his_paciente where pac_id=" + patientId
        );

        if (resultado.next()) {
            p = new Patient();
            p.setPatientName(resultado.getString("pac_nome"));
            p.setPatientBloodType(resultado.getString("pac_tipo_sangue"));
            p.setPatientLastPeriod(resultado.getDate("pac_dum"));
            p.setPregnancyWeek((int) resultado.getInt("semana_gestacao"));
            p.setActive(resultado.getBoolean("pac_status"));
        }
        return p;
    }

    public static ArrayList<Patient> GetAllPatients() throws SQLException {
        ArrayList<Patient> pl = new ArrayList<>();
        DbConnection.instancia();
        Connection con = DbConnection.instancia().getConnection();
        Patient p = null;
        Statement stm = null;

        stm = con.createStatement();
        ResultSet resultado = stm.executeQuery("SELECT *,DATEDIFF(now(),pac_dum)/7 as semana_gestacao "
                + "FROM appdatabase.paciente a"
                + "inner join appdatabase.historico_medico b"
                + "on a.pac_id = b.his_paciente");

        while (resultado.next()) {

            p = new Patient();
            p.setPatientName(resultado.getString("pac_nome"));
            p.setPatientBloodType(resultado.getString("pac_tipo_sangue"));
            p.setPatientLastPeriod(resultado.getDate("pac_dum"));
            p.setPregnancyWeek((int) resultado.getInt("semana_gestacao"));
            p.setActive(resultado.getBoolean("pac_status"));
            pl.add(p);
        }
        return pl;
    }
}
