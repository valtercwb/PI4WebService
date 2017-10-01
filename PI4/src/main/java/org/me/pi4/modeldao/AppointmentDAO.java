package org.me.pi4.modeldao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.me.pi4.database.DbConnection;
import org.me.pi4.model.Appointment;
import org.me.pi4.model.Doctor;
import org.me.util.AppUtil;

/**
 * @author 2016203311
 */

public class AppointmentDAO extends DAO{

    

    public AppointmentDAO() {
        super();
    }
    
    public static Appointment GetAppointment(int appointmentId) {
        Appointment a = null;
        return a;
    }
    
    public void addAppointment(Connection conector, Appointment a) throws SQLException {
     }
     
     public int updateAppointment(Connection conector, Appointment a, int resultado) {
     return 0;
     }
     
     public int DeleteAppointment(int pId) {
     return 0;
     }
             
      public static ArrayList<Appointment> GetAllAppointments(int pacientId) throws SQLException {
        ArrayList<Appointment> ap = new ArrayList<>();
        DbConnection.instancia();
        Connection con = DbConnection.instancia().getConnection();
        Appointment a = null;
        Doctor d;
     
        Statement stm = null;

        stm = con.createStatement();
        ResultSet resultado = stm.executeQuery("SELECT b.FK_pac_id as pac_id, c.med_nome as medico,\n"
                + "b.con_data,b.con_desc as descricao,\n" 
                + "Truncate(b.con_peso/(pow(a.pac_altura,2)),1) as imc,b.con_alt_uterina as altura_uterina,\n"
                + "b.con_bati_feto as batimento_feto,\n" 
                + "b.con_peso as peso,b.con_pressao as pressao FROM appdatabase.paciente a \n" 
                + "Inner join appdatabase.consulta b\n" 
                + "On a.pac_id = b.FK_pac_id \n" 
                + "inner join appdatabase.medico c \n" 
                + "On b.FK_med_id = c.med_id where pac_id =" + pacientId);

        while (resultado.next()) {

            d = new Doctor();
            a = new Appointment();
            if(!resultado.getString("medico").isEmpty()){
            d.setDocName(resultado.getString("medico"));
            a.setAppDoctor(d);
            }
            
            
            a.setAppDate(AppUtil.DateFormat(resultado.getDate("con_data")));
            
            a.setAppDescr(resultado.getString("descricao"));
            a.setAppPatImc(String.valueOf(resultado.getString("imc")));
            a.setAppPatBloodPres(resultado.getString("pressao"));
            a.setAppPatWeight(resultado.getInt("peso"));
            a.setAppPatUterusHeight(resultado.getString("altura_uterina"));
            a.setAppBabyHeartBeat(resultado.getString("batimento_feto"));

            ap.add(a);
        }
        return ap;
    }
     
}
