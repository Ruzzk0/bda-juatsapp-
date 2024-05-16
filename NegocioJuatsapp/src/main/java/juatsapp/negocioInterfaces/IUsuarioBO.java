/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package juatsapp.negocioInterfaces;

import DOMINIO.Usuario;
import EXCEPCIONES.PersistenciaException;
import java.util.List;
import juatsapp.dtos.UsuarioDTO;

/**
 *
 * @author Paco
 */
public interface IUsuarioBO {
    
    public boolean insertar(UsuarioDTO usuario) throws PersistenciaException;

    public boolean modificar(Usuario usuario) throws PersistenciaException;

    public boolean eliminarDTO(String usuario) throws PersistenciaException;

    public UsuarioDTO obtener(String usuario) throws PersistenciaException;

    public List<UsuarioDTO> consultarTodos() throws PersistenciaException;
    
}
