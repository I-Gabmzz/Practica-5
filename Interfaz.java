import java.util.Scanner;

public class Interfaz {

    public Interfaz() {
        Scanner scanner = new Scanner(System.in);
        solicitarJugadores(scanner);
        solicitarNombreDeJugador(scanner, 1);
    }

    public static void main(String[] args) {
        System.out.println("\n========================");
        System.out.println("\n| MAGO DE LAS PALABRAS |\n");
        System.out.println("========================\n");
        Interfaz interfaz = new Interfaz();
    }

    public int solicitarJugadores(Scanner scanner) {
        int numeroDeJugadores;
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nIngrese el numero de jugadores (2 - 4): ");
            numeroDeJugadores = scanner.nextInt();
            if (numeroDeJugadores >= 2 && numeroDeJugadores <= 4) {
                return numeroDeJugadores;
            } else {
                System.out.println("El numero de jugadores debe de ser entre 2 y 4.");
            }
        }
    }

    public String solicitarNombreDeJugador(Scanner scanner, int numeroDeJugadores) {
        System.out.println("\nIngrese el nombre del jugador " + numeroDeJugadores + ": ");
        String nombre = scanner.next();
        return nombre;
    }




}
