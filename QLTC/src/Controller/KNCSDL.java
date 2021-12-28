/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CongDan
 */
public class KNCSDL {
      public  Connection getConnect(){
    try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
            Connection conn = null;
            String username = "sa";
            String password = "123";
            String url = "jdbc:sqlserver://localhost:1433";
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTC;username=sa;password=123;");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KNCSDL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KNCSDL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
