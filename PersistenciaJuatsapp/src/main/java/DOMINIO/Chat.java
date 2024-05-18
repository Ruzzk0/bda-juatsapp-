package DOMINIO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * La clase Chat representa una conversación entre múltiples usuarios en el
 * sistema. Cada chat contiene una lista de participantes, una lista de mensajes
 * y la fecha de creación del chat.
 *
 * Esta clase se utiliza para almacenar y gestionar la información relacionada
 * con las conversaciones en la base de datos.
 *
 * @see Usuario
 * @see Mensaje
 */
public class Chat {

    private ObjectId id;
    private Date fechaCreacion;
    private List<Usuario> participantes;
    private List<Mensaje> mensajes;

    /**
     * Constructor por defecto de la clase Chat. Inicializa la fecha de creación
     * con la fecha actual y crea listas vacías para los participantes y los
     * mensajes.
     */
    public Chat() {
        this.fechaCreacion = new Date();
        this.participantes = new ArrayList<>();
        this.mensajes = new ArrayList<>();
    }

    /**
     * Obtiene la lista de participantes del chat.
     *
     * @return Una lista de objetos Usuario que representan los participantes
     * del chat.
     */
    public List<Usuario> getParticipantes() {
        return participantes;
    }

    /**
     * Establece la lista de participantes del chat.
     *
     * @param participantes Una lista de objetos Usuario que representan los
     * nuevos participantes del chat.
     */
    public void setParticipantes(List<Usuario> participantes) {
        this.participantes = participantes;
    }

    /**
     * Obtiene la lista de mensajes del chat.
     *
     * @return Una lista de objetos Mensaje que representan los mensajes del
     * chat.
     */
    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    /**
     * Establece la lista de mensajes del chat.
     *
     * @param mensajes Una lista de objetos Mensaje que representan los nuevos
     * mensajes del chat.
     */
    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    /**
     * Obtiene el identificador único del chat.
     *
     * @return Un objeto ObjectId que representa el identificador único del
     * chat.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del chat.
     *
     * @param id Un objeto ObjectId que representa el nuevo identificador único
     * del chat.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha de creación del chat.
     *
     * @return Un objeto Date que representa la fecha de creación del chat.
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Establece la fecha de creación del chat.
     *
     * @param fechaCreacion Un objeto Date que representa la nueva fecha de
     * creación del chat.
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
