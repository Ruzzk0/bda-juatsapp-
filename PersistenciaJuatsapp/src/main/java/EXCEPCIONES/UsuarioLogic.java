package EXCEPCIONES;

import Conexion.MongoDBConexion;
import DOMINIO.Usuario;
import PERSISTENCIA.UsuarioDAO;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class UsuarioLogic {
    
     private static final UsuarioDAO usuarioDAO; 
    private static Usuario usuarioActual;
    static {
        // Obtener la colección de MongoDB utilizando el método estático de la clase de conexión
        MongoCollection<Document> collection = MongoDBConexion.obtenerColeccion();
        // Pasar la colección a UsuarioDAO
        usuarioDAO = new UsuarioDAO(collection);
    }
    
    
    public static boolean autentificar(String usuario, String contra) {
        Usuario usuarioConsulta = usuarioDAO.obtener(usuario); // Utilizamos el método obtener del UsuarioDAO
        if (usuarioConsulta != null && usuarioConsulta.getContra().equals(contra)) {
            usuarioActual = usuarioConsulta; // Guardar el usuario actual después de la autenticación exitosa
            return true;
        } else {
            return false;
        }
    }

    public static boolean insertar(Usuario usuario) {
        return usuarioDAO.insertar(usuario); // Utilizamos el método insertar del UsuarioDAO
    }

    public static boolean modificar(Usuario usuario) {
        return usuarioDAO.modificar(usuario); // Utilizamos el método modificar del UsuarioDAO
    }

    public static boolean eliminar(String usuario) {
        return usuarioDAO.eliminar(usuario); // Utilizamos el método eliminar del UsuarioDAO
    }

    public static Usuario obtener(String usuario) {
        return usuarioDAO.obtener(usuario); // Utilizamos el método obtener del UsuarioDAO
    }

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }
}
