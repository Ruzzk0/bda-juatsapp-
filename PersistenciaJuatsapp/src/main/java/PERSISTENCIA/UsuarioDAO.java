package PERSISTENCIA;

import DOMINIO.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class UsuarioDAO {

    private final MongoCollection<Document> collection;

    public UsuarioDAO(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public boolean insertar(Usuario usuario) {
        Document doc = new Document("nombre", usuario.getNombre())
                .append("domicilio", usuario.getDomicilio())
                .append("telefono", usuario.getTelefono())
                .append("usuario", usuario.getUsuario())
                .append("contrasena", usuario.getContra()); 

        try {
            collection.insertOne(doc);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificar(Usuario usuario) {
        try {
            collection.updateOne(Filters.eq("usuario", usuario.getUsuario()), Updates.set("contrasena", usuario.getContra()));
            collection.updateOne(Filters.eq("usuario", usuario.getUsuario()), Updates.set("nombre", usuario.getNombre()));
            collection.updateOne(Filters.eq("usuario", usuario.getUsuario()), Updates.set("domicilio", usuario.getDomicilio()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(String usuario) {
        try {
            collection.deleteOne(Filters.eq("usuario", usuario));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Usuario obtener(String usuario) {
        Document doc = collection.find(Filters.eq("usuario", usuario)).first();
        if (doc != null) {
            return new Usuario(doc.getString("nombre"), doc.getString("domicilio"), doc.getString("telefono"), doc.getString("usuario"), doc.getString("contrasena")); // Mantengo el nombre de la variable como Contrasena
        } else {
            return null;
        }
    }
}
