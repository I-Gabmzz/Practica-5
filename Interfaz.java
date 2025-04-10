import java.util.Scanner;

public class Interfaz {

    public static void main(String[] args) {
        System.out.println("\n========================");
        System.out.println("\n| MAGO DE LAS PALABRAS |\n");
        System.out.println("========================\n");
    }

    public int solicitarJugadores() {
        int numeroDeJugadores;
        Scanner scanner = new Scanner(System.in);
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
}
