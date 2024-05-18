/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.Control;

import excepciones.NegocioException;
import frm.FrmBuscarImg;
import frm.FrmEditar;
import frm.FrmInicioSesion;
import frm.FrmMenuChats;
import frm.FrmMenuPrincipal;
import frm.FrmNuevoChat;
import frm.FrmRegistro;
import java.util.logging.Level;
import java.util.logging.Logger;
import juatsapp.dtos.ChatDTO;
import juatsapp.dtos.UsuarioDTO;
import juatsapp.negocio.UsuarioBO;
import juatsapp.negocioInterfaces.IUsuarioBO;

/**
 *
 * @author PERSONAL
 */
public class ControlPresentacion {
    
    private static ControlPresentacion instance;
    private UsuarioDTO usuarioActivo;
    private ChatDTO chatAbierto;
    private IUsuarioBO usuarioBO;

    public ControlPresentacion() {
        usuarioBO = new UsuarioBO();
    }
    
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
    public void mostrarMenuPrincipal(){
        FrmMenuPrincipal mp = new FrmMenuPrincipal();
        mp.setVisible(true);
    }
    
    public void mostrarRegistro(){
        FrmRegistro r = new FrmRegistro();
        r.setVisible(true);
    }
    
    public void mostrarInicioSesion(){
        FrmInicioSesion is = new FrmInicioSesion();
        is.setVisible(true);
    }
    
    public void mostrarMenuChats(){
        FrmMenuChats mc = new FrmMenuChats();
        mc.setVisible(true);
    }
    
    public void mostrarNuevoChat(){
        FrmNuevoChat nc = new FrmNuevoChat();
        nc.setVisible(true);
    }
    
    public void mostrarBuscarImg(){
        FrmBuscarImg bi = new FrmBuscarImg();
        bi.setVisible(true);
    }
    
    public void mostrarEditar(){
        FrmEditar e = new FrmEditar();
        e.setVisible(true);
    }
    
    public boolean autentificar(String usuario, String contra) {
        UsuarioDTO usuarioConsulta; 
        try {
            usuarioConsulta = usuarioBO.obtener(usuario);
        } catch (NegocioException ex) {
            Logger.getLogger(ControlPresentacion.class.getName()).log(Level.SEVERE, null, ex);
            usuarioConsulta = null;
        }
        if (usuarioConsulta != null && usuarioConsulta.getContra().equals(contra)) {
            usuarioActivo = usuarioConsulta; 
            return true;
        } else {
            return false;
        }
        
    }
}
