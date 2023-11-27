package actividad_1;

public class Cabana extends Alojamiento {
    private double precioXDia;
    private int cantHabitaciones;
    private int cantBanios;

    public Cabana(int c, String d, boolean t, double p, int ch, int cb) {
        super(c, d, t);
        precioXDia = p;
        cantHabitaciones = ch;
        cantBanios = cb;
    }

    public void establecerPrecioXDia(double p) {
        precioXDia = p;
    }

    public double obtenerPrecioXDia() {
        return precioXDia;
    }

    @Override
    public int estrellas() {
        return super.estrellas();
    }
}
