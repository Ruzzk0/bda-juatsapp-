/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juatsapp.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PERSONAL
 */
/**
 * La clase ChatDTO representa un objeto de transferencia de datos para un chat
 * en la aplicación. Contiene información sobre el chat, incluido su
 * identificador único, fecha de creación, lista de participantes y lista de
 * mensajes.
 */
public class ChatDTO {

    /**
     * Identificador único del chat.
     */
    private String id;

    /**
     * Fecha de creación del chat.
     */
    private Date fechaCreacion;

    /**
     * Lista de participantes en el chat representados como objetos UsuarioDTO.
     */
    private List<UsuarioDTO> participantes;

    /**
     * Lista de mensajes enviados en el chat representados como objetos
     * MensajeDTO.
     */
    private List<MensajeDTO> mensajes;

    /**
     * Constructor predeterminado de la clase ChatDTO. Inicializa la fecha de
     * creación y las listas de participantes y mensajes.
     */
    public ChatDTO() {
        this.fechaCreacion = new Date();
        this.participantes = new ArrayList<>();
        this.mensajes = new ArrayList<>();
    }

    /**
     * Constructor parametrizado de la clase ChatDTO.
     *
     * @param id Identificador único del chat.
     * @param fechaCreacion Fecha de creación del chat.
     * @param participantes Lista de participantes en el chat.
     * @param mensajes Lista de mensajes enviados en el chat.
     */
    public ChatDTO(String id, Date fechaCreacion, List<UsuarioDTO> participantes, List<MensajeDTO> mensajes) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.participantes = participantes;
        this.mensajes = mensajes;
    }

    /**
     * Método para obtener la lista de participantes en el chat.
     *
     * @return La lista de participantes.
     */
    public List<UsuarioDTO> getParticipantes() {
        return participantes;
    }

    /**
     * Método para establecer la lista de participantes en el chat.
     *
     * @param participantes La lista de participantes.
     */
    public void setParticipantes(List<UsuarioDTO> participantes) {
        this.participantes = participantes;
    }

    /**
     * Método para obtener la lista de mensajes enviados en el chat.
     *
     * @return La lista de mensajes.
     */
    public List<MensajeDTO> getMensajes() {
        return mensajes;
    }

    /**
     * Método para establecer la lista de mensajes enviados en el chat.
     *
     * @param mensajes La lista de mensajes.
     */
    public void setMensajes(List<MensajeDTO> mensajes) {
        this.mensajes = mensajes;
    }

    /**
     * Método para obtener el identificador único del chat.
     *
     * @return El identificador único del chat.
     */
    public String getId() {
        return id;
    }

    /**
     * Método para establecer el identificador único del chat.
     *
     * @param id El identificador único del chat.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método para obtener la fecha de creación del chat.
     *
     * @return La fecha de creación del chat.
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Método para establecer la fecha de creación del chat.
     *
     * @param fechaCreacion La fecha de creación del chat.
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
