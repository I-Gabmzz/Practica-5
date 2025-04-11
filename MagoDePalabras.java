//Se importan las librerias necesarias para la clase
import java.io.*;
import java.util.*;

//Se crea la clase MagoDePalabras
public class MagoDePalabras {
    //Se declaran los atributos de la clase
    private static volatile boolean tiempoAgotado = false;
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

    //Metodo para generar letras aleatorias
    public HashSet<Character> generarLetrasAleatorias(){
        HashSet<Character> letras = new HashSet<>();
        String vocales = "aeiouáéíóú";
        String consonantes = "bcdfghjklmnpqrstvwxyz";
        for(int i = 0; i < 3; i++) {
            char letra = vocales.charAt(random.nextInt(vocales.length()));
            letras.add(letra);
        }
        for(int i = 0; i < 7; i++) {
            char letra = consonantes.charAt(random.nextInt(consonantes.length()));
            letras.add(letra);
        }
        return letras;
    }

    //Metodo para agregar letras en el juego
    public void agregarLetrasEnJuego(HashSet<Character> letrasRonda) {
        letrasEnJuego.clear();
        letrasEnJuego.addAll(letrasRonda);
    }

    //Metodo para saber si ya se uso una palabra
    public boolean yaSeUsoEsaPalabra(String palabra) {
        return palabrasUsadas.contains(palabra.toUpperCase());
    }

    //Metodo para saber si la palabra ingresada tiene letras validas
    public boolean tieneLetrasValidas(String palabra) {
        if (palabra.length() > letrasEnJuego.size()) {
            return false;
        }
        Map<Character, Integer> frecuencias = new HashMap<>();
        for (Character letra : letrasEnJuego) {
            frecuencias.put(letra, frecuencias.getOrDefault(letra, 0) + 1);
        }
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            Integer count = frecuencias.get(letra);

            if (count == null || count <= 0) {
                return false;
            }
            frecuencias.put(letra, count - 1);
        }
        return true;
    }

    //Metodo para agregar la palabra a las palabras usadas
    public void agregarPalabrasUsadas(String palabra) {
        palabrasUsadas.add(palabra.toUpperCase());
    }
}
