import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Letra> letras;
    private int puntuacionRonda ;
    private int puntuacionTotal ;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.letras = new ArrayList<>();
        this.puntuacionRonda = 0;
        this.puntuacionTotal = 0;
    }

    public int getPuntuacionRonda() {
        return puntuacionRonda;
    }
    public void setPuntuacionRonda(int puntuacionRonda) {
        this.puntuacionRonda = puntuacionRonda;
    }
    public int getPuntuacionTotal() {
        return puntuacionTotal;
    }
    public void setPuntuacionTotal(int puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }
}
