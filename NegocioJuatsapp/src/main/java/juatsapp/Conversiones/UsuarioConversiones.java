/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juatsapp.Conversiones;

import DOMINIO.Usuario;
import excepciones.NegocioException;
import java.util.ArrayList;
import java.util.List;
import juatsapp.dtos.UsuarioDTO;
import org.bson.types.ObjectId;

/**
 * La clase UsuarioConversiones proporciona métodos para convertir entre
 * entidades de Usuario y DTOs de Usuario.
 *
 * Estos métodos permiten la conversión de objetos Usuario a UsuarioDTO y
 * viceversa, así como también la conversión de listas de objetos Usuario a
 * listas de objetos UsuarioDTO y viceversa.
 *
 * @see Usuario
 * @see UsuarioDTO
 */
public class UsuarioConversiones {

    /**
     * Constructor de la clase UsuarioConversiones. No realiza ninguna operación
     * en particular.
     */
    public UsuarioConversiones() {
    }

    /**
     * Convierte un objeto Usuario a un objeto UsuarioDTO.
     *
     * @param usuario El objeto Usuario que se va a convertir.
     * @return El objeto UsuarioDTO convertido.
     * @throws NegocioException Si ocurre un error durante la conversión.
     */
    public UsuarioDTO entidadADto(Usuario usuario) throws NegocioException {
        UsuarioDTO convertido = new UsuarioDTO();
        try {
            convertido.setId(usuario.getId().toHexString());
            convertido.setContra(usuario.getContra());
            convertido.setUsuario(usuario.getUsuario());
            convertido.setNombre(usuario.getNombre());
            convertido.setFechaNacimiento(usuario.getFechaNacimiento());
            convertido.setTelefono(usuario.getTelefono());
            convertido.setSexo(usuario.getSexo());
        } catch (Exception ex) {
            throw new NegocioException("Error al convertir entidad a DTO: " + ex.getMessage());
        }
        return convertido;
    }

    /**
     * Convierte un objeto UsuarioDTO a un objeto Usuario.
     *
     * @param usuario El objeto UsuarioDTO que se va a convertir.
     * @return El objeto Usuario convertido.
     * @throws NegocioException Si ocurre un error durante la conversión.
     */
    public Usuario DtoAEntidad(UsuarioDTO usuario) throws NegocioException {
        Usuario convertido = new Usuario();
        try {
            convertido.setId(new ObjectId(usuario.getId()));
            convertido.setContra(usuario.getContra());
            convertido.setUsuario(usuario.getUsuario());
            convertido.setNombre(usuario.getNombre());
            convertido.setFechaNacimiento(usuario.getFechaNacimiento());
            convertido.setTelefono(usuario.getTelefono());
            convertido.setSexo(usuario.getSexo());
        } catch (Exception ex) {
            throw new NegocioException("Error al convertir DTO a entidad: " + ex.getMessage());
        }
        return convertido;
    }

    /**
     * Convierte una lista de objetos Usuario a una lista de objetos UsuarioDTO.
     *
     * @param usuarios La lista de objetos Usuario que se va a convertir.
     * @return La lista de objetos UsuarioDTO convertida.
     * @throws NegocioException Si ocurre un error durante la conversión.
     */
    public List<UsuarioDTO> listaUsuariosADto(List<Usuario> usuarios) throws NegocioException {
        List<UsuarioDTO> convertidos = new ArrayList<>();
        for (Usuario convertido : usuarios) {
            convertidos.add(entidadADto(convertido));
        }
        return convertidos;
    }

    /**
     * Convierte una lista de objetos UsuarioDTO a una lista de objetos Usuario.
     *
     * @param usuarios La lista de objetos UsuarioDTO que se va a convertir.
     * @return La lista de objetos Usuario convertida.
     * @throws NegocioException Si ocurre un error durante la conversión.
     */
    public List<Usuario> listaDtoAEntidad(List<UsuarioDTO> usuarios) throws NegocioException {
        List<Usuario> convertidos = new ArrayList<>();
        for (UsuarioDTO convertido : usuarios) {
            convertidos.add(DtoAEntidad(convertido));
        }
        return convertidos;
    }
}
