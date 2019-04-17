package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConectMSQ {

    private static Connection conn;
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String Usuario = "root";
    private static final String Contrasenia = "";
    private static final String Url = "jdbc:mysql://localhost:3306/facturas_electronicas?autoReconnect=true&useSSL=false";

    public ConectMSQ() {
        conn = null;
    }

    public static Connection getConnection() {
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(Url, Usuario, Contrasenia);
            if (conn != null) {

            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar " + e);
        }

        return conn;
    }

    public void Desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error al cerrar la conexion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //test connection
    
//    public static void main(String[] args) {
//        System.out.println(getConnection());
//    }
   
}
