/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos.interfaces;

import DOMINIO.Usuario;
import EXCEPCIONES.PersistenciaException;
import java.util.List;

/**
 *
 * @author PERSONAL
 */
public interface IUsuarioDAO {

    public boolean insertar(Usuario usuario) throws PersistenciaException;

    public boolean modificar(Usuario usuario) throws PersistenciaException;

    public boolean eliminar(String usuario) throws PersistenciaException;

    public Usuario obtener(String usuario) throws PersistenciaException;

    public List<Usuario> consultarTodos() throws PersistenciaException;

    public List<Usuario> obtenerContactos(Usuario usuario) throws PersistenciaException;
}
