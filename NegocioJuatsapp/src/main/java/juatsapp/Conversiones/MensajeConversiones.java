/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juatsapp.Conversiones;

import DOMINIO.Mensaje;
import java.util.ArrayList;
import java.util.List;
import juatsapp.dtos.MensajeDTO;

/**
 *
 * @author Paco
 */
public class MensajeConversiones {

    UsuarioConversiones conversorUsuario;
    
    public MensajeConversiones() {
        conversorUsuario = new UsuarioConversiones();
    }
    
    public MensajeDTO entidadADto(Mensaje mensaje){
        MensajeDTO convertido = new MensajeDTO();
        convertido.setFechaHoraEnviado(mensaje.getFechaHoraEnviado());
        convertido.setTexto(mensaje.getTexto());
        convertido.setEmisor(conversorUsuario.entidadADto(mensaje.getEmisor()));
        return convertido;
    }
    
    public Mensaje DtoAEntidad(MensajeDTO mensaje){
        Mensaje convertido = new Mensaje();
        convertido.setFechaHoraEnviado(mensaje.getFechaHoraEnviado());
        convertido.setTexto(mensaje.getTexto());
        convertido.setEmisor(conversorUsuario.DtoAEntidad(mensaje.getEmisor()));
        return convertido;
    }
    
    public List<MensajeDTO> listaMensajesADto(List<Mensaje> mensajes){
        List<MensajeDTO> convertidos = new ArrayList<>();
        for (Mensaje convertido : mensajes) {
            convertidos.add(entidadADto(convertido));
        }
        return convertidos;
    }
    
    public List<Mensaje> listaDtoAEntidad(List<MensajeDTO> mensajes){
        List<Mensaje> convertidos = new ArrayList<>();
        for (MensajeDTO convertido : mensajes) {
            convertidos.add(DtoAEntidad(convertido));
        }
        return convertidos;
    }
}
