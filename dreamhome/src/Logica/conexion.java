/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author TARS
 */
public class conexion {
        
    public String bd="solemnebd";
    public String login="solemnebd";
    public String password="123";
    public String url="jdbc:oracle:thin:@localhost:1521:XE";

    public conexion() {
    }
    
    
    public Connection conectar()   {
        Connection link = null;
        
        try {
         Class.forName("oracle.jdbc.OracleDriver");
         link = DriverManager.getConnection(this.url, this.login,this.password);
        }
        catch(ClassNotFoundException | SQLException e )
        {
            JOptionPane.showConfirmDialog(null, e);
        }
        return link;
    }
    
}


