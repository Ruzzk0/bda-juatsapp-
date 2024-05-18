/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juatsapp.negocio;

import PERSISTENCIA.UsuarioDAO;
import daos.interfaces.IUsuarioDAO;
import excepciones.NegocioException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import juatsapp.Conversiones.UsuarioConversiones;
import juatsapp.dtos.UsuarioDTO;
import juatsapp.negocioInterfaces.IUsuarioBO;
import negocio.encriptador.EncriptadorAES;

/**
 *
 * @author Paco
 */
public class UsuarioBO implements IUsuarioBO {

    IUsuarioDAO usuarioDAO;
    EncriptadorAES encriptador;
    UsuarioConversiones conversorUsuario;

    /**
     * Constructor de la clase UsuarioBO.
     * Inicializa las instancias de UsuarioDAO, EncriptadorAES y UsuarioConversiones.
     */
    public UsuarioBO() {
        usuarioDAO = new UsuarioDAO();
        encriptador = new EncriptadorAES();
        conversorUsuario = new UsuarioConversiones();
    }

    /**
     * Inserta un nuevo usuario en la base de datos.
     * @param usuario El objeto de transferencia de datos del usuario que contiene los detalles del usuario.
     * @return true si la inserción es exitosa.
     * @throws NegocioException Si ocurre un error durante el proceso de inserción.
     */
    @Override
    public boolean insertar(UsuarioDTO usuario) throws NegocioException {
        try {
            String contrasenia = encriptador.encriptar(usuario.getContra());
            usuario.setContra(contrasenia);
            usuarioDAO.insertar(conversorUsuario.DtoAEntidad(usuario));
            return true;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al insertar el usuario: ", ex);
        }
    }

    /**
     * Modifica un usuario existente en la base de datos.
     * @param usuario El objeto de transferencia de datos del usuario que contiene los detalles actualizados del usuario.
     * @return true si la modificación es exitosa.
     * @throws NegocioException Si ocurre un error durante el proceso de modificación.
     */
    @Override
    public boolean modificar(UsuarioDTO usuario) throws NegocioException {
        try {
            String contrasenia = encriptador.encriptar(usuario.getContra());
            usuario.setContra(contrasenia);
            usuarioDAO.modificar(conversorUsuario.DtoAEntidad(usuario));
            return true;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al modificar el usuario: ", ex);
        }
    }

    /**
     * Elimina un usuario de la base de datos.
     * @param usuario El identificador del usuario a eliminar.
     * @return true si la eliminación es exitosa.
     * @throws NegocioException Si ocurre un error durante el proceso de eliminación.
     */
    @Override
    public boolean eliminar(String usuario) throws NegocioException {
        try {
            return usuarioDAO.eliminar(usuario);
        } catch (Exception e) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, e);
            throw new NegocioException("Error al eliminar el usuario: ", e);
        }
    }

    /**
     * Obtiene un usuario de la base de datos.
     * @param usuario El identificador del usuario a obtener.
     * @return El objeto de transferencia de datos del usuario que contiene los detalles del usuario.
     * @throws NegocioException Si ocurre un error durante el proceso de obtención.
     */
    @Override
    public UsuarioDTO obtener(String usuario) throws NegocioException {
        try {
            UsuarioDTO resultado = conversorUsuario.entidadADto(usuarioDAO.obtener(usuario));
            String contra = encriptador.desencriptar(resultado.getContra());
            resultado.setContra(contra);
            return resultado;
        } catch (Exception e) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, e);
            throw new NegocioException("Error al obtener el usuario: ", e);
        }
    }

    /**
     * Obtiene todos los usuarios de la base de datos.
     * @return Una lista de objetos de transferencia de datos del usuario que contiene los detalles de todos los usuarios.
     * @throws NegocioException Si ocurre un error durante el proceso de consulta.
     */
    @Override
    public List<UsuarioDTO> consultarTodos() throws NegocioException {
        try {
            return conversorUsuario.listaUsuariosADto(usuarioDAO.consultarTodos());
        } catch (Exception e) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, e);
            throw new NegocioException("Error al consultar los usuarios: ", e);
        }
    }
}