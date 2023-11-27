package actividad_2;

public class SombrillaEspecial extends Sombrilla {
    private int reposeras;

    public SombrillaEspecial(int n,
            int d,
            int r,
            boolean e) {
        super(n, d, e);
        this.reposeras = r;
    }

    public int getReposeras() {
        return reposeras;
    }

    @Override
    public double costo() {
        double costoBase = super.costo(); // Obtener el costo base de la sombrilla

        // Si se contrató estacionamiento, aplicar costo con estacionamiento
        if (tieneEstacionamiento()) {
            return 1.4 * (costoBase + extras) + (extras / 3) * reposeras * obtenerDias();
        } else {
            // Si no se contrató estacionamiento, aplicar costo sin estacionamiento
            return 1.4 * costoBase + (extras / 3) * reposeras * obtenerDias();
        }
    }
}
