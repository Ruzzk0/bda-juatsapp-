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

/**
 * La clase UsuarioDAO implementa la interfaz IUsuarioDAO y proporciona la
 * funcionalidad necesaria para realizar operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar) en la base de datos MongoDB para objetos de tipo
 * Usuario.
 *
 * Esta clase utiliza una conexión a MongoDB a través de la interfaz
 * IMongoDBConexion, la cual se inicializa en el constructor de la clase.
 *
 * Los métodos de esta clase pueden lanzar una PersistenciaException en caso de
 * que ocurra algún problema durante la interacción con la base de datos.
 *
 * @see IUsuarioDAO
 * @see IMongoDBConexion
 * @see Usuario
 * @see PersistenciaException
 * @see MongoDBConexion
 */
public class UsuarioDAO implements IUsuarioDAO {

    private IMongoDBConexion conexion;

    /**
     * Constructor de la clase UsuarioDAO. Inicializa la conexión a la base de
     * datos MongoDB para la colección "Usuarios".
     */
    public UsuarioDAO() {
        conexion = new MongoDBConexion("Usuarios", Usuario.class);
    }

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param usuario El objeto Usuario que se va a insertar en la base de
     * datos.
     * @return true si el usuario fue insertado exitosamente.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    @Override
    public boolean insertar(Usuario usuario) throws PersistenciaException {
        try {
            MongoCollection<Usuario> coleccion = conexion.obtenerColeccion();
            coleccion.insertOne(usuario);
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo agregar al usuario", e);
        }
    }

    /**
     * Modifica los datos de un usuario existente en la base de datos.
     *
     * @param usuario El objeto Usuario con los datos actualizados.
     * @return true si el usuario fue modificado exitosamente.
     * @throws PersistenciaException Si ocurre un error durante la modificación.
     */
    @Override
    public boolean modificar(Usuario usuario) throws PersistenciaException {
        try {
            MongoCollection<Usuario> coleccion = conexion.obtenerColeccion();
            UpdateResult result = coleccion.replaceOne(eq("_id", usuario.getId()), usuario);

            if (result.getModifiedCount() == 1) {
                return true;
            } else {
                throw new PersistenciaException("No se pudo actualizar el usuario");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar usuario: " + e.getMessage());
        }
    }

    /**
     * Elimina un usuario de la base de datos.
     *
     * @param usuario El nombre de usuario del usuario a eliminar.
     * @return true si el usuario fue eliminado exitosamente.
     */
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

    /**
     * Obtiene un usuario de la base de datos por su nombre de usuario.
     *
     * @param usuario El nombre de usuario del usuario a obtener.
     * @return El objeto Usuario correspondiente al nombre de usuario
     * especificado, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la obtención.
     */
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
            throw new PersistenciaException("Error al encontrar usuario por nombre: " + e.getMessage());
        }
    }

    /**
     * Consulta todos los usuarios en la base de datos.
     *
     * @return Una lista de objetos Usuario que contiene todos los usuarios en
     * la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Usuario> consultarTodos() throws PersistenciaException {
        try {
            MongoCollection<Usuario> coleccion = conexion.obtenerColeccion();
            FindIterable<Usuario> usuariosConsulta = coleccion.find();
            List<Usuario> listaUsuarios = new ArrayList<>();

            for (Usuario usuario : usuariosConsulta) {
                listaUsuarios.add(usuario);
            }

            return listaUsuarios;
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar usuarios: " + e.getMessage());
        }
    }
}
