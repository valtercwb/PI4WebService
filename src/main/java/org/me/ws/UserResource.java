package org.me.ws;

import java.util.Base64;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import org.me.pi4.model.User;
import org.me.pi4.modeldao.UserDAO;

/**
 * REST Web Service
 *
 * @author valter.franco
 */
@Path("login")
public class UserResource {

    /**
     *
     * @param userLogin
     * @param userPass
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User Login (@HeaderParam("userLogin") String userLogin, @HeaderParam("userPass") String userPass) {
        
    User u = new UserDAO().AuthUserPostgre(userLogin, userPass);
    return u;
    }
    
//    @Context HttpHeaders headers;
//    // ...
//    protected boolean authenticate() {
//        String header = headers.getRequestHeader("authorization").get(0);
//        header = header.substring("Basic ".length());
//        String[] creds = new String(header).split(":");
//        String username = creds[0];
//        String password = creds[1];
//        
//        UserDAO ud = new UserDAO();
//      //  ud.autenticarSenha(username, password);
//        
//        return true;
//    }
}
