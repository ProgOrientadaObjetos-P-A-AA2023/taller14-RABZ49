package problema02;

public class Estudiantes {

    private String nombre;
    private String apellido;
    private double calificacion1;
    private double calificacion2;
    private double calificacion3;
    private double promedio;

    public Estudiantes(String nom, String ape, double califi1, double califi2,
            double califi3) {
        nombre = nom;
        apellido = ape;
        calificacion1 = califi1;
        calificacion2 = califi2;
        calificacion3 = califi3;
    }

    public double obtenerCalificacion1() {
        return calificacion1;
    }

    public void establecerCalificacion1(double x) {
        calificacion1 = x;
    }

    public double obtenerCalificacion2() {
        return calificacion2;
    }

    public void establecerCalificacion2(double x) {
        calificacion2 = x;
    }

    public double obtenerCalificacion3() {
        return calificacion3;
    }

    public void establecerCalificacion3(double x) {
        calificacion3 = x;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public void establecerNombre(String x) {
        nombre = x;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public void establecerApellido(String x) {
        apellido = x;
    }

    public double obtenerPromedio() {
        return promedio;
    }

    public void establecerPromedio() {
        double suma = (calificacion1 + calificacion2 + calificacion3) / 3;

        promedio = suma;
    }

    @Override
    public String toString() {
        String x = String.format("%s %s\n"
                + " Calificaciones:\n"
                + " %.2f\n"
                + " %.2f\n"
                + " %.2f\n"
                + " Promedio= %.2f\n", obtenerNombre(),
                obtenerApellido(), obtenerCalificacion1(),
                obtenerCalificacion2(),
                obtenerCalificacion3(), obtenerPromedio());
        return x;
    }

}
