package actividad_2;

public class Sombrilla {
    static final int costoBase = 200;
    static final int extras = 100;

    protected int numero;
    protected int dias;
    protected boolean estacionamiento;

    public Sombrilla(int n, int d, boolean e) {
        this.numero = n;
        this.dias = d;
        this.estacionamiento = e;
    }

    public double costo() {
        if (estacionamiento) {
            return dias * (costoBase + extras);
        } else {
            if (dias > 0) {
                return dias * costoBase;
            } else {
                return 0;
            }

        }
    }

    public boolean tieneEstacionamiento() {
        return estacionamiento;
    }

    public int obtenerNum() {
        return numero;
    }

    public int obtenerDias() {
        return dias;
    }
}