/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juatsapp.Conversiones;

import DOMINIO.Usuario;
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
    
    public UsuarioDTO entidadADto(Usuario usuario){
        UsuarioDTO convertido = new UsuarioDTO();
        convertido.setId(usuario.getId().toHexString());
        convertido.setContra(usuario.getContra());
        convertido.setUsuario(usuario.getUsuario());
        convertido.setNombre(usuario.getNombre());
        convertido.setFechaNacimiento(usuario.getFechaNacimiento());
        convertido.setTelefono(usuario.getTelefono());
        convertido.setSexo(usuario.getSexo());
        return convertido;
    }
    
    public Usuario DtoAEntidad(UsuarioDTO usuario){
        Usuario convertido = new Usuario();
        convertido.setId(new ObjectId(usuario.getId()));
        convertido.setContra(usuario.getContra());
        convertido.setUsuario(usuario.getUsuario());
        convertido.setNombre(usuario.getNombre());
        convertido.setFechaNacimiento(usuario.getFechaNacimiento());
        convertido.setTelefono(usuario.getTelefono());
        convertido.setSexo(usuario.getSexo());
        return convertido;
    }
    
    public List<UsuarioDTO> listaUsuariosADto(List<Usuario> usuarios){
        List<UsuarioDTO> convertidos = new ArrayList<>();
        for (Usuario convertido : usuarios) {
            convertidos.add(entidadADto(convertido));
        }
        return convertidos;
    }
    
    public List<Usuario> listaDtoAEntidad(List<UsuarioDTO> usuarios){
        List<Usuario> convertidos = new ArrayList<>();
        for (UsuarioDTO convertido : usuarios) {
            convertidos.add(DtoAEntidad(convertido));
        }
        return convertidos;
    }
}
