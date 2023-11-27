import actividad_1.*;
// import actividad_1.Cabana;
// import actividad_1.Agencia;
// import actividad_1.HabitacionHotel;
import java.util.Scanner;

public class testerac1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una agencia con capacidad para 5 alojamientos
        Agencia agencia = new Agencia(5);

        // Crear algunos alojamientos
        HabitacionHotel habitacion1 = new HabitacionHotel(1, "Calle A", true, 100.0);
        Cabana cabana1 = new Cabana(2, "Calle B", false, 150.0, 2, 2);

        // Insertar alojamientos en la agencia
        agencia.insertarAlojamiento(habitacion1, 0);
        agencia.insertarAlojamiento(cabana1, 1);

        System.out.println("Agencia después de la inserción:");
        mostrarInformacionAgencia(agencia);

        // Consultar información de un alojamiento
        System.out.println("Información de la habitación en posición 0: " + agencia.recuperarAlojamiento(0));

        // Eliminar un alojamiento por posición
        agencia.eliminarAlojamiento(0);

        System.out.println("Agencia después de la eliminación:");
        mostrarInformacionAgencia(agencia);

        // Crear más alojamientos
        Cabana cabana2 = new Cabana(3, "Calle C", true, 200.0, 3, 2);
        HabitacionHotel habitacion2 = new HabitacionHotel(4, "Calle D", false, 120.0);
        // Insertar más alojamientos en la agencia
        agencia.insertarAlojamiento(cabana2, 2);
        agencia.insertarAlojamiento(habitacion2, 3);

        System.out.println("Agencia después de la inserción de más alojamientos:");
        mostrarInformacionAgencia(agencia);

        // Filtrar alojamientos por estrellas
        System.out.print("Ingrese la cantidad mínima de estrellas para filtrar alojamientos: ");
        int cantEstrellas = scanner.nextInt();

        Agencia agenciaFiltrada = agencia.masEstrellas(cantEstrellas);
        System.out.println("Agencia filtrada con más de " + cantEstrellas + " estrella(s):");
        mostrarInformacionAgencia(agenciaFiltrada);
    }

    private static void mostrarInformacionAgencia(Agencia agencia) {
        System.out.println("Cantidad de alojamientos: " + agencia.cantAlojamientos());
        for (int i = 0; i < agencia.cantAlojamientos(); i++) {
            System.out.println("Posición " + i + ": " + agencia.recuperarAlojamiento(i));
        }
        System.out.println("Está llena: " + agencia.estaLlena());
        System.out.println("Hay alojamientos: " + agencia.hayAlojamientos());
        System.out.println();
    }
}
