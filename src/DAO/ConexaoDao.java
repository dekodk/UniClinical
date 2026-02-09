package DAO;

import javax.swing.JOptionPane;
import java.sql.*;


public class ConexaoDao {
    
    public Connection ConectaBD(){
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/crud?user=root&password=025507";
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ConexaoDao"+ erro.getMessage());
        }
        return conn;
    }
    
}