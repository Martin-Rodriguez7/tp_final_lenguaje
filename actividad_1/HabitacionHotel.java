package actividad_1;

public class HabitacionHotel extends Alojamiento {
    private double precioXPersona;
    private boolean piscina;

    public HabitacionHotel(int c, String d, boolean t, double r) {
        super(c, d, t);
        precioXPersona = r;
        piscina = false;
    }

    public void establecerPrecioXPersona(double r) {
        precioXPersona = r;
    }

    public void establecerPiscina(boolean p) {
        piscina = p;
    }

    public double obtenerPrecioXPersona() {
        return precioXPersona;
    }

    public boolean tienePiscina() {
        return piscina;
    }

    @Override
    public int estrellas() {
        return super.estrellas() + (tienePiscina() ? 1 : 0);
    }
}