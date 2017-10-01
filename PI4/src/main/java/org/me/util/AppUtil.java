/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.util;

import java.sql.Date;

/**
 *
 * @author valter.franco
 */
public class AppUtil {

    public static String DateFormat(Date dt) {
        String datetime = dt.toLocalDate().toString();
        if (datetime != null) {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
            String dateTime = sdf.format(dt);
        }

        return datetime;
    }

}
