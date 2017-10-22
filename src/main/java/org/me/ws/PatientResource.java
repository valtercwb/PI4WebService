package org.me.ws;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.me.pi4.model.Patient;
import org.me.pi4.modeldao.PatientDAO;

/**
 * @author valter.franco
 */

@Path("patient")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientResource{
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> GetAllPatients() throws SQLException {
        
    ArrayList<Patient> list = PatientDAO.GetAllPatients();
    return list;
    }
        
    @GET
    @Path("/{patientId}")
    public Patient GetPatient(@PathParam("patientId") int patientId) throws SQLException {
        
    Patient p = PatientDAO.GetPatient(patientId);  
    return p;
    }
    
     @GET
     @Path("/images/{image}")
     public Response getImage(@PathParam("image") String image) {
     File f = new File(image);
 
     if (!f.exists()) {
     throw new WebApplicationException(404);
     }
  
     String mt = new MimetypesFileTypeMap().getContentType(f);
     return Response.ok(f, mt).build();
     }
}
