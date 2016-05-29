package Datos;

public class propiedades {
    
    private int idpropiedad;
    private String calle;
    private String ciudad;
    private String codigopostal;
    private String tipo;
    private int hab;
    private int renta;
    private int idpropietario;

    public propiedades(int idpropiedad, String calle, String ciudad, String codigopostal, String tipo, int hab, int renta, int idpropietario) {
        this.idpropiedad = idpropiedad;
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigopostal = codigopostal;
        this.tipo = tipo;
        this.hab = hab;
        this.renta = renta;
        this.idpropietario = idpropietario;
    }

    public propiedades() {
    }

    public int getIdpropiedad() {
        return idpropiedad;
    }

    public void setIdpropiedad(int idpropiedad) {
        this.idpropiedad = idpropiedad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getHab() {
        return hab;
    }

    public void setHab(int hab) {
        this.hab = hab;
    }

    public int getRenta() {
        return renta;
    }

    public void setRenta(int renta) {
        this.renta = renta;
    }

    public int getIdpropietario() {
        return idpropietario;
    }

    public void setIdpropietario(int idpropietario) {
        this.idpropietario = idpropietario;
    }
    
}
