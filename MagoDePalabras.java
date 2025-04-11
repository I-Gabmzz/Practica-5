//Se importan las librerias necesarias para la clase
import java.io.*;
import java.util.*;
//Se crea la clase MagoDePalabras
public class MagoDePalabras {
    //Se declaran los atributos de la clase
    private Random random;
    private HashMap<String, Integer> diccionario;
    private HashMap<String, Integer> puntuaciones;
    private HashSet<String> palabrasUsadas;
    private HashSet<Character> letrasEnJuego;

    //Se declara el constructor de la clase
    public MagoDePalabras() {
        random = new Random();
        diccionario = new HashMap<>();
        puntuaciones = new HashMap<>();
        palabrasUsadas = new HashSet<>();
        letrasEnJuego = new HashSet<>();
        cargarArchivo("C:\\Users\\14321\\IdeaProjects\\Practica-5\\palabras.txt");
    }

    //Metodo para cargar el archivo de las palabras
    public void cargarArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String palabra = linea.toLowerCase();
                diccionario.put(palabra, calcularPuntos(palabra));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    //Metodo para calcular los puntos de la palabra
    public int calcularPuntos(String palabra) {
        int puntos = 0;
        String vocales = "aeiouáéíóú";
        for(int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if(vocales.indexOf(letra) != -1) {
                puntos += 5;
            }else{
                puntos += 3;
            }
        }
        return puntos;
    }

}
