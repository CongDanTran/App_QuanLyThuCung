/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CongDan
 */
public class DAO {
    public  String url;
    public DAO(String url) {
        this.url = url;
    }
   
      public  Connection getConnect() throws SQLException{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
            Connection conn = null;
            String username = "sa";
            String password = "123";
            String url = "jdbc:sqlserver://localhost:1433";
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTC;username=sa;password=123;");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
          public  boolean Lenh(String caulenh,Connection conn){
     
             try {
               
                String sql =caulenh;
                Statement statement = conn.createStatement();
                int x = statement.executeUpdate(sql);
                if (x > 0) {
                  return true;
                }
            } catch (Exception ex) {
                 System.out.println("" +ex.toString());
            }
             return false;
    }

}
