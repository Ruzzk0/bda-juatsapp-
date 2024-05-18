/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package juatsapp.negocioInterfaces;

import DOMINIO.Usuario;
import excepciones.NegocioException;
import java.util.List;
import juatsapp.dtos.UsuarioDTO;

/**
 * La interfaz IUsuarioBO define los métodos para la lógica de negocio
 * relacionada con los usuarios. Esta interfaz debe ser implementada por
 * cualquier clase que desee manejar las operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar) y otras operaciones relacionadas con usuarios en el
 * sistema.
 *
 * Los métodos de esta interfaz pueden lanzar una `NegocioException` en caso de
 * que ocurra algún problema relacionado con la lógica de negocio durante su
 * ejecución.
 *
 * @see UsuarioDTO
 * @see NegocioException
 * @see UsuarioBO
 * @see IUsuarioDAO
 * @see UsuarioConversiones
 */
public interface IUsuarioBO {

    /**
     * Inserta un nuevo usuario en el sistema.
     *
     * @param usuario El objeto UsuarioDTO que contiene los datos del usuario a
     * insertar.
     * @return true si el usuario fue insertado exitosamente.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * inserción.
     */
    public boolean insertar(UsuarioDTO usuario) throws NegocioException;

    /**
     * Modifica los datos de un usuario existente en el sistema.
     *
     * @param usuario El objeto UsuarioDTO que contiene los datos del usuario a
     * modificar.
     * @return true si el usuario fue modificado exitosamente.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * modificación.
     */
    public boolean modificar(UsuarioDTO usuario) throws NegocioException;

    /**
     * Elimina un usuario del sistema.
     *
     * @param usuario El identificador del usuario a eliminar.
     * @return true si el usuario fue eliminado exitosamente.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * eliminación.
     */
    public boolean eliminar(String usuario) throws NegocioException;

    /**
     * Obtiene los datos de un usuario específico.
     *
     * @param usuario El identificador del usuario a obtener.
     * @return El objeto UsuarioDTO que contiene los datos del usuario obtenido.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * obtención.
     */
    public UsuarioDTO obtener(String usuario) throws NegocioException;

    /**
     * Consulta todos los usuarios en el sistema.
     *
     * @return Una lista de objetos UsuarioDTO que contiene los datos de todos
     * los usuarios.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * consulta.
     */
    public List<UsuarioDTO> consultarTodos() throws NegocioException;

}
