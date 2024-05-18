/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juatsapp.Conversiones;

import DOMINIO.Chat;
import excepciones.NegocioException;
import java.util.ArrayList;
import java.util.List;
import juatsapp.dtos.ChatDTO;
import org.bson.types.ObjectId;

/**
 * La clase ChatConversiones proporciona métodos para convertir entre entidades
 * de Chat y DTOs de Chat.
 *
 * Estos métodos permiten la conversión de objetos Chat a ChatDTO y viceversa,
 * así como también la conversión de listas de objetos Chat a listas de objetos
 * ChatDTO y viceversa.
 *
 * @see Chat
 * @see ChatDTO
 */
public class ChatConversiones {

    private UsuarioConversiones conversorUsuario;
    private MensajeConversiones conversorMensajes;

    /**
     * Constructor de la clase ChatConversiones. Inicializa los conversores de
     * Usuario y Mensaje.
     */
    public ChatConversiones() {
        conversorMensajes = new MensajeConversiones();
        conversorUsuario = new UsuarioConversiones();
    }

    /**
     * Convierte un objeto Chat a un objeto ChatDTO.
     *
     * @param chat El objeto Chat que se va a convertir.
     * @return El objeto ChatDTO convertido.
     * @throws NegocioException Si ocurre un error durante la conversión.
     */
    public ChatDTO entidadADto(Chat chat) throws NegocioException {
        try {
            ChatDTO convertido = new ChatDTO();
            convertido.setId(chat.getId().toHexString());
            convertido.setParticipantes(conversorUsuario.listaUsuariosADto(chat.getParticipantes()));
            convertido.setMensajes(conversorMensajes.listaMensajesADto(chat.getMensajes()));
            convertido.setFechaCreacion(chat.getFechaCreacion());
            return convertido;
        } catch (Exception e) {
            throw new NegocioException("Error al convertir entidad a DTO: " + e.getMessage());
        }
    }

    /**
     * Convierte un objeto ChatDTO a un objeto Chat.
     *
     * @param chat El objeto ChatDTO que se va a convertir.
     * @return El objeto Chat convertido.
     * @throws NegocioException Si ocurre un error durante la conversión.
     */
    public Chat DtoAEntidad(ChatDTO chat) throws NegocioException {
        try {
            Chat convertido = new Chat();
            convertido.setId(new ObjectId(chat.getId()));
            convertido.setParticipantes(conversorUsuario.listaDtoAEntidad(chat.getParticipantes()));
            convertido.setMensajes(conversorMensajes.listaDtoAEntidad(chat.getMensajes()));
            convertido.setFechaCreacion(chat.getFechaCreacion());
            return convertido;
        } catch (Exception e) {
            throw new NegocioException("Error al convertir DTO a entidad: " + e.getMessage());
        }
    }

    /**
     * Convierte una lista de objetos Chat a una lista de objetos ChatDTO.
     *
     * @param chats La lista de objetos Chat que se va a convertir.
     * @return La lista de objetos ChatDTO convertida.
     * @throws NegocioException Si ocurre un error durante la conversión.
     */
    public List<ChatDTO> listaChatsADto(List<Chat> chats) throws NegocioException {
        try {
            List<ChatDTO> convertidos = new ArrayList<>();
            for (Chat convertido : chats) {
                convertidos.add(entidadADto(convertido));
            }
            return convertidos;
        } catch (Exception e) {
            throw new NegocioException("Error al convertir lista de entidades a DTO: " + e.getMessage());
        }
    }

    /**
     * Convierte una lista de objetos ChatDTO a una lista de objetos Chat.
     *
     * @param chats La lista de objetos ChatDTO que se va a convertir.
     * @return La lista de objetos Chat convertida.
     * @throws NegocioException Si ocurre un error durante la conversión.
     */
    public List<Chat> listaDtoAEntidad(List<ChatDTO> chats) throws NegocioException {
        try {
            List<Chat> convertidos = new ArrayList<>();
            for (ChatDTO convertido : chats) {
                convertidos.add(DtoAEntidad(convertido));
            }
            return convertidos;
        } catch (Exception e) {
            throw new NegocioException("Error al convertir lista de DTO a entidades: " + e.getMessage());
        }
    }
}
