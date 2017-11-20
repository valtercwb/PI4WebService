
package org.me.ws;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.me.pi4.model.Attendance;
import org.me.pi4.modeldao.AppointmentDAO;

@Path("appointment")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ScheduleResource {

    @PUT
    @Path("/put")
    public int UpdateAppointment(Attendance a){
    AppointmentDAO appDAO = new AppointmentDAO();
            
    return appDAO.UpdateAppointment(a);
    }
    
    @GET
    @Path("/available")
    public List<Attendance> GetAvailableAppointment() throws SQLException {
        
    List<Attendance> a = AppointmentDAO.GetAllAvailableAppointments();
    return a;
    }
    
    @GET
    @Path("/scheduled")
    public List<Attendance> GetScheduledAppointment() throws SQLException {
        
    List<Attendance> a = AppointmentDAO.GetAllScheduledAppointments();
    return a;
    }

}
