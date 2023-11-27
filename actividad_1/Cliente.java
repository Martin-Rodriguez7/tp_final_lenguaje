package actividad_1;

// import java.util.ArrayList;

public class Cliente {
    private Agencia agencia;

    public Cliente(Agencia agencia) {
        this.agencia = agencia;
    }

    public void accederAlojamientoPorPosicion(int pos) {
        if (pos >= 0 && pos < agencia.cantAlojamientos()) {
            Alojamiento alojamiento = agencia.recuperarAlojamiento(pos);
            System.out.println("Accediendo a alojamiento en posición " + pos + ": " + alojamiento);
        } else {
            System.out.println("Posición no válida");
        }
    }
}