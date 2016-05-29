
package Logica;
import Datos.propiedades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class log_propiedades {
    
    private conexion oracle = new conexion();
    private Connection cn = oracle.conectar();
    private String sSQL = "";
    public Integer totalregistors;
    String SQL="SELECT MAX(idpropiedad) AS idpropiedad FROM propiedad";
    
    public boolean insertar (propiedades dts){
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
        
        sSQL = "INSERT INTO propiedad VALUES (?,?,?,?,?,?,?,?)";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1,cont);
            pst.setString(2, dts.getCalle());
            pst.setString(3, dts.getCiudad());
            pst.setString(4, dts.getCodigopostal());
            pst.setString(5, dts.getTipo());
            pst.setInt(6, dts.getHab());
            pst.setInt(7, dts.getRenta());
            pst.setInt(8, dts.getIdpropietario());
            
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
    
    public boolean editar (propiedades dts){
        sSQL = "UPDATE PROPIEDAD set calle=?,ciudad=?,codigopostal=?,tipo=?,hab=?,renta=?,idpropietario=? WHERE idpropiedad=? ";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getCalle());
            pst.setString(2, dts.getCiudad());
            pst.setString(3, dts.getCodigopostal());
            pst.setString(4, dts.getTipo());
            pst.setInt(5, dts.getHab());
            pst.setInt(6, dts.getRenta());
            pst.setInt(7, dts.getIdpropietario());
            pst.setInt(8, dts.getIdpropiedad());
            
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
    
    
    public boolean eliminar (propiedades dts){
        sSQL = "DELETE FROM PROPIEDAD WHERE IDPROPIEDAD=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
           
            pst.setInt(1, dts.getIdpropiedad());
            
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
