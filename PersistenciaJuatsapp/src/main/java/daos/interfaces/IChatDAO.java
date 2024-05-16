/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos.interfaces;

import DOMINIO.Chat;
import DOMINIO.Mensaje;
import DOMINIO.Usuario;
import EXCEPCIONES.PersistenciaException;
import java.util.List;

/**
 *
 * @author PERSONAL
 */
public interface IChatDAO {
    
    public boolean guardar(Chat chat) throws PersistenciaException;

    public boolean eliminar(Chat chat) throws PersistenciaException;
    
    public boolean vaciar(Chat chat) throws PersistenciaException;

    public Chat obtener(Usuario usuarioRemitente, Usuario usuarioRemisor) throws PersistenciaException;

    public List<Chat> consultarTodos() throws PersistenciaException;
    
    public Mensaje guardarMensaje(Chat chat, Mensaje mensaje) throws PersistenciaException;
    
    public List<Mensaje> consultarMensajes (Chat chat) throws PersistenciaException;
    
}
