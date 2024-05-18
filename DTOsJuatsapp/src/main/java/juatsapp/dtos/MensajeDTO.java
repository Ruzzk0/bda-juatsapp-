/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juatsapp.dtos;

import java.util.Date;

/**
 *
 * @author PERSONAL
 */
public class MensajeDTO {
    private UsuarioDTO emisor;
    private String texto;
    private Date fechaHoraEnviado;

    public MensajeDTO() {
    }

    public MensajeDTO(UsuarioDTO emisor, String texto) {
        this.emisor = emisor;
        this.texto = texto;
        fechaHoraEnviado = new Date();
    }

    
    public UsuarioDTO getEmisor() {
        return emisor;
    }

    public void setEmisor(UsuarioDTO emisor) {
        this.emisor = emisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFechaHoraEnviado() {
        return fechaHoraEnviado;
    }

    public void setFechaHoraEnviado(Date fechaHoraEnviado) {
        this.fechaHoraEnviado = fechaHoraEnviado;
    }
}
