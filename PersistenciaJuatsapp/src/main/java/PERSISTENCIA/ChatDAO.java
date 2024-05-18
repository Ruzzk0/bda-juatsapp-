/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PERSISTENCIA;

import Conexion.IMongoDBConexion;
import Conexion.MongoDBConexion;
import DOMINIO.Chat;
import DOMINIO.Mensaje;
import DOMINIO.Usuario;
import EXCEPCIONES.PersistenciaException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.UpdateResult;
import daos.interfaces.IChatDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ChatDAO implements IChatDAO {

    IMongoDBConexion conexion;

    /**
     * Constructor de la clase ChatDAO. Inicializa la conexión a la base de
     * datos MongoDB para la colección "Chats".
     */
    public ChatDAO() {
        this.conexion = new MongoDBConexion("Chats", Chat.class);
    }

    /**
     * Guarda un nuevo chat en la base de datos.
     *
     * @param chat El objeto Chat que se va a guardar.
     * @return true si el guardado es exitoso.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * guardado.
     */
    @Override
    public boolean guardar(Chat chat) throws PersistenciaException {
        try {
            MongoCollection<Chat> coleccion = conexion.obtenerColeccion();
            coleccion.insertOne(chat);
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo agregar el chat", e);
        }
    }

    /**
     * Elimina un chat de la base de datos.
     *
     * @param chat El objeto Chat que se va a eliminar.
     * @return true si la eliminación es exitosa.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * eliminación.
     */
    @Override
    public boolean eliminar(Chat chat) throws PersistenciaException {
        try {
            MongoCollection<Chat> coleccion = conexion.obtenerColeccion();
            coleccion.deleteOne(Filters.eq("_id", chat.getId()));
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo eliminar el chat", e);
        }
    }

    /**
     * Vacía los mensajes de un chat.
     *
     * @param chat El objeto Chat cuyos mensajes se van a vaciar.
     * @return true si el vaciado es exitoso.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * vaciado.
     */
    @Override
    public boolean vaciar(Chat chat) throws PersistenciaException {
        try {
            chat.setMensajes(new ArrayList<>());
            MongoCollection<Chat> coleccion = conexion.obtenerColeccion();
            UpdateResult result = coleccion.replaceOne(eq("_id", chat.getId()), chat);

            if (result.getModifiedCount() == 1) {
                return true;
            } else {
                throw new PersistenciaException("No se pudo vaciar el chat");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al vaciar: " + e.getMessage(), e);
        }
    }

    /**
     * Obtiene un chat entre dos usuarios específicos.
     *
     * @param usuarioRemitente El usuario remitente.
     * @param usuarioRemisor El usuario remisor.
     * @return El objeto Chat que contiene la conversación entre los dos
     * usuarios, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * obtención.
     */
    @Override
    public Chat obtener(Usuario usuarioRemitente, Usuario usuarioRemisor) throws PersistenciaException {
        try {
            MongoCollection<Chat> coleccion = conexion.obtenerColeccion();
            for (Chat chat : coleccion.find()) {
                if (chat.getParticipantes().contains(usuarioRemitente) && chat.getParticipantes().contains(usuarioRemisor)) {
                    return chat;
                }
            }
            return null;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener el chat: " + e.getMessage(), e);
        }
    }

    /**
     * Consulta todos los chats almacenados en la base de datos.
     *
     * @return Una lista de objetos Chat.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * consulta.
     */
    @Override
    public List<Chat> consultarTodos() throws PersistenciaException {
        try {
            MongoCollection<Chat> coleccion = conexion.obtenerColeccion();
            FindIterable<Chat> chatsConsulta = coleccion.find();
            List<Chat> listaChats = new ArrayList<>();

            for (Chat chat : chatsConsulta) {
                listaChats.add(chat);
            }
            return listaChats;
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar chats: " + e.getMessage(), e);
        }
    }

    /**
     * Guarda un nuevo mensaje en un chat existente.
     *
     * @param chat El objeto Chat en el cual se va a guardar el mensaje.
     * @param mensaje El objeto Mensaje que se va a guardar.
     * @return El objeto Mensaje guardado.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * guardado.
     */
    @Override
    public Mensaje guardarMensaje(Chat chat, Mensaje mensaje) throws PersistenciaException {
        try {
            if (chat != null) {
                chat.getMensajes().add(mensaje);
                MongoCollection<Chat> coleccion = conexion.obtenerColeccion();
                coleccion.replaceOne(eq("_id", chat.getId()), chat);
                return mensaje;
            } else {
                throw new PersistenciaException("El chat proporcionado es nulo.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al guardar el mensaje: " + e.getMessage(), e);
        }
    }

    /**
     * Consulta los mensajes de un chat específico.
     *
     * @param chat El objeto Chat cuyos mensajes se van a consultar.
     * @return Una lista de objetos Mensaje.
     * @throws PersistenciaException Si ocurre un error durante el proceso de
     * consulta.
     */
    @Override
    public List<Mensaje> consultarMensajes(Chat chat) throws PersistenciaException {
        try {
            if (chat != null) {
                MongoCollection<Chat> coleccion = conexion.obtenerColeccion();
                Chat chatEncontrado = coleccion.find(eq("_id", chat.getId())).first();

                if (chatEncontrado != null) {
                    return chatEncontrado.getMensajes();
                } else {
                    throw new PersistenciaException("El chat no fue encontrado.");
                }
            } else {
                throw new PersistenciaException("Chat vacío.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar los mensajes: " + e.getMessage(), e);
        }
    }

}
