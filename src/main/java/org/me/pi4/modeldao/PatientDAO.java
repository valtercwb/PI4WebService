package org.me.pi4.modeldao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.me.pi4.database.DbPostgre;
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

        DbPostgre.instancia();
        Connection con = DbPostgre.instancia().getConnection();
        Patient p = null;
        Historic h = null;
        Statement stm = null;

        stm = con.createStatement();
        ResultSet resultado = stm.executeQuery(
        "SELECT pac_id,pac_codigo,pac_nome,pac_telefone,pac_email,\n"
        +"pac_nasc,DATE_PART('year', now()) - DATE_PART('year', pac_nasc) as pac_idade,\n"
        +"pac_risco,pac_planejada,pac_status,pac_dum,TRUNC(DATE_PART('day', now() - pac_dum)/7) as semana_gestacao,\n"
        +"pac_tipo_sangue,pac_conj_sangue,\n"
        +"anomalia,cardiopatia,clamidia,diabetes,doenca_mental,gonorreia,\n"
        +"hiv,neoplasia,sifilis,tromboembolismo FROM paciente a \n" 
        +"where pac_id = " + patientId );

        if (resultado.next()) {
            p = new Patient();
            p.setPatientId(resultado.getInt("pac_id"));
            p.setPatientCod(resultado.getInt("pac_codigo"));
            p.setPatientName(resultado.getString("pac_nome"));
            p.setPatientPhone(resultado.getString("pac_telefone"));
            p.setPatientEmail(resultado.getString("pac_email"));
            p.setPatientBloodType(resultado.getString("pac_tipo_sangue"));
            p.setPartnerBloodType(resultado.getString("pac_conj_sangue"));
            p.setPatientAge(resultado.getInt("pac_idade"));
            if(!resultado.getDate("pac_dum").toString().isEmpty())
            p.setPatientLastPeriod(AppUtil.DateFormat(resultado.getDate("pac_dum")));
            p.setPregnancyWeek(Math.ceil(resultado.getDouble("semana_gestacao")));
            p.setPlanned(resultado.getBoolean("pac_planejada"));
            p.setRisk(resultado.getBoolean("pac_risco"));
            p.setActive(resultado.getBoolean("pac_status"));
            p.setDiabetes(resultado.getBoolean("diabetes"));
            p.setHiv(resultado.getBoolean("hiv"));
            p.setSifilis(resultado.getBoolean("sifilis"));
            p.setGonorreia(resultado.getBoolean("gonorreia"));
            p.setClamidia(resultado.getBoolean("clamidia"));
            p.setNeoplasia(resultado.getBoolean("neoplasia"));
            p.setDoencaMental(resultado.getBoolean("doenca_mental"));
            p.setCardiopatia(resultado.getBoolean("cardiopatia"));
            p.setAnomalia(resultado.getBoolean("anomalia"));
            p.setTromboembo(resultado.getBoolean("tromboembolismo"));
        }
        return p;
    }

    public static ArrayList<Patient> GetAllPatients() throws SQLException {
        ArrayList<Patient> pl = new ArrayList<>();
        DbPostgre.instancia();
        Connection con = DbPostgre.instancia().getConnection();
        Patient p = null;
        
        Statement stm = null;

        stm = con.createStatement();
        ResultSet resultado = stm.executeQuery(
            "SELECT *,DATE_PART('year', now()) - DATE_PART('year', pac_nasc) as pac_idade,\n" 
            +"TRUNC(DATE_PART('day', now() - pac_dum)/7) as semana_gestacao\n" 
            +"FROM paciente");

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
