/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Conexion;

import com.mongodb.client.MongoCollection;

/**
 * Interfaz IConexion
 * <p>
 * Esta interfaz define un método para obtener una colección de MongoDB de un
 * tipo genérico T. Es utilizada para abstraer la conexión a la base de datos y
 * la obtención de las colecciones necesarias.
 *
 * @param <T> el tipo de los documentos que se manejarán en la colección
 */
public interface IMongoDBConexion<T> {

    /**
     * Obtiene la colección de MongoDB para el tipo T.
     * <p>
     * Este método es responsable de devolver la colección específica de MongoDB
     * correspondiente al tipo de documentos T.
     *
     * @return una colección de MongoDB de tipo T
     */
    public MongoCollection<T> obtenerColeccion();
}
