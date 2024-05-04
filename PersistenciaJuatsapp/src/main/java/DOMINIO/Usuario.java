
package DOMINIO;

/**
 *
 * @author Usuario
 */
public class Usuario {
    
    private String nombre;
    private String Domicilio;
    private String sexo;
    private String usuario;
    private String Contra;

    public Usuario(String nombre, String Domicilio, String sexo, String usuario, String Contra) {
        this.nombre = nombre;
        this.Domicilio = Domicilio;
        this.sexo = sexo;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
