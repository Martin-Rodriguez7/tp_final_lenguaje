package actividad_2;

public class ColeccionAlquiler {
    private Sombrilla[] ca;
    private int cant;

    public ColeccionAlquiler(int n) {
        ca = new Sombrilla[n];
        cant = 0;
    }

    public int getCant() {
        return cant;
    }

    public Sombrilla getSombrilla(int indice) {
        if (indice >= 0 && indice < cant) {
            return ca[indice];
        } else {
            // Manejo de error o lanzar excepción, dependiendo de tus necesidades
            return null;
        }
    }

    public boolean getEspacioDisponible() {
        return cant < ca.length;
    }

    public void insertar(Sombrilla s) {
        if (cant < ca.length) {
            ca[cant] = s;
            cant++;
        } else {
            System.out.println("No hay espacio disponible.");
        }
    }

    public void eliminar(int numeroSombrilla) {
        int indice = buscarSombrillaPorNumero(numeroSombrilla);
        // for (int i = 0; i < cant; i++) {
        // if (ca[i].obtenerNum() == numeroSombrilla) {
        // indice = i;
        // break; // Detener la búsqueda una vez encontrada la sombrilla
        // }
        // }

        if (indice != -1) {
            // Compactar la colección
            for (int i = indice; i < cant - 1; i++) {
                ca[i] = ca[i + 1];
            }
            ca[cant - 1] = null;
            cant--;
            System.out.println("Sombrilla eliminada con éxito.");
        } else {
            System.out.println("Sombrilla no encontrada.");
        }
    }

    public int buscarSombrillaPorNumero(int numeroSombrilla) {
        for (int i = 0; i < cant; i++) {
            if (ca[i].obtenerNum() == numeroSombrilla) {
                return i; // Retorna el índice de la sombrilla encontrada
            }
        }
        return -1; // Retorna -1 si la sombrilla no se encuentra
    }

    public double totalAlquiler(int n) {
        double montoTotal = 0;

        // Recorrer la colección de sombrillas
        for (int i = 0; i < cant; i++) {
            Sombrilla sombrillaActual = ca[i];

            // Verificar si los días de alquiler son mayores que n
            if (sombrillaActual.obtenerDias() > n) {
                // Sumar el costo de la sombrilla al monto total
                montoTotal += sombrillaActual.costo();
            }
        }

        return montoTotal;
    }

    public boolean existeSombrillaConNumero(int numero) {
        for (int i = 0; i < cant; i++) {
            if (ca[i] != null && ca[i].obtenerNum() == numero) {
                return true; // Ya existe una sombrilla con el número proporcionado
            }
        }
        return false; // No se encontró una sombrilla con el número proporcionado
    }
}