/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.pi4.modeldao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.me.pi4.model.Doctor;
import org.me.pi4.model.Patient;

/**
 *
 * @author 2016203311
 */
public class DoctorDAO extends DAO{

    public DoctorDAO() {
    super();
    }
    
    public void addDoctor(Connection conector, Doctor d) throws SQLException {
     }
     
     public int updateDoctor(Connection conector, Doctor d, int resultado) {
     return 0;
     }
     
     public int DeleteDoctor(int pId) {
     return 0;
     }
     
     public static void getDoctors(Connection conector) {
     }
    
}
