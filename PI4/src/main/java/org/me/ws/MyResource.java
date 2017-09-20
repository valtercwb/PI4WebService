package org.me.ws;

import java.sql.SQLException;
import javafx.collections.ObservableList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.me.pi4.database.DbConnection;
import org.me.pi4.model.Patient;
import org.me.pi4.modeldao.PatientDAO;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getIt() throws SQLException {
        
        Patient p = PatientDAO.GetPatient(1);  
       
    return p;
    }
}
