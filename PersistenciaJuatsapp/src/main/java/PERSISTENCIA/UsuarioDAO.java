package PERSISTENCIA;

import Conexion.IMongoDBConexion;
import Conexion.MongoDBConexion;
import DOMINIO.Usuario;
import EXCEPCIONES.PersistenciaException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import daos.interfaces.IUsuarioDAO;
import org.bson.Document;

public class UsuarioDAO implements IUsuarioDAO{

    private IMongoDBConexion conexion;

    public UsuarioDAO() {
        conexion = new MongoDBConexion("Usuarios", Usuario.class);
    }

    @Override
    public boolean insertar(Usuario usuario) throws PersistenciaException{
        try {
            MongoCollection<Usuario> coleccion = conexion.obtenerColeccion();
            coleccion.insertOne(usuario);
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo agregar al usuario", e);
        }
    }

    public boolean modificar(Usuario usuario) throws PersistenciaException{
        try {
            MongoCollection<Usuario> coleccion = conexion.obtenerColeccion();
            UpdateResult result = coleccion.replaceOne(eq("_id", usuario.getId()), usuario);

            if (result.getModifiedCount() == 1) {
                return cliente;
            } else {
                throw new PersistenciaException("No se pudo actualizar el cliente");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar cliente: " + e.getMessage());
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
        // Obtener la colección utilizando el método estático
        MongoCollection<Document> collection = obtenerColeccion();
        // Realizar la consulta en la colección obtenida
        Document document = collection.find(new Document("usuario", usuario)).first();
        if (document != null) {
            return new Usuario(
                    document.getString("nombre"),
                    document.getString("Domicilio"),
                    document.getString("telefono"),
                    document.getString("usuario"),
                    document.getString("Contra")
            );
        }
        return null;
    }
}
