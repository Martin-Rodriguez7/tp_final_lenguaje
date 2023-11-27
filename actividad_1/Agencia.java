package actividad_1;

// import actividad_1.Alojamiento;

import java.util.ArrayList;

public class Agencia {
    private ArrayList<Alojamiento> alojamientosAgencia;

    public Agencia(int n) {
        alojamientosAgencia = new ArrayList<>(n);
    }

    public void insertarAlojamiento(Alojamiento a, int p) {
        alojamientosAgencia.add(p, a);
    }

    public void eliminarAlojamiento(int pos) {
        alojamientosAgencia.remove(pos);
    }

    public void eliminarAlojamiento(Alojamiento a) {
        alojamientosAgencia.remove(a);
    }

    public int cantAlojamientos() {
        return alojamientosAgencia.size();
    }

    public Alojamiento recuperarAlojamiento(int pos) {
        return alojamientosAgencia.get(pos);
    }

    public int recuperarPosicion(Alojamiento a) {
        return alojamientosAgencia.indexOf(a);
    }

    public Alojamiento estaAlojamiento(int c) {
        for (Alojamiento a : alojamientosAgencia) {
            if (a.obtenerCodigo() == c) {
                return a;
            }
        }
        return null;
    }

    public boolean estaLlena() {
        return !alojamientosAgencia.isEmpty();
    }

    public boolean hayAlojamientos() {
        return !alojamientosAgencia.isEmpty();
    }

    public Agencia masEstrellas(int cantEst) {
        Agencia nuevaAgencia = new Agencia(alojamientosAgencia.size());
        for (Alojamiento a : alojamientosAgencia) {
            if (a.estrellas() > cantEst) {
                nuevaAgencia.insertarAlojamiento(a, nuevaAgencia.cantAlojamientos());
            }
        }
        return nuevaAgencia;
    }
}