/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXCEPCIONES;

/**
 * La clase PersistenciaException es una excepción personalizada que se utiliza
 * para indicar errores relacionados con la persistencia de datos en la capa de
 * acceso a datos (DAO). Esta excepción puede ser lanzada cuando ocurren
 * problemas al interactuar con la base de datos.
 *
 * @author Paco
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor por defecto de PersistenciaException. Crea una nueva
     * instancia de PersistenciaException sin un mensaje de detalle.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor de PersistenciaException que acepta un mensaje de error. Crea
     * una nueva instancia de PersistenciaException con el mensaje de detalle
     * especificado.
     *
     * @param message El mensaje de detalle que explica la razón de la
     * excepción.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor de PersistenciaException que acepta un mensaje de error y una
     * causa. Crea una nueva instancia de PersistenciaException con el mensaje
     * de detalle especificado y la causa subyacente.
     *
     * @param message El mensaje de detalle que explica la razón de la
     * excepción.
     * @param cause La causa subyacente (una excepción que causó esta
     * excepción).
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

}
