package actividad_1;

// import java.util.ArrayList;

public class Alojamiento {

    private int codigo;
    private String domicilio;
    private boolean TV;

    public Alojamiento(int c, String d, boolean t) {
        this.codigo = c;
        this.domicilio = d;
        this.TV = t;
    }

    public void establecerDomicilio(String d) {
        domicilio = d;
    }

    public void establecerTV(boolean t) {
        TV = t;
    }

    public int obtenerCodigo() {
        return codigo;
    }

    public String obtenerDomicilio() {
        return domicilio;
    }

    public boolean tieneTV() {
        return TV;
    }

    public String toString() {
        return "Código: " + codigo + ", Domicilio: " + domicilio + ", TV: " + (TV ? "Sí" : "No");
    }

    public boolean igualCodigo(Alojamiento a) {
        return this.codigo == a.codigo;
    }

    public int estrellas() {
        return tieneTV() ? 2 : 1;
    }

}
