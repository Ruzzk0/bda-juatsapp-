
package DOMINIO;

import javax.swing.Action;

/**
 *
 * @author Usuario
 */
public class Usuario {
    
    private String nombre;
    private String Domicilio;
    private String telefono;
    private String usuario;
    private String Contra;
 

    public Usuario(String nombre, String Domicilio, String telefono, String usuario, String Contra) {
        this.nombre = nombre;
        this.Domicilio = Domicilio;
        this.telefono = telefono;
        this.usuario = usuario;
        this.Contra = Contra;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return Contra;
    }

    public void setContra(String Contra) {
        this.Contra = Contra;
    }

    
    
    
}