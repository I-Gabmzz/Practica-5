import java.util.Scanner;
import java.util.Set;

public class Interfaz {

    public Interfaz() {
        Scanner scanner = new Scanner(System.in);
        solicitarJugadores(scanner);
        solicitarNombreDeJugador(scanner, 1);
        solicitarModoDeJuego(scanner);
    }

    public static void main(String[] args) {
        System.out.println("\n        ========================");
        System.out.println("\n        | MAGO DE LAS PALABRAS |\n");
        System.out.println("        ========================\n");
        Interfaz interfaz = new Interfaz();
    }

    public int solicitarJugadores(Scanner scanner) {
        int numeroDeJugadores;
        scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n * Ingrese el numero de jugadores (2 - 4): ");
            numeroDeJugadores = scanner.nextInt();
            if (numeroDeJugadores >= 2 && numeroDeJugadores <= 4) {
                return numeroDeJugadores;
            } else {
                System.out.println("El numero de jugadores debe de ser entre 2 y 4.");
            }
        }
    }

    public String solicitarNombreDeJugador(Scanner scanner, int numeroDeJugadores) {
        System.out.print("\n * Ingrese el nombre del jugador " + numeroDeJugadores + ": ");
        String nombre = scanner.next();
        return nombre;
    }

    public boolean solicitarModoDeJuego(Scanner scanner) {
        int opcModoDeJuego;

        while (true) {
            System.out.println("\n * Ingrese el numero del modo de juego: ");
            System.out.println("\n  1 -> Normal");
            System.out.println("  2 -> Experto\n");
            opcModoDeJuego = scanner.nextInt();
            if (opcModoDeJuego == 1 || opcModoDeJuego == 2) {
                break;
            } else {
                System.out.println("Modo fuera del rango, unicamente ingresa 1 o 2.");
            }
        }
        return false;
    }

    public void indicarTurnoDeJugador(Jugador player, Set<Character> letras) {
        System.out.print("\n" + player.getNombre() + " (" + player.getPuntuacionTotal() + " puntos) > ");
    }


}
