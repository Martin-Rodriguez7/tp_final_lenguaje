import actividad_2.ColeccionAlquiler;
import actividad_2.Sombrilla;
import actividad_2.SombrillaEspecial;
import java.util.Scanner;

public class tester2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una colección de alquiler
        ColeccionAlquiler coleccion = new ColeccionAlquiler(5);

        int opcion;

        do {

            System.out.println("------ Menú ------");
            System.out.println("1. Insertar sombrilla");
            System.out.println("2. Mostrar costos y total de alquiler de  todas las sombrillas");
            System.out.println("3. Mostrar costos y total de alquiler por numero de sombrilla");
            System.out.println("4. Eliminar sombrilla");
            System.out.println("5. Obtener monto total de alquiler para sombrillas con más de n días");
            System.out.println("0. Salir");
            System.out.println("--------------------");
            System.out.print("Ingrese la opción: ");

            // Leer la opción del usuario
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Insertar sombrilla
                    insertarSombrilla(coleccion, scanner);
                    break;
                case 2:
                    // Mostrar costos y total de alquiler
                    mostrarInformacion(coleccion);
                    break;
                case 3:
                    // Mostrar costos por num sombrilla
                    mostrarCostoPorNumero(coleccion, scanner);
                    break;
                case 4:
                    // Eliminar sombrilla
                    eliminarSombrilla(coleccion, scanner);
                    break;
                case 5:
                    // Obtener monto total de alquiler para sombrillas con más de n días
                    obtenerMontoTotal(coleccion, scanner);
                    break;
                case 0:
                    // Salir del programa
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    // Método para insertar una sombrilla en la colección
    private static void insertarSombrilla(ColeccionAlquiler coleccion, Scanner scanner) {
        System.out.println("¿Qué tipo de sombrilla desea insertar?");
        System.out.println("1. Sombrilla normal (MAX 4 PERSONAS)");
        System.out.println(
                "2. Sombrilla especial (MAX 6 PERSONAS - para 6 personas, servicio de camarero y reposeras extras)");
        System.out.print("Ingrese la opcion correspondiente: ");

        int opcionTipo = scanner.nextInt();
        scanner.nextLine();

        if (coleccion.getEspacioDisponible()) {
            // Verificar si ya existe una sombrilla con el número ingresado
            System.out.print("Ingrese el número de sombrilla: ");
            int numero = scanner.nextInt();

            if (coleccion.existeSombrillaConNumero(numero)) {
                System.out.println("Ya existe una sombrilla con el número ingresado. No se puede repetir.");
            } else {
                // No existe una sombrilla con el mismo número, proceder a la inserción
                if (opcionTipo == 1) {
                    // Insertar sombrilla normal
                    insertarSombrillaNormal(coleccion, scanner, numero);
                } else if (opcionTipo == 2) {
                    // Insertar sombrilla especial
                    insertarSombrillaEspecial(coleccion, scanner, numero);
                } else {
                    System.out.println("Opción no válida.");
                }
            }
        } else {
            System.out.println("No hay lugar disponible para más sombrillas.");
        }
    }

    private static void insertarSombrillaNormal(ColeccionAlquiler coleccion, Scanner scanner, int numero) {

        System.out.print("Ingrese el número de días de alquiler: ");
        int dias = scanner.nextInt();

        System.out.print("¿Tiene estacionamiento? escribe ->(true/false): ");
        boolean estacionamiento = scanner.nextBoolean();

        Sombrilla nuevaSombrilla = new Sombrilla(numero, dias, estacionamiento);
        coleccion.insertar(nuevaSombrilla);

        System.out.println("Sombrilla normal insertada con éxito.");
    }

    private static void insertarSombrillaEspecial(ColeccionAlquiler coleccion, Scanner scanner, int numero) {

        System.out.print("Ingrese el número de días de alquiler: ");
        int dias = scanner.nextInt();

        System.out.print("Ingrese el número de reposeras extras: ");
        int reposeras = scanner.nextInt();

        System.out.print("¿Tiene estacionamiento? (true/false): ");
        boolean estacionamiento = scanner.nextBoolean();

        SombrillaEspecial nuevaSombrillaEspecial = new SombrillaEspecial(numero, dias, reposeras, estacionamiento);
        coleccion.insertar(nuevaSombrillaEspecial);

        System.out.println("Sombrilla especial insertada con éxito.");
    }

    private static void mostrarInformacion(ColeccionAlquiler coleccion) {
        // Verificar si hay sombrillas en la colección
        if (coleccion.getCant() == 0) {
            System.out.println("No hay sombrillas en la colección.");
            return; // Salir del método si no hay sombrillas
        }

        // Mostrar costos de todas las sombrillas
        for (int i = 0; i < coleccion.getCant(); i++) {
            Sombrilla sombrillaActual = coleccion.getSombrilla(i);

            if (sombrillaActual instanceof SombrillaEspecial) {
                // Si es una sombrilla especial, muestra información adicional
                SombrillaEspecial especial = (SombrillaEspecial) sombrillaActual;
                System.out.println("Costo de sombrilla especial N° " + especial.obtenerNum() + ": " + especial.costo());
                System.out.println("> Reposeras extras: " + especial.getReposeras());
            } else {
                // Si es una sombrilla normal, muestra el costo normal
                System.out.println(
                        "Costo de sombrilla N° " + sombrillaActual.obtenerNum() + ": " + sombrillaActual.costo());
            }

            System.out.println("-----------------------------------");
        }

        // Mostrar total de alquiler para sombrillas con más de 6 días
        // System.out.println("Total de alquiler para más de 6 días: " +
        // coleccion.totalAlquiler(6));
    }

    public static void mostrarCostoPorNumero(ColeccionAlquiler coleccion, Scanner scanner) {
        System.out.print("Ingrese el número de sombrilla: ");
        int numeroSombrilla = scanner.nextInt();
        int indice = coleccion.buscarSombrillaPorNumero(numeroSombrilla);

        if (indice != -1) {
            Sombrilla sombrilla = coleccion.getSombrilla(indice);

            System.out.println("Información de la sombrilla:");
            System.out.println("Número: " + sombrilla.obtenerNum());
            System.out.println("Días de alquiler: " + sombrilla.obtenerDias());
            if (sombrilla.tieneEstacionamiento()) {
                System.out.println("Incluye estacionamiento");
            }
            // Verificar si es una SombrillaEspecial para mostrar información adicional
            if (sombrilla instanceof SombrillaEspecial) {
                SombrillaEspecial especial = (SombrillaEspecial) sombrilla;
                System.out.println("Reposeras extras: " + especial.getReposeras());
                if (especial.tieneEstacionamiento()) {
                    System.out.println("Incluye estacionamiento");
                }
            }

            System.out.println("Costo de la sombrilla: " + sombrilla.costo());
        } else {
            System.out.println("Sombrilla no encontrada.");
        }
    }

    // Método para eliminar una sombrilla de la colección
    private static void eliminarSombrilla(ColeccionAlquiler coleccion, Scanner scanner) {
        // Solicitar al usuario el número de la sombrilla a eliminar
        System.out.print("Ingrese el número de sombrilla a eliminar: ");
        int numeroEliminar = scanner.nextInt();

        // Eliminar la sombrilla de la colección
        coleccion.eliminar(numeroEliminar);

    }

    private static void obtenerMontoTotal(ColeccionAlquiler coleccion, Scanner scanner) {
        System.out.print("Ingrese el número de días para filtrar las sombrillas: ");
        int n = scanner.nextInt();

        double montoTotal = coleccion.totalAlquiler(n);
        System.out.println("Monto total de alquiler para sombrillas con más de " + n + " días: " + montoTotal);
    }
}
