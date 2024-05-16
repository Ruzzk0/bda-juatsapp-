package DOMINIO;

import java.io.Serializable;
import org.bson.types.ObjectId;

/**
 * La clase Usuario representa a un usuario con varios atributos como nombre,
 * región, teléfono, nombre de usuario y contraseña. Esta clase implementa la
 * interfaz Serializable para permitir la serialización de objetos de usuario.
 */
public class Usuario implements Serializable {

    private ObjectId id;
    
    /**
     * Nombre del usuario.
     */
    private String nombre;

    /**
     * Región del usuario.
     */
    private String region;

    /**
     * Número de teléfono del usuario.
     */
    private String telefono;

    /**
     * Nombre de usuario.
     */
    private String usuario;

    /**
     * Contraseña del usuario.
     */
    private String Contra;

    /**
     * Constructor predeterminado de la clase Usuario.
     */
    public Usuario() {
    }

    /**
     * Constructor parametrizado de la clase Usuario.
     *
     * @param nombre Nombre del usuario.
     * @param region Región del usuario.
     * @param telefono Número de teléfono del usuario.
     * @param usuario Nombre de usuario del usuario.
     * @param Contra Contraseña del usuario.
     */
    public Usuario(String nombre, String region, String telefono, String usuario, String Contra) {
        this.nombre = nombre;
        this.region = region;
        this.telefono = telefono;
        this.usuario = usuario;
        this.Contra = Contra;
    }

    /**
     * Método para obtener el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del usuario.
     *
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la región del usuario.
     *
     * @return La región del usuario.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Método para establecer la región del usuario.
     *
     * @param region La región del usuario.
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Método para obtener el número de teléfono del usuario.
     *
     * @return El número de teléfono del usuario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método para establecer el número de teléfono del usuario.
     *
     * @param telefono El número de teléfono del usuario.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método para obtener el nombre de usuario del usuario.
     *
     * @return El nombre de usuario del usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método para establecer el nombre de usuario del usuario.
     *
     * @param usuario El nombre de usuario del usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Método para obtener la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContra() {
        return Contra;
    }

    /**
     * Método para establecer la contraseña del usuario.
     *
     * @param Contra La contraseña del usuario.
     */
    public void setContra(String Contra) {
        this.Contra = Contra;
    }

    /**
     * Obtiene el id del usuario.
     * @return Id del usuario.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Asigna el id para el usuario.
     * @param id Id del usuario.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }
    
}
