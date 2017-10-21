package org.me.pi4.database;

import java.sql.Connection;

/**
 * @author valter.franco
 */
public class Teste {
    
    public static void main(String[] args) {
        //DbPostgre.instancia();
        Connection con = DbPostgre.instancia().getConnection();
    }
    
}
