/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juatsapp.negocio;

import PERSISTENCIA.ChatDAO;
import PERSISTENCIA.UsuarioDAO;
import daos.interfaces.IChatDAO;
import daos.interfaces.IUsuarioDAO;
import excepciones.NegocioException;
import java.util.List;
import juatsapp.Conversiones.ChatConversiones;
import juatsapp.Conversiones.MensajeConversiones;
import juatsapp.Conversiones.UsuarioConversiones;
import juatsapp.dtos.ChatDTO;
import juatsapp.dtos.MensajeDTO;
import juatsapp.dtos.UsuarioDTO;
import juatsapp.negocioInterfaces.IChatBO;

/**
 *
 * @author PERSONAL
 */
public class ChatBO implements IChatBO{
    
    IChatDAO chatDAO;
    IUsuarioDAO usuarioDAO;
    UsuarioConversiones conversorUsuario;
    ChatConversiones conversorChat;
    MensajeConversiones conversorMensajes;

    public ChatBO() {
        chatDAO = new ChatDAO();
        usuarioDAO = new UsuarioDAO();
        conversorUsuario = new UsuarioConversiones();
        conversorChat = new ChatConversiones();
        conversorMensajes = new MensajeConversiones();
    }

    @Override
    public boolean guardar(ChatDTO chat) throws NegocioException {
        try {
            return chatDAO.guardar(conversorChat.DtoAEntidad(chat));
        } catch (Exception e) {
            throw new NegocioException("No se pudo guardarse el chat: ", e);
        }
    }

    @Override
    public boolean eliminar(ChatDTO chat) throws NegocioException {
        try {
            return chatDAO.eliminar(conversorChat.DtoAEntidad(chat));
        } catch (Exception e) {
            throw new NegocioException("No se pudo eliminar el chat: ", e);
        }
    }

    @Override
    public boolean vaciar(ChatDTO chat) throws NegocioException {
        try {
            return chatDAO.vaciar(conversorChat.DtoAEntidad(chat));
        } catch (Exception e) {
            throw new NegocioException("No se pudo vaciar el chat: ", e);
        }
    }

    @Override
    public ChatDTO obtener(UsuarioDTO usuarioRemitente, UsuarioDTO usuarioRemisor) throws NegocioException {
        try {
            return conversorChat.entidadADto(chatDAO.obtener(conversorUsuario.DtoAEntidad(usuarioRemisor), conversorUsuario.DtoAEntidad(usuarioRemisor)));
        } catch (Exception e) {
            throw new NegocioException("No pudo guardarse el chat: ", e);
        }
    }

    @Override
    public List<ChatDTO> consultarTodos() throws NegocioException {
        try {
            return conversorChat.listaChatsADto(chatDAO.consultarTodos());
        } catch (Exception e) {
            throw new NegocioException("No pudo guardarse el chat: ", e);
        }
    }

    @Override
    public MensajeDTO guardarMensaje(ChatDTO chat, MensajeDTO mensaje) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MensajeDTO> consultarMensajes(ChatDTO chat) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
