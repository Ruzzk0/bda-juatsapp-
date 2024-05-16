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

    public ChatDAO() {
        this.conexion = new MongoDBConexion("Chats", Chat.class);
    }

    @Override
    public boolean guardar(Chat chat) throws PersistenciaException {
        try {
            MongoCollection<Chat> coleccion = conexion.obtenerColeccion();
            coleccion.insertOne(chat);
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo agregar al usuario", e);
        }
    }

    @Override
    public boolean eliminar(Chat chat) throws PersistenciaException {
        try {
            MongoCollection<Usuario> coleccion = conexion.obtenerColeccion();
            coleccion.deleteOne(Filters.eq("_id", chat.getId()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean vaciar(Chat chat) throws PersistenciaException {
        try {
            chat.setMensajes(new ArrayList<Mensaje>());
            MongoCollection<Chat> coleccion = conexion.obtenerColeccion();

            UpdateResult result = coleccion.replaceOne(eq("_id", chat.getId()), chat);

            if (result.getModifiedCount() == 1) {
                return true;
            } else {
                throw new PersistenciaException("No se pudo vaciar el chat");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al vaciar: " + e.getMessage());
        }
    }

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
            throw new PersistenciaException("Error al obtener el chat: " + e.getMessage());
        }
    }

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
            throw new PersistenciaException("Error al consultar usuarios: " + e.getMessage());
        }
    }

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
            throw new PersistenciaException("Error al guardar el mensaje: " + e.getMessage());
        }
    }

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
            throw new PersistenciaException("Error al consultar los mensajes: " + e.getMessage());
        }
    }

}
