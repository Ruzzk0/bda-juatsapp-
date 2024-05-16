/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DOMINIO;

import java.util.Date;

/**
 *
 * @author Paco
 */
public class Mensaje {
    
    private Usuario emisor;
    private String texto;
    private Date fechaHoraEnviado;

    public Mensaje() {
    }

    public Mensaje(Usuario emisor, String texto) {
        this.emisor = emisor;
        this.texto = texto;
        fechaHoraEnviado = new Date();
    }

    
    public Usuario getEmisor() {
        return emisor;
    }

    public void setEmisor(Usuario emisor) {
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
