/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * La clase NegocioException es una excepción personalizada que se utiliza para
 * manejar errores específicos de la lógica de negocio en la aplicación. Esta
 * clase extiende la clase Exception, permitiendo la creación de excepciones con
 * mensajes y causas específicos.
 *
 * @autor paco
 */
public class NegocioException extends Exception {

    /**
     * Construye una nueva NegocioException sin un mensaje de detalle.
     */
    public NegocioException() {
    }

    /**
     * Construye una nueva NegocioException con el mensaje de detalle
     * especificado.
     *
     * @param message el mensaje de detalle
     */
    public NegocioException(String message) {
        super(message);
    }

    /**
     * Construye una nueva NegocioException con el mensaje de detalle y la causa
     * especificados.
     *
     * @param message el mensaje de detalle
     * @param cause la causa de la excepción (puede ser null)
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }
}
