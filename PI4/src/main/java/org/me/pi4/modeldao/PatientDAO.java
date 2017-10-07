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
import org.me.util.AppUtil;

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
          "SELECT a.pac_id,a.pac_codigo,a.pac_nome,a.pac_telefone,a.pac_email,\n"
        + "a.pac_nasc,Floor(DATEDIFF(now(),a.pac_nasc)/365) as pac_idade,\n" 
        + "a.pac_risco,a.pac_planejada,a.pac_status,a.pac_dum,DATEDIFF(now(),pac_dum)/7 as semana_gestacao,\n"
        + "c.sangue_nome as sangue_paciente,d.sangue_nome as conjuge_sangue,\n" 
        + "b.anomalia,b.cardiopatia,b.clamidia,b.diabetes,b.doenca_mental,b.gonorreia,\n"
        + "b.hiv,b.neoplasia,b.sifilis,b.tromboembolismo FROM appdatabase.paciente a \n" 
        + "inner join appdatabase.historico_medico b \n" 
        + "on a.pac_id = b.his_paciente \n" 
        + "Inner join appdatabase.tipo_sanguineo c\n" 
        + "On a.pac_tipo_sangue = c.sangue_id \n" 
        + "Inner join appdatabase.tipo_sanguineo d \n" 
        + "On a.pac_conj_sangue = d.sangue_id where a.pac_id=" + patientId );

        if (resultado.next()) {
            p = new Patient();
            p.setPatientId(resultado.getInt("pac_id"));
            p.setPatientCod(resultado.getInt("pac_codigo"));
            p.setPatientName(resultado.getString("pac_nome"));
            p.setPatientPhone(resultado.getString("pac_telefone"));
            p.setPatientEmail(resultado.getString("pac_email"));
            p.setPatientBloodType(resultado.getString("sangue_paciente"));
            p.setPartnerBloodType(resultado.getString("conjuge_sangue"));
            p.setPatientAge(resultado.getInt("pac_idade"));
            if(!resultado.getDate("pac_dum").toString().isEmpty())
            p.setPatientLastPeriod(AppUtil.DateFormat(resultado.getDate("pac_dum")));
            p.setPregnancyWeek(Math.ceil(resultado.getDouble("semana_gestacao")));
            p.setPlanned(resultado.getBoolean("pac_planejada"));
            p.setRisk(resultado.getBoolean("pac_risco"));
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
        ResultSet resultado = stm.executeQuery("SELECT *,Floor(DATEDIFF(now(),a.pac_nasc)/365) as pac_idade,DATEDIFF(now(),pac_dum)/7 as semana_gestacao \n"
                + "FROM appdatabase.paciente a\n"
                + "inner join appdatabase.historico_medico b\n"
                + "on a.pac_id = b.his_paciente");

        while (resultado.next()) {

            p = new Patient();
            p.setPatientName(resultado.getString("pac_nome"));
            p.setPatientBloodType(resultado.getString("pac_tipo_sangue"));
            p.setPatientId(resultado.getInt("pac_id"));
            p.setPatientCod(resultado.getInt("pac_codigo"));
            p.setPatientLastPeriod(AppUtil.DateFormat(resultado.getDate("pac_dum")));
            p.setPregnancyWeek(Math.ceil(resultado.getDouble("semana_gestacao")));
            p.setActive(resultado.getBoolean("pac_status"));
            p.setPatientAge(resultado.getInt("pac_idade"));
            
            pl.add(p);
        }
        return pl;
    }
}
