import java.util.ArrayList;

public class Letra {
    private String letra;

    public Letra(String letra) {
        this.letra = letra;
    }
    public String getLetra() {
        return letra;
    }
    public void setLetra(String letra) {
        this.letra = letra;
    }
    public ArrayList<String> darLetras(String letra) {
        ArrayList<String> letras = new ArrayList<String>();
        letras.add(letra);
        return letras;
    }
}
