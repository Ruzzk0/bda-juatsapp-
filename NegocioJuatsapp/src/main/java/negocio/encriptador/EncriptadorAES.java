package negocio.encriptador;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Clase que proporciona funcionalidades de encriptación y desencriptación
 * utilizando el algoritmo AES (Advanced Encryption Standard). Esta clase
 * utiliza una clave secreta para cifrar y descifrar datos. La clave secreta
 * debe ser proporcionada al constructor de la clase o puede ser establecida
 * internamente.
 *
 * @author Paco
 */
public class EncriptadorAES {

    // La clave secreta para encriptar y desencriptar los datos
    private final String CLAVESECRETA;

    /**
     * Constructor que permite establecer la clave secreta para encriptar y
     * desencriptar datos.
     */
    public EncriptadorAES() {
        CLAVESECRETA = "";
    }

    /**
     * Crea la clave de encriptación a partir de la clave proporcionada.
     *
     * @param clave La clave que se utilizará para encriptar.
     * @return La clave de encriptación generada.
     * @throws UnsupportedEncodingException Si el conjunto de caracteres
     * especificado no es compatible.
     * @throws NoSuchAlgorithmException Si el algoritmo de cifrado especificado
     * no está disponible.
     */
    private SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        // Convertir la clave en bytes utilizando UTF-8
        byte[] claveEncriptacion = clave.getBytes("UTF-8");

        // Aplicar el algoritmo SHA-1 para generar una clave de 128 bits
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        claveEncriptacion = sha.digest(claveEncriptacion);
        claveEncriptacion = Arrays.copyOf(claveEncriptacion, 16);

        // Crear y retornar la clave secreta utilizando AES
        SecretKeySpec secretKey = new SecretKeySpec(claveEncriptacion, "AES");
        return secretKey;
    }

    /**
     * Encripta los datos utilizando la clave secreta.
     *
     * @param datos Los datos a encriptar.
     * @return La información encriptada como una cadena de texto en formato
     * Base64.
     * @throws UnsupportedEncodingException Si el conjunto de caracteres
     * especificado no es compatible.
     * @throws NoSuchAlgorithmException Si el algoritmo de cifrado especificado
     * no está disponible.
     * @throws InvalidKeyException Si la clave proporcionada no es válida.
     * @throws NoSuchPaddingException Si el tipo de relleno especificado no está
     * disponible.
     * @throws IllegalBlockSizeException Si se produce un bloque de tamaño
     * ilegal para el algoritmo de cifrado y el modo de cifrado.
     * @throws BadPaddingException Si se detecta un relleno incorrecto en los
     * datos durante la desencriptación.
     */
    public String encriptar(String datos) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        // Crear la clave secreta
        SecretKeySpec secretKey = this.crearClave(CLAVESECRETA);

        // Inicializar el cifrador en modo de encriptación
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Convertir los datos a bytes utilizando UTF-8
        byte[] datosEncriptar = datos.getBytes("UTF-8");

        // Encriptar los datos y convertirlos a Base64
        byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
        String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);

        return encriptado;
    }

    /**
     * Desencripta los datos utilizando la clave secreta.
     *
     * @param datosEncriptados Los datos encriptados como una cadena de texto en
     * formato Base64.
     * @return La información desencriptada.
     * @throws UnsupportedEncodingException Si el conjunto de caracteres
     * especificado no es compatible.
     * @throws NoSuchAlgorithmException Si el algoritmo de cifrado especificado
     * no está disponible.
     * @throws InvalidKeyException Si la clave proporcionada no es válida.
     * @throws NoSuchPaddingException Si el tipo de relleno especificado no está
     * disponible.
     * @throws IllegalBlockSizeException Si se produce un bloque de tamaño
     * ilegal para el algoritmo de cifrado y el modo de cifrado.
     * @throws BadPaddingException Si se detecta un relleno incorrecto en los
     * datos durante la desencriptación.
     */
    public String desencriptar(String datosEncriptados) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        // Crear la clave secreta
        SecretKeySpec secretKey = this.crearClave(CLAVESECRETA);

        // Inicializar el cifrador en modo de desencriptación
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Decodificar los datos Base64
        byte[] bytesEncriptados = Base64.getDecoder().decode(datosEncriptados);

        // Desencriptar los datos y convertirlos a cadena de texto
        byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
        String datos = new String(datosDesencriptados, "UTF-8");

        return datos;
    }
}
