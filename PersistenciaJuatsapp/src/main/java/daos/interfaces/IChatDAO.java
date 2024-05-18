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
 * La interfaz IChatDAO define los métodos que deben ser implementados por
 * cualquier clase que proporcione acceso a datos para la gestión de chats en el
 * sistema.
 *
 * Estos métodos permiten realizar operaciones CRUD (Crear, Leer, Actualizar,
 * Eliminar) en la base de datos para objetos de tipo Chat y Mensaje.
 *
 * @see Chat
 * @see Mensaje
 */
public interface IChatDAO {

    /**
     * Guarda un nuevo chat en la base de datos.
     *
     * @param chat El objeto Chat que se va a guardar.
     * @return true si el chat fue guardado exitosamente.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    public boolean guardar(Chat chat) throws PersistenciaException;

    /**
     * Elimina un chat de la base de datos.
     *
     * @param chat El objeto Chat que se va a eliminar.
     * @return true si el chat fue eliminado exitosamente.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    public boolean eliminar(Chat chat) throws PersistenciaException;

    /**
     * Vacia los mensajes de un chat, dejándolo sin ningún mensaje.
     *
     * @param chat El objeto Chat del cual se van a eliminar los mensajes.
     * @return true si el chat fue vaciado exitosamente.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    public boolean vaciar(Chat chat) throws PersistenciaException;

    /**
     * Obtiene un chat de la base de datos dado el remitente y el receptor.
     *
     * @param usuarioRemitente El objeto Usuario que es el remitente del chat.
     * @param usuarioRemisor El objeto Usuario que es el receptor del chat.
     * @return El objeto Chat correspondiente a la conversación entre los
     * usuarios especificados.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    public Chat obtener(Usuario usuarioRemitente, Usuario usuarioRemisor) throws PersistenciaException;

    /**
     * Consulta todos los chats almacenados en la base de datos.
     *
     * @return Una lista de objetos Chat que representan todos los chats
     * almacenados.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    public List<Chat> consultarTodos() throws PersistenciaException;

    /**
     * Guarda un nuevo mensaje en el chat especificado.
     *
     * @param chat El objeto Chat en el cual se va a guardar el mensaje.
     * @param mensaje El objeto Mensaje que se va a guardar.
     * @return El objeto Mensaje guardado.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    public Mensaje guardarMensaje(Chat chat, Mensaje mensaje) throws PersistenciaException;

    /**
     * Consulta todos los mensajes del chat especificado.
     *
     * @param chat El objeto Chat del cual se van a consultar los mensajes.
     * @return Una lista de objetos Mensaje que representan todos los mensajes
     * del chat.
     * @throws PersistenciaException Si ocurre un error durante la operación.
     */
    public List<Mensaje> consultarMensajes(Chat chat) throws PersistenciaException;

}
