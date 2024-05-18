/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juatsapp.Conversiones;

import DOMINIO.Mensaje;
import excepciones.NegocioException;
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

    public MensajeDTO entidadADto(Mensaje mensaje) throws NegocioException {
        MensajeDTO convertido = new MensajeDTO();
        try {
            convertido.setFechaHoraEnviado(mensaje.getFechaHoraEnviado());
            convertido.setTexto(mensaje.getTexto());
            convertido.setEmisor(conversorUsuario.entidadADto(mensaje.getEmisor()));
        } catch (Exception ex) {
            throw new NegocioException("Error al convertir entidad a DTO: " + ex.getMessage());
        }
        return convertido;
    }

    public Mensaje DtoAEntidad(MensajeDTO mensaje) throws NegocioException {
        Mensaje convertido = new Mensaje();
        try {
            convertido.setFechaHoraEnviado(mensaje.getFechaHoraEnviado());
            convertido.setTexto(mensaje.getTexto());
            convertido.setEmisor(conversorUsuario.DtoAEntidad(mensaje.getEmisor()));
        } catch (Exception ex) {
            throw new NegocioException("Error al convertir DTO a entidad: " + ex.getMessage());
        }
        return convertido;
    }

    public List<MensajeDTO> listaMensajesADto(List<Mensaje> mensajes) throws NegocioException {
        List<MensajeDTO> convertidos = new ArrayList<>();
        for (Mensaje convertido : mensajes) {
            convertidos.add(entidadADto(convertido));
        }
        return convertidos;
    }

    public List<Mensaje> listaDtoAEntidad(List<MensajeDTO> mensajes) throws NegocioException {
        List<Mensaje> convertidos = new ArrayList<>();
        for (MensajeDTO convertido : mensajes) {
            convertidos.add(DtoAEntidad(convertido));
        }
        return convertidos;
    }
}
