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
import org.me.pi4.model.Appointment;
import org.me.pi4.modeldao.AppointmentDAO;


/**
 * @author valter.franco
 */

@Path("patient/appointment/{patientId}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AppointmentResource {
    
    @GET
    public List<Appointment> GetAllAppointment(@PathParam("patientId") int patientId) throws SQLException {
        
    ArrayList<Appointment> list = AppointmentDAO.GetAllAppointments(patientId);
    return list;
    }
    
    @GET
    @Path("/{appointmentId}")
    public Appointment GetAppointment(@PathParam("patientId") int patientId,
                                      @PathParam("appointmentId") int appointmentId) throws SQLException {
        
    Appointment a = AppointmentDAO.GetAppointment(patientId,appointmentId);  
    return a;
    }
    
}
