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
 *
 * @author PERSONAL
 */
public class ChatConversiones {
    
    UsuarioConversiones conversorUsuario;
    MensajeConversiones conversorMensajes;
    
    public ChatConversiones() {
        conversorMensajes = new MensajeConversiones();
        conversorUsuario = new UsuarioConversiones();
    }
    
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
