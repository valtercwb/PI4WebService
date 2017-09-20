package org.me.ws;

import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.me.pi4.model.Patient;
import org.me.pi4.modeldao.PatientDAO;

/**
 * @author valter.franco
 */

@Path("patient")
public class PatientWs {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public org.me.pi4.model.Patient getIt() throws SQLException {
        
    Patient p = PatientDAO.GetPatient(1);  
       
    return p;
    }
}
