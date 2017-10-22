/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.ws;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.me.pi4.model.Exam;
import org.me.pi4.modeldao.ExamDAO;

/**
 *
 * @author valter.franco
 */
@Path("patient/{patientId}/exam")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExamResource {

    @GET
    public List<Exam> GetAllExams(@PathParam("patientId") int patientId) throws SQLException {
        
    ArrayList<Exam> list = ExamDAO.GetAllExams(patientId);
    return list;
    }
    
    @GET
    @Path("/{examId}")
    public Exam GetExam(@PathParam("patientId") int patientId,
                               @PathParam("examId") int examId) throws SQLException {
        
    Exam e = ExamDAO.GetExam(patientId,examId);  
    return e;
    }
    
}