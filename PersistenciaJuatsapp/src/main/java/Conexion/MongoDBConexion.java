

package Conexion;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConexion {
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> coleccionUsuarios;

    public static void conectar() {
    

    }
}
