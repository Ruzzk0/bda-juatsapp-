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
 *
 * @author PERSONAL
 */

public class UsuarioConversiones {
    
    public UsuarioConversiones() {
    }
    
    public UsuarioDTO entidadADto(Usuario usuario) throws NegocioException{
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
    
    public Usuario DtoAEntidad(UsuarioDTO usuario) throws NegocioException{
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
    
    public List<UsuarioDTO> listaUsuariosADto(List<Usuario> usuarios) throws NegocioException{
        List<UsuarioDTO> convertidos = new ArrayList<>();
        for (Usuario convertido : usuarios) {
            convertidos.add(entidadADto(convertido));
        }
        return convertidos;
    }
    
    public List<Usuario> listaDtoAEntidad(List<UsuarioDTO> usuarios) throws NegocioException{
        List<Usuario> convertidos = new ArrayList<>();
        for (UsuarioDTO convertido : usuarios) {
            convertidos.add(DtoAEntidad(convertido));
        }
        return convertidos;
    }
}
