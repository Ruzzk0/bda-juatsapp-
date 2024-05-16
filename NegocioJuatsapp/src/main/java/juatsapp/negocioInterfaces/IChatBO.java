/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package juatsapp.negocioInterfaces;

import DOMINIO.Chat;
import DOMINIO.Mensaje;
import DOMINIO.Usuario;
import excepciones.NegocioException;
import java.util.List;
import juatsapp.dtos.ChatDTO;
import juatsapp.dtos.MensajeDTO;
import juatsapp.dtos.UsuarioDTO;

/**
 *
 * @author Paco
 */
public interface IChatBO {
    
    public boolean guardar(ChatDTO chat) throws NegocioException;

    public boolean eliminar(ChatDTO chat) throws NegocioException;
    
    public boolean vaciar(ChatDTO chat) throws NegocioException;

    public ChatDTO obtener(UsuarioDTO usuarioRemitente, UsuarioDTO usuarioRemisor) throws NegocioException;

    public List<ChatDTO> consultarTodos() throws NegocioException;
    
    public MensajeDTO guardarMensaje(ChatDTO chat, MensajeDTO mensaje) throws NegocioException;
    
    public List<MensajeDTO> consultarMensajes (ChatDTO chat) throws NegocioException;
    
}
