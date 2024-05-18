/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package juatsapp.negocioInterfaces;

import excepciones.NegocioException;
import java.util.List;
import juatsapp.dtos.ChatDTO;
import juatsapp.dtos.MensajeDTO;
import juatsapp.dtos.UsuarioDTO;

/**
 * La interfaz IChatBO define los métodos que deben ser implementados por
 * cualquier clase que se encargue de la lógica de negocio relacionada con la
 * gestión de chats en el sistema.
 *
 * Estos métodos permiten realizar operaciones como guardar, eliminar, vaciar,
 * obtener y consultar chats, así como también guardar y consultar mensajes
 * asociados a los chats.
 *
 * @author Paco
 */
public interface IChatBO {

    /**
     * Guarda un nuevo chat en el sistema.
     *
     * @param chat El objeto ChatDTO que se va a guardar.
     * @return true si el chat fue guardado exitosamente.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public boolean guardar(ChatDTO chat) throws NegocioException;

    /**
     * Elimina un chat del sistema.
     *
     * @param chat El objeto ChatDTO que se va a eliminar.
     * @return true si el chat fue eliminado exitosamente.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public boolean eliminar(ChatDTO chat) throws NegocioException;

    /**
     * Vacia los mensajes de un chat, dejándolo sin ningún mensaje.
     *
     * @param chat El objeto ChatDTO del cual se van a eliminar los mensajes.
     * @return true si el chat fue vaciado exitosamente.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public boolean vaciar(ChatDTO chat) throws NegocioException;

    /**
     * Obtiene un chat del sistema dado el remitente y el receptor.
     *
     * @param usuarioRemitente El objeto UsuarioDTO que es el remitente del
     * chat.
     * @param usuarioRemisor El objeto UsuarioDTO que es el receptor del chat.
     * @return El objeto ChatDTO correspondiente a la conversación entre los
     * usuarios especificados.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public ChatDTO obtener(UsuarioDTO usuarioRemitente, UsuarioDTO usuarioRemisor) throws NegocioException;

    /**
     * Consulta todos los chats almacenados en el sistema.
     *
     * @return Una lista de objetos ChatDTO que representan todos los chats
     * almacenados.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public List<ChatDTO> consultarTodos() throws NegocioException;

    /**
     * Guarda un nuevo mensaje en el chat especificado.
     *
     * @param chat El objeto ChatDTO en el cual se va a guardar el mensaje.
     * @param mensaje El objeto MensajeDTO que se va a guardar.
     * @return El objeto MensajeDTO guardado.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public MensajeDTO guardarMensaje(ChatDTO chat, MensajeDTO mensaje) throws NegocioException;

    /**
     * Consulta todos los mensajes del chat especificado.
     *
     * @param chat El objeto ChatDTO del cual se van a consultar los mensajes.
     * @return Una lista de objetos MensajeDTO que representan todos los
     * mensajes del chat.
     * @throws NegocioException Si ocurre un error durante la operación.
     */
    public List<MensajeDTO> consultarMensajes(ChatDTO chat) throws NegocioException;
    
    /**
     * Obtiene una lista con los chats del usuario.
     *
     * @param usuario El usuario.
     * @return La lista de chats que contienen al usuario o una lista vacía si
     * no se encuentra ninguno.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * obtención.
     */
    public List<ChatDTO> obtener(UsuarioDTO usuario) throws NegocioException;
    
    /**
     * Actualiza todos los datos del usuario en todos los chats relacionados a
     * el;
     *
     * @param usuario Usuario actualizado
     * @return True si fue actualizado correctamente en todos los chats, false
     * si no.
     * @throws NegocioException Si ocurre un error durante la actualización.
     */
    public boolean actualizarUsuarioEnChats(UsuarioDTO usuario) throws NegocioException;
}
