package org.me.pi4.modeldao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.me.pi4.database.DbConnection;
import org.me.pi4.model.Historic;
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
        Historic h = null;
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
            p.setPatientId(resultado.getInt("pac_id"));
            p.setPatientCod(resultado.getInt("pac_codigo"));
            p.setPatientLastPeriod(dateFortmat(resultado.getDate("pac_dum")));
            p.setPregnancyWeek(Math.ceil(resultado.getDouble("semana_gestacao")));
            p.setActive(resultado.getBoolean("pac_status"));
            h = new Historic();
            h.setDiabetes(resultado.getBoolean("diabetes"));
            h.setHiv(resultado.getBoolean("hiv"));
            h.setSifilis(resultado.getBoolean("sifilis"));
            h.setGonorreia(resultado.getBoolean("gonorreia"));
            h.setClamidia(resultado.getBoolean("clamidia"));
            h.setNeoplasia(resultado.getBoolean("neoplasia"));
            h.setDoencaMental(resultado.getBoolean("doenca_mental"));
            h.setCardiopatia(resultado.getBoolean("cardiopatia"));
            h.setAnomalia(resultado.getBoolean("anomalia"));
            h.setTromboembo(resultado.getBoolean("tromboembolismo"));
            p.setHistoric(h);
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
        ResultSet resultado = stm.executeQuery("SELECT *,DATEDIFF(now(),pac_dum)/7 as semana_gestacao \n"
                + "FROM appdatabase.paciente a\n"
                + "inner join appdatabase.historico_medico b\n"
                + "on a.pac_id = b.his_paciente");

        while (resultado.next()) {

            p = new Patient();
            p.setPatientName(resultado.getString("pac_nome"));
            p.setPatientBloodType(resultado.getString("pac_tipo_sangue"));
            p.setPatientId(resultado.getInt("pac_id"));
            p.setPatientCod(resultado.getInt("pac_codigo"));
            p.setPatientLastPeriod(dateFortmat(resultado.getDate("pac_dum")));
            p.setPregnancyWeek(Math.ceil(resultado.getDouble("semana_gestacao")));
            p.setActive(resultado.getBoolean("pac_status"));
            
            pl.add(p);
        }
        return pl;
    }

    public static String dateFortmat(Date dt) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        String dateTime = sdf.format(dt);
        return dateTime;
    }
}
