package Conexion;

import DOMINIO.Usuario;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

public class MongoDBConexion {

    static String cadenaConexion = "mongodb://localhost:27017";
    static String nombreBD = "Juatsapp";
    static String nombreCol = "Usuarios";

    // Método estático para obtener la colección
    public static MongoCollection<Document> obtenerColeccion() {
        // Crear la conexión con Mongo
        com.mongodb.client.MongoClient mongoClient = MongoClients.create(cadenaConexion); // Establecer la conexión
        // Crear la conexión con la bd
        MongoDatabase database = mongoClient.getDatabase(nombreBD);
        // Crear la conexión con la colección
        return database.getCollection(nombreCol);
    }

   public static Usuario obtenerUsuario(String usuario) {
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


   public static boolean actualizarUsuario(Usuario usuario, MongoDBConexion conexion) {
    // Obtener la colección utilizando el método estático
    MongoCollection<Document> collection = obtenerColeccion();
    // Definir el filtro para encontrar el documento a actualizar
    Document filter = new Document("usuario", usuario.getUsuario());
    // Definir la operación de actualización
    Document update = new Document("$set", new Document()
            .append("nombre", usuario.getNombre())
            .append("Domicilio", usuario.getDomicilio())
            .append("telefono", usuario.getTelefono())
            .append("Contra", usuario.getContra())
    );
    // Ejecutar la operación de actualización en la colección obtenida
    UpdateResult result = collection.updateOne(filter, update);
    // Verificar si se modificó al menos un documento
    return result.getModifiedCount() > 0;
}
}
