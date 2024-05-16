package EXCEPCIONES;

import DOMINIO.Usuario;
import PERSISTENCIA.UsuarioDAO;

public class UsuarioLogic {

    private static final UsuarioDAO usuarioDAO;
    private static Usuario usuarioActual;

    static {
        usuarioDAO = new UsuarioDAO();
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

    public static boolean insertar(Usuario usuario) throws PersistenciaException {
        // Encriptar la contraseña antes de almacenarla
//    String contrasenaEncriptada = BCrypt.hashpw(usuario.getContra(), BCrypt.gensalt());
//    usuario.setContra(contrasenaEncriptada);
        return usuarioDAO.insertar(usuario);
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
