
package DOMINIO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author ruzzky
 */
public class Chat {
    
    private ObjectId id;
    private Date fechaCreacion;
    private List<Usuario> participantes;
    private List<Mensaje> mensajes;

    public Chat() {
        this.fechaCreacion = new Date();
        this.participantes = new ArrayList<>();
        this.mensajes = new ArrayList<>();
    }

    public List<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Usuario> participantes) {
        this.participantes = participantes;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
}
