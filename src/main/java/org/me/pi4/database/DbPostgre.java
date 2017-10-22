
package org.me.pi4.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author valter.franco
 */
public class DbPostgre {
    
    private static DbPostgre instancia = new DbPostgre();
    private Connection connection;
    //private static final String URL = "jdbc:org.postgresql://ec2-184-73-236-170.compute-1.amazonaws.com/dbi1sr0o9egb6s";
    private static final String URL = "jdbc:postgresql://ec2-184-73-236-170.compute-1.amazonaws.com:5432/dbi1sr0o9egb6s?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
   // private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "npnkitkavxddgo";
    private static final String PASSWORD = "51aa47bf5e9f52536f4898905b3e8ee809c31504955ea74b2256404b163d1144";
   
    private DbPostgre() {

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            
        }
        System.out.println("Connected");
    }

    /**
     * Sigleton para conexão com a base de dados
     * @return 
     */
    public static DbPostgre instancia() {
        if (instancia == null) {
            instancia = new DbPostgre();
        }
        return instancia;
    }

    /**
     * Obter a conexão com a base de dados
     * @return 
     */
    public Connection getConnection() {
        return connection;
    }

}

