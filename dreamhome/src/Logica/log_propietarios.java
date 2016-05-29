package Logica;

import Datos.propiedades;
import Datos.propietarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class log_propietarios {
    
    private conexion oracle = new conexion();
    private Connection cn = oracle.conectar();
    private String sSQL = "";
    public Integer totalregistors;
    String SQL="SELECT MAX(idpropietario) AS idpropietario FROM propietario";
    
    public boolean insertar (propietarios dts){
        int cont=1;
        String num="";
        try {
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs.next())
            {              
                 num=rs.getString(1);
            }
            cont=Integer.parseInt(num);
            cont=cont+1;
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        sSQL = "INSERT INTO PROPIETARIO VALUES (?,?,?,?,?)";
                try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, cont);
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getApellido());
            pst.setString(4, dts.getDireccion());
            pst.setString(5, dts.getTelefono());
                       
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    
     public boolean editar (propietarios dts){
        sSQL = "UPDATE PROPIETARIO set nombre=?,apellido=?,direccion=?,telefono=? WHERE idpropietario=? ";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getDireccion());
            pst.setString(4, dts.getTelefono());
            pst.setInt(5, dts.getIdpropietario());
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
     
     
      public boolean eliminar (propietarios dts){
        sSQL = "DELETE FROM PROPIETARIO WHERE IDPROPIETARIO=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
           
            pst.setInt(1, dts.getIdpropietario());
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    
}
