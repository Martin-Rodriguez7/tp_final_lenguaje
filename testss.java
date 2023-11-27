import actividad_2.ColeccionAlquiler;
import actividad_2.Sombrilla;
import actividad_2.SombrillaEspecial;

public public class tester2 {
    public static void main(String[] args) {
        // Crear instancias de Sombrilla y SombrillaEspecial
        Sombrilla sombrillaNormal = new Sombrilla(, 1, true);
        SombrillaEspecial sombrillaEspecial = new SombrillaEspecial(2, 7, 2, false);

        // Mostrar el costo de cada sombrilla
        System.out.println("Costo de sombrilla normal: " + sombrillaNormal.costo());
        System.out.println("Costo de sombrilla especial: " + sombrillaEspecial.costo());

        // Crear una colección de alquiler
        ColeccionAlquiler coleccion = new ColeccionAlquiler(5);

        // Insertar sombrillas en la colección
        coleccion.insertar(sombrillaNormal);
        coleccion.insertar(sombrillaEspecial);

        // Mostrar el total de alquiler para sombrillas con más de 6 días
        System.out.println("Total de alquiler para más de 6 días: " + coleccion.totalAlquiler(6));

        // Eliminar una sombrilla de la colección
        coleccion.eliminar(1);

        // Mostrar el total de alquiler nuevamente después de la eliminación
        System.out.println("Total de alquiler para más de 6 días después de eliminar: " + coleccion.totalAlquiler(6));
    }
}{

}
