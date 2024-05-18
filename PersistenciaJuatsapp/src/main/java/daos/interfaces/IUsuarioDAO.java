/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos.interfaces;

import DOMINIO.Usuario;
import EXCEPCIONES.PersistenciaException;
import java.util.List;

/**
 * La interfaz IUsuarioDAO define los métodos que deben ser implementados por
 * cualquier clase que proporcione acceso a datos para la gestión de usuarios en
 * el sistema.
 *
 * Estos métodos permiten realizar operaciones CRUD (Crear, Leer, Actualizar,
 * Eliminar) en la base de datos para objetos de tipo Usuario.
 *
 * @see Usuario
 */
public interface IUsuarioDAO {

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param usuario El objeto Usuario que se va a insertar.
     * @return true si el usuario fue insertado exitosamente.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    public boolean insertar(Usuario usuario) throws PersistenciaException;

    /**
     * Modifica un usuario existente en la base de datos.
     *
     * @param usuario El objeto Usuario que se va a modificar.
     * @return true si el usuario fue modificado exitosamente.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    public boolean modificar(Usuario usuario) throws PersistenciaException;

    /**
     * Elimina un usuario de la base de datos dado su nombre de usuario.
     *
     * @param usuario El nombre de usuario del usuario que se va a eliminar.
     * @return true si el usuario fue eliminado exitosamente.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    public boolean eliminar(String usuario) throws PersistenciaException;

    /**
     * Obtiene un usuario de la base de datos dado su nombre de usuario.
     *
     * @param usuario El nombre de usuario del usuario que se va a obtener.
     * @return El objeto Usuario correspondiente al nombre de usuario
     * especificado.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    public Usuario obtener(String usuario) throws PersistenciaException;

    /**
     * Consulta todos los usuarios almacenados en la base de datos.
     *
     * @return Una lista de objetos Usuario que representan todos los usuarios
     * almacenados.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    public List<Usuario> consultarTodos() throws PersistenciaException;

}
