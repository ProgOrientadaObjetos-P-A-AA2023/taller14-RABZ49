package problema01;

public class Trabajador {
    private String cedula;
    private String nombre;
    private String correo;
    private double sueldo;
    private String mesSueldo;

    public Trabajador(String ced, String nom, String co, double suel,
            String mSuel) {
        cedula = ced;
        nombre = nom;
        correo = co;
        sueldo = suel;
        mesSueldo = mSuel;
    }

    public String obtenerCedula() {
        return cedula;
    }

    public void establecerCedula(String n) {
        cedula = n;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public void establecerNombre(String n) {
        nombre = n;
    }

    public String obtenerCorreo() {
        return correo;
    }

    public void establecerCorreo(String n) {
        correo = n;
    }

    public double obtenerSueldo() {
        return sueldo;
    }

    public void establecerSueldo(double n) {
        sueldo = n;
    }

    public String obtenerMesSueldo() {
        return mesSueldo;
    }

    public void establecerMesSueldo(String n) {
        mesSueldo = n;
    }

    @Override
    public String toString() {
        String m = String.format("""
                                 
                                    Trabajador
                                 -Nombre: %s
                                 -Cedula: %s
                                 -Correo: %s
                                 -Mes del sueldo: %s
                                 -Sueldo: %.2f
                                 
                                 """,
                nombre,
                cedula,
                correo,
                mesSueldo,
                sueldo);
        return m;
    }
    
}
