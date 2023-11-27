import actividad_1.*;
// import actividad_1.Cabana;
// import actividad_1.Agencia;
// import actividad_1.HabitacionHotel;

import java.util.Scanner;

public class tester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Agencia agencia = new Agencia(5);

        HabitacionHotel habitacion1 = new HabitacionHotel(1, "Calle A", true, 100.0);
        Cabana cabana1 = new Cabana(2, "Calle B", false, 150.0, 2, 2);

        agencia.insertarAlojamiento(habitacion1, 0);
        agencia.insertarAlojamiento(cabana1, 1);

        System.out.println("Agencia después de la inserción:");
        mostrarInformacionAgencia(agencia);

        System.out.println("Estrellas de habitacion1: " + habitacion1.estrellas()); // Debería imprimir 2
        System.out.println("Estrellas de cabana1: " + cabana1.estrellas()); // Debería imprimir 1

        // Probar recuperarPosicion()
        System.out.println("Posición de cabana1 en agencia: " + agencia.recuperarPosicion(cabana1));

        // Probar estaAlojamiento() en Agencia
        System.out.println("Alojamiento con código 2 en agencia: " + agencia.estaAlojamiento(2));

        // Probar masEstrellas() en Agencia
        Agencia agenciaMasEstrellas = agencia.masEstrellas(1);
        System.out.println("Agencia con más de 1 estrella: ");
        mostrarInformacionAgencia(agenciaMasEstrellas);

        // Probar hayAlojamientos() en Agencia
        System.out.println("¿Hay alojamientos en la agencia? " + (agencia.hayAlojamientos() ? "si" : "no"));
        // Debería imprimir true

    }

    private static void mostrarInformacionAgencia(Agencia agencia) {
        System.out.println("Cantidad de alojamientos: " + agencia.cantAlojamientos());
        for (int i = 0; i < agencia.cantAlojamientos(); i++) {
            System.out.println("Posición " + i + ": " + agencia.recuperarAlojamiento(i));
        }
        System.out.println("Está llena: " + (agencia.estaLlena() ? "si" : "no"));
        System.out.println("Hay alojamientos: " + (agencia.hayAlojamientos() ? "si" : "no"));
        System.out.println();
    }
}
