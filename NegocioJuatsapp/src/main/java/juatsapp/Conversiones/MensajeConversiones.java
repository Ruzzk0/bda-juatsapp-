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
 * La clase MensajeConversiones proporciona métodos para convertir entre
 * entidades de Mensaje y DTOs de Mensaje.
 *
 * Estos métodos permiten la conversión de objetos Mensaje a MensajeDTO y
 * viceversa, así como también la conversión de listas de objetos Mensaje a
 * listas de objetos MensajeDTO y viceversa.
 *
 * @author Paco
 */
public class MensajeConversiones {

    private UsuarioConversiones conversorUsuario;

    /**
     * Constructor de la clase MensajeConversiones. Inicializa el conversor de
     * Usuario.
     */
    public MensajeConversiones() {
        conversorUsuario = new UsuarioConversiones();
    }

    /**
     * Convierte un objeto Mensaje a un objeto MensajeDTO.
     *
     * @param mensaje El objeto Mensaje que se va a convertir.
     * @return El objeto MensajeDTO convertido.
     * @throws NegocioException Si ocurre un error durante la conversión.
     */
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

    /**
     * Convierte un objeto MensajeDTO a un objeto Mensaje.
     *
     * @param mensaje El objeto MensajeDTO que se va a convertir.
     * @return El objeto Mensaje convertido.
     * @throws NegocioException Si ocurre un error durante la conversión.
     */
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

    /**
     * Convierte una lista de objetos Mensaje a una lista de objetos MensajeDTO.
     *
     * @param mensajes La lista de objetos Mensaje que se va a convertir.
     * @return La lista de objetos MensajeDTO convertida.
     * @throws NegocioException Si ocurre un error durante la conversión.
     */
    public List<MensajeDTO> listaMensajesADto(List<Mensaje> mensajes) throws NegocioException {
        List<MensajeDTO> convertidos = new ArrayList<>();
        for (Mensaje convertido : mensajes) {
            convertidos.add(entidadADto(convertido));
        }
        return convertidos;
    }

    /**
     * Convierte una lista de objetos MensajeDTO a una lista de objetos Mensaje.
     *
     * @param mensajes La lista de objetos MensajeDTO que se va a convertir.
     * @return La lista de objetos Mensaje convertida.
     * @throws NegocioException Si ocurre un error durante la conversión.
     */
    public List<Mensaje> listaDtoAEntidad(List<MensajeDTO> mensajes) throws NegocioException {
        List<Mensaje> convertidos = new ArrayList<>();
        for (MensajeDTO convertido : mensajes) {
            convertidos.add(DtoAEntidad(convertido));
        }
        return convertidos;
    }
}
