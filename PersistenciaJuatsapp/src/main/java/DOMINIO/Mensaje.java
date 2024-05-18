/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DOMINIO;

import java.util.Date;

/**
 * La clase Mensaje representa un mensaje enviado por un usuario en una conversación.
 * Cada mensaje contiene un emisor, un texto y la fecha y hora en que fue enviado.
 * 
 * @see Usuario
 */
public class Mensaje {
    
    private Usuario emisor;
    private String texto;
    private Date fechaHoraEnviado;

    /**
     * Constructor por defecto de la clase Mensaje.
     */
    public Mensaje() {
    }

    /**
     * Constructor de la clase Mensaje que inicializa el emisor, el texto del mensaje 
     * y la fecha y hora de envío.
     * 
     * @param emisor El usuario que envía el mensaje.
     * @param texto El texto del mensaje.
     */
    public Mensaje(Usuario emisor, String texto) {
        this.emisor = emisor;
        this.texto = texto;
        fechaHoraEnviado = new Date();
    }

    /**
     * Obtiene el emisor del mensaje.
     * 
     * @return El objeto Usuario que representa al emisor del mensaje.
     */
    public Usuario getEmisor() {
        return emisor;
    }

    /**
     * Establece el emisor del mensaje.
     * 
     * @param emisor El objeto Usuario que representa al nuevo emisor del mensaje.
     */
    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
    }

    /**
     * Obtiene el texto del mensaje.
     * 
     * @return El texto del mensaje.
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Establece el texto del mensaje.
     * 
     * @param texto El nuevo texto del mensaje.
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Obtiene la fecha y hora en que se envió el mensaje.
     * 
     * @return Un objeto Date que representa la fecha y hora de envío del mensaje.
     */
    public Date getFechaHoraEnviado() {
        return fechaHoraEnviado;
    }

    /**
     * Establece la fecha y hora en que se envió el mensaje.
     * 
     * @param fechaHoraEnviado Un objeto Date que representa la nueva fecha y hora de envío del mensaje.
     */
    public void setFechaHoraEnviado(Date fechaHoraEnviado) {
        this.fechaHoraEnviado = fechaHoraEnviado;
    }
    
}
