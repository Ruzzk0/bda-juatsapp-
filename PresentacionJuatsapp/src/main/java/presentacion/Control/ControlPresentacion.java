/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.Control;

import juatsapp.dtos.ChatDTO;
import juatsapp.dtos.UsuarioDTO;

/**
 *
 * @author PERSONAL
 */
public class ControlPresentacion {
    
    private static ControlPresentacion instance;
    private UsuarioDTO usuarioActivo;
    private ChatDTO chatAbierto;
    
    public static ControlPresentacion getInstance(){
        if (instance == null) {
            instance = new ControlPresentacion();
        }
        return instance;
    }

    public UsuarioDTO getUsuarioActivo() {
        return usuarioActivo;
    }

    public void setUsuarioActivo(UsuarioDTO usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }

    public ChatDTO getChatAbierto() {
        return chatAbierto;
    }

    public void setChatAbierto(ChatDTO chatAbierto) {
        this.chatAbierto = chatAbierto;
    }
    
    //Agrega cambios de pantalla
    public void 
}
