import java.util.Scanner;
import java.util.Set;

public class Interfaz {
    final String negrita = "\u001B[1m";

    public Interfaz() {
        Scanner scanner = new Scanner(System.in);
        solicitarJugadores(scanner);
        solicitarNombreDeJugador(scanner, 1);
        solicitarModoDeJuego(scanner);
    }

    public static void main(String[] args) {
        final String reset = "\u001B[0m";
        final String MORADO = "\u001B[35m";
        final String AMARILLO = "\u001B[33m";

        String[] titulo = {
            "\n    ███╗   ███╗  █████╗   ██████╗   ██████╗      ██████╗  ███████╗",
            "    ████╗ ████║ ██╔══██╗ ██╔════╝  ██╔═══██╗     ██╔══██╗ ██╔════╝",
            "    ██╔████╔██║ ███████║ ██║  ███╗ ██║   ██║     ██║  ██║ █████╗  ",
            "    ██║╚██╔╝██║ ██╔══██║ ██║   ██║ ██║   ██║     ██║  ██║ ██╔══╝  ",
            "    ██║ ╚═╝ ██║ ██║  ██║ ╚██████╔╝ ╚██████╔╝     ██████╔╝ ███████╗",
            "    ╚═╝     ╚═╝ ╚═╝  ╚═╝  ╚═════╝   ╚═════╝      ╚═════╝  ╚══════╝",
            "                                                          ",
            "██████╗   █████╗  ██╗       █████╗  ██████╗  ██████╗   █████╗  ███████╗",
            "██╔══██╗ ██╔══██╗ ██║      ██╔══██╗ ██╔══██╗ ██╔══██╗ ██╔══██╗ ██╔════╝",
            "██████╔╝ ███████║ ██║      ███████║ ██████╔╝ ██████╔╝ ███████║ ███████╗",
            "██╔═══╝  ██╔══██║ ██║      ██╔══██║ ██╔══██╗ ██╔══██╗ ██╔══██║ ╚════██║",
            "██║      ██║  ██║ ███████╗ ██║  ██║ ██████╔╝ ██║  ██║ ██║  ██║ ███████║",
            "╚═╝      ╚═╝  ╚═╝ ╚══════╝ ╚═╝  ╚═╝ ╚═════╝  ╚═╝  ╚═╝ ╚═╝  ╚═╝ ╚══════╝"
        };

            for (int i = 0; i < 6; i++) {
                System.out.println(MORADO + titulo[i] + reset);
            }

            System.out.println(titulo[6]);

            for (int i = 7; i < titulo.length; i++) {
                System.out.println(AMARILLO + titulo[i] + reset);
            }
        Interfaz interfaz = new Interfaz();
    }

    public int solicitarJugadores(Scanner scanner) {
        int numeroDeJugadores;
        scanner = new Scanner(System.in);
        final String reset = "\u001B[0m";

        while (true) {
            System.out.print(negrita + "\n * Ingrese el numero de jugadores (2 - 4): " + reset);
            numeroDeJugadores = scanner.nextInt();
            if (numeroDeJugadores >= 2 && numeroDeJugadores <= 4) {
                return numeroDeJugadores;
            } else {
                System.out.println("El numero de jugadores debe de ser entre 2 y 4.");
            }
        }
    }

    public String solicitarNombreDeJugador(Scanner scanner, int numeroDeJugadores) {
        final String reset = "\u001B[0m";

        System.out.print(negrita + "\n * Ingrese el nombre del jugador " + numeroDeJugadores + ": " + reset);
        String nombre = scanner.next();
        return nombre;
    }

    public boolean solicitarModoDeJuego(Scanner scanner) {
        int opcModoDeJuego;
        final String verde = "\u001B[32m";
        final String rojo = "\u001B[31m";
        final String reset = "\u001B[0m";

        while (true) {
            System.out.println("\n |===| " + negrita + "Modos de Juego" + reset + " |===| ");
            System.out.println("\n  1 -> " + verde + "Normal" + reset);
            System.out.println("  2 -> " + rojo + "Experto" + reset + "\n");
            System.out.print(" * Ingrese el numero del modo de juego deseado: ");
            opcModoDeJuego = scanner.nextInt();
            if (opcModoDeJuego == 1 || opcModoDeJuego == 2) {
                break;
            } else {
                System.out.println("La entrada esta fuera del rango, unicamente ingresa 1 o 2.");
            }
        }
        return false;
    }

    public void indicarTurnoDeJugador(Jugador player) {
        final String reset = "\u001B[0m";
        System.out.print(negrita + "\n" + player.getNombre() + " (" + player.getPuntuacionTotal() + " puntos) > " + reset);
    }

    public void imprimirRonda (int ronda, Set<Character> letras) {
        System.out.println("\n |===| RONDA  " + ronda + " |===|");
        System.out.println("\n\nForma palabras con las siguientes letras: " + letras);
        System.out.print("\n * Escribe una palabra usando solo estas letras o presiona Enter para pasar tu turno.");
    }




}
