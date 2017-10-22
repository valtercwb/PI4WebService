
package org.me.pi4.modeldao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.me.pi4.database.DbPostgre;
import org.me.pi4.model.Appointment;
import org.me.pi4.model.Doctor;
import org.me.pi4.model.Exam;
import org.me.pi4.model.Patient;
import org.me.util.AppUtil;

/**
 *
 * @author valter.franco
 */
public class ExamDAO extends DAO {

    public ExamDAO() {
        super();
    }

    public static Exam GetExam(int patientId, int examId) throws SQLException {

        DbPostgre.instancia();
        Connection con = DbPostgre.instancia().getConnection();

        Exam e = null;
        Statement stm = null;

        stm = con.createStatement();
        ResultSet resultado = stm.executeQuery("SELECT exa_id, exa_paciente, exa_motivo, exa_observacoes,\n"
                + " exa_media, exa_data, exa_local, exa_medico, exa_tipo\n" +
                "FROM public.exame where exa_paciente='" + patientId + "' and exa_id=" + examId);

        if (resultado.next()) {
            e = new Exam();
            e.setExamPatient(resultado.getInt("exam_paciente"));
            e.setExamReason(resultado.getString("exa_motivo"));
            e.setExamMedia(resultado.getString("exa_media"));
            e.setExamPlace(resultado.getString("exa_local"));
            e.setExamMedico(resultado.getString("exa_medico"));
            e.setExamObs(resultado.getString("exa_tipo"));
            e.setExamDate(resultado.getDate("exa_data"));
            e.setExamObs(resultado.getString("exa_observacoes"));
        }
        return e;
    }

    public void addAppointment(Connection conector, Appointment a) throws SQLException {
    }

    public int updateAppointment(Connection conector, Appointment a, int resultado) {
        return 0;
    }

    public int DeleteAppointment(int pId) {
        return 0;
    }

    public static ArrayList<Exam> GetAllExams(int pacientId) throws SQLException {
        ArrayList<Exam> examList = new ArrayList<>();
        DbPostgre.instancia();
        Connection con = DbPostgre.instancia().getConnection();
        Exam e = null;
        
        Statement stm = null;

        stm = con.createStatement();
        ResultSet resultado = stm.executeQuery("SELECT exa_id, exa_paciente, exa_motivo, exa_observacoes,\n"
                + " exa_media, exa_data, exa_local, exa_medico, exa_tipo\n" +
                "FROM public.exame where exa_paciente=" + pacientId);

        while (resultado.next()) {
            e = new Exam();
            e.setExamPatient(resultado.getInt("exam_paciente"));
            e.setExamReason(resultado.getString("exa_motivo"));
            e.setExamMedia(resultado.getString("exa_media"));
            e.setExamPlace(resultado.getString("exa_local"));
            e.setExamMedico(resultado.getString("exa_medico"));
            e.setExamObs(resultado.getString("exa_tipo"));
            e.setExamDate(resultado.getDate("exa_data"));
            e.setExamObs(resultado.getString("exa_observacoes"));
            examList.add(e);
        }
        return examList;
    }
}

