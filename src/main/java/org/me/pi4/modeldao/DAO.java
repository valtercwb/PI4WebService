package org.me.pi4.modeldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.me.pi4.database.DbConnection;

//  @author valter.franco 

    public class DAO {

    protected Connection con = DbConnection.instancia().getConnection();
    protected ResultSet rs;
    protected PreparedStatement pst;
    protected Statement stm;

    public DAO() {

    }
}