package PERSISTENCIA;

import Conexion.IMongoDBConexion;
import Conexion.MongoDBConexion;
import DOMINIO.Usuario;
import EXCEPCIONES.PersistenciaException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.UpdateResult;
import daos.interfaces.IUsuarioDAO;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean modificar(Usuario usuario) throws PersistenciaException{
        try {
            MongoCollection<Usuario> coleccion = conexion.obtenerColeccion();
            UpdateResult result = coleccion.replaceOne(eq("_id", usuario.getId()), usuario);

            if (result.getModifiedCount() == 1) {
                return true;
            } else {
                throw new PersistenciaException("No se pudo actualizar el cliente");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar cliente: " + e.getMessage());
        }
    }

    @Override
    public boolean eliminar(String usuario) {
        try {
            MongoCollection<Usuario> coleccion = conexion.obtenerColeccion();
            coleccion.deleteOne(Filters.eq("usuario", usuario));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Usuario obtener(String usuario) throws PersistenciaException {
        try {
            MongoCollection<Usuario> coleccion = conexion.obtenerColeccion();
            Usuario resultado = coleccion.find(eq("usuario", usuario)).first();
            if (resultado != null) {
                return resultado;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al encontrar cliente por usuario: " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> consultarTodos() throws PersistenciaException {
        try {
            MongoCollection<Usuario> coleccion = conexion.obtenerColeccion();
            FindIterable<Usuario> usuariosConsulta = coleccion.find();
            List<Usuario> listaClientes = new ArrayList<>();

            for (Usuario usauario : usuariosConsulta) {
                listaClientes.add(usauario);
            }

            return listaClientes;
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar usuarios: " + e.getMessage());
        }
    }
}
