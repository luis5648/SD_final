
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;

public class validarUsuario {
    ConectMSQ c = new ConectMSQ();
    boolean val = false;
    
    public boolean validar(String user,String pass){
        try {
            String sql = "SELECT * FROM clientes WHERE nombre = '"+user+
                    "' and pass = '"+pass+"'";
            
            Statement st = c.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                val = true;
            }else{
                val = false;
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(validarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            c.Desconectar();
        }
        
        return val;
    }
    

}
