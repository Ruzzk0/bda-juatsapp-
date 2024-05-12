
package Conexion;


import DOMINIO.Usuario;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class MongoDBConexion {
//    private static final String MONGO_URI = "mongodb://localhost:27017";
//    private static final String DATABASE_NAME = "myDatabase";
//    private static final String COLLECTION_NAME = "usuarios";
//
//    private MongoClient mongoClient;
//    private MongoDatabase database;
//    private MongoCollection<Document> collection;
//
//    public MongoDBConexion() {
//        MongoClientURI uri = new MongoClientURI(MONGO_URI);
//       // mongoClient = new MongoClient(uri) {};
//        database = mongoClient.getDatabase(DATABASE_NAME);
//        collection = database.getCollection(COLLECTION_NAME);
//    }
//
//public Usuario obtenerUsuario(String usuario) {
//    Document document = collection.find(new Document("usuario", usuario)).first();
//    if (document != null) {
//        return new Usuario(
//            document.getString("nombre"),
//            document.getString("Domicilio"),
//            document.getString("telefono"),
//            document.getString("usuario"),
//            document.getString("Contra")
//        );
//    }
//    return null;
//}

}