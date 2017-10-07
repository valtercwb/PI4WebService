/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.pi4.modeldao;

import java.sql.Connection;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import org.me.pi4.model.Historic;
import org.me.pi4.model.Patient;

/**
 *
 * @author 2016203311
 */
public class HistoricDAO extends DAO{

    public HistoricDAO() {
    super();
    }
    
    public void addHistoric(Connection conector, Historic h) throws SQLException {
     }
     
     public int updateUser(Connection conector, Historic h, int resultado) {
     return 0;
     }
     
     public int DeleteHistoric(int pId) {
     return 0;
     }
     
     public static void getUser(Connection conector, ObservableList<Historic> list) {
     }
    
}
