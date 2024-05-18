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
 * La clase ChatBO es un objeto de negocio que maneja operaciones relacionadas
 * con los chats, tales como guardar, eliminar y recuperar datos de chat y
 * mensajes. Implementa la interfaz IChatBO.
 *
 * Esta clase utiliza varios DAOs (Objetos de Acceso a Datos) y utilidades de
 * conversión para interactuar con la capa de datos y convertir entre objetos de
 * transferencia de datos (DTOs) y entidades.
 *
 * @autor PERSONAL
 */
public class ChatBO implements IChatBO {

    private IChatDAO chatDAO;
    private IUsuarioDAO usuarioDAO;
    private UsuarioConversiones conversorUsuario;
    private ChatConversiones conversorChat;
    private MensajeConversiones conversorMensajes;

    /**
     * Construye una nueva instancia de ChatBO e inicializa los DAOs y las
     * utilidades de conversión.
     */
    public ChatBO() {
        chatDAO = new ChatDAO();
        usuarioDAO = new UsuarioDAO();
        conversorUsuario = new UsuarioConversiones();
        conversorChat = new ChatConversiones();
        conversorMensajes = new MensajeConversiones();
    }

    /**
     * Guarda un chat.
     *
     * @param chat el DTO del chat que se va a guardar
     * @return true si el chat se guardó correctamente, false en caso contrario
     * @throws NegocioException si ocurre un error al guardar el chat
     */
    @Override
    public boolean guardar(ChatDTO chat) throws NegocioException {
        try {
            return chatDAO.guardar(conversorChat.DtoAEntidad(chat));
        } catch (Exception e) {
            throw new NegocioException("No se pudo guardar el chat: ", e);
        }
    }

    /**
     * Elimina un chat.
     *
     * @param chat el DTO del chat que se va a eliminar
     * @return true si el chat se eliminó correctamente, false en caso contrario
     * @throws NegocioException si ocurre un error al eliminar el chat
     */
    @Override
    public boolean eliminar(ChatDTO chat) throws NegocioException {
        try {
            return chatDAO.eliminar(conversorChat.DtoAEntidad(chat));
        } catch (Exception e) {
            throw new NegocioException("No se pudo eliminar el chat: ", e);
        }
    }

    /**
     * Vacía un chat.
     *
     * @param chat el DTO del chat que se va a vaciar
     * @return true si el chat se vació correctamente, false en caso contrario
     * @throws NegocioException si ocurre un error al vaciar el chat
     */
    @Override
    public boolean vaciar(ChatDTO chat) throws NegocioException {
        try {
            return chatDAO.vaciar(conversorChat.DtoAEntidad(chat));
        } catch (Exception e) {
            throw new NegocioException("No se pudo vaciar el chat: ", e);
        }
    }

    /**
     * Recupera un chat entre dos usuarios.
     *
     * @param usuarioRemitente el DTO del usuario remitente
     * @param usuarioRemisor el DTO del usuario receptor
     * @return el DTO del chat recuperado
     * @throws NegocioException si ocurre un error al recuperar el chat
     */
    @Override
    public ChatDTO obtener(UsuarioDTO usuarioRemitente, UsuarioDTO usuarioRemisor) throws NegocioException {
        try {
            return conversorChat.entidadADto(chatDAO.obtener(conversorUsuario.DtoAEntidad(usuarioRemitente), conversorUsuario.DtoAEntidad(usuarioRemisor)));
        } catch (Exception e) {
            throw new NegocioException("No se pudo recuperar el chat: ", e);
        }
    }

    /**
     * Recupera todos los chats.
     *
     * @return una lista de todos los DTOs de chat
     * @throws NegocioException si ocurre un error al recuperar los chats
     */
    @Override
    public List<ChatDTO> consultarTodos() throws NegocioException {
        try {
            return conversorChat.listaChatsADto(chatDAO.consultarTodos());
        } catch (Exception e) {
            throw new NegocioException("No se pudieron recuperar los chats: ", e);
        }
    }

    /**
     * Guarda un mensaje en un chat.
     *
     * @param chat el DTO del chat en el que se guardará el mensaje
     * @param mensaje el DTO del mensaje que se va a guardar
     * @return el DTO del mensaje guardado
     * @throws NegocioException si ocurre un error al guardar el mensaje
     */
    @Override
    public MensajeDTO guardarMensaje(ChatDTO chat, MensajeDTO mensaje) throws NegocioException {
        try {
            return conversorMensajes.entidadADto(chatDAO.guardarMensaje(conversorChat.DtoAEntidad(chat), conversorMensajes.DtoAEntidad(mensaje)));
        } catch (Exception e) {
            throw new NegocioException("No se pudo enviar el mensaje: ", e);
        }
    }

    /**
     * Recupera todos los mensajes de un chat.
     *
     * @param chat el DTO del chat del cual se recuperarán los mensajes
     * @return una lista de los DTOs de los mensajes
     * @throws NegocioException si ocurre un error al recuperar los mensajes
     */
    @Override
    public List<MensajeDTO> consultarMensajes(ChatDTO chat) throws NegocioException {
        try {
            return conversorMensajes.listaMensajesADto(conversorChat.DtoAEntidad(chat).getMensajes());
        } catch (Exception e) {
            throw new NegocioException("No se pudo recuperar la conversación: ", e);
        }
    }
}
