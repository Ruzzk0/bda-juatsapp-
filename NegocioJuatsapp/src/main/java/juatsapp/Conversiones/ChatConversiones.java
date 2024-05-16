/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juatsapp.Conversiones;

import DOMINIO.Chat;
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
    
    public ChatDTO entidadADto(Chat chat){
        ChatDTO convertido = new ChatDTO();
        convertido.setId(chat.getId().toHexString());
        convertido.setParticipantes(conversorUsuario.listaUsuariosADto(chat.getParticipantes()));
        convertido.setMensajes(conversorMensajes.listaMensajesADto(chat.getMensajes()));
        convertido.setFechaCreacion(chat.getFechaCreacion());
        return convertido;
    }
    
    public Chat DtoAEntidad(ChatDTO chat){
        Chat convertido = new Chat();
        convertido.setId(new ObjectId(chat.getId()));
        convertido.setParticipantes(conversorUsuario.listaDtoAEntidad(chat.getParticipantes()));
        convertido.setMensajes(conversorMensajes.listaDtoAEntidad(chat.getMensajes()));
        convertido.setFechaCreacion(chat.getFechaCreacion());
        return convertido;
    }
    
    public List<ChatDTO> listaChatsADto(List<Chat> chats){
        List<ChatDTO> convertidos = new ArrayList<>();
        for (Chat convertido : chats) {
            convertidos.add(entidadADto(convertido));
        }
        return convertidos;
    }
    
    public List<Chat> listaDtoAEntidad(List<ChatDTO> chats){
        List<Chat> convertidos = new ArrayList<>();
        for (ChatDTO convertido : chats) {
            convertidos.add(DtoAEntidad(convertido));
        }
        return convertidos;
    }
}
