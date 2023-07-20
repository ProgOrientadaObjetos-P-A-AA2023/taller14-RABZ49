package problema01;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        ent.useLocale(Locale.US);

        int opcion;
        boolean bandera = true;

        String nombre;
        String cedula;
        String correo;
        String mesSueldo;
        double sueldo;

        ArrayList<Trabajador> lista;
        Enlace en = new Enlace();

        while (bandera) {
            ent.nextLine();
            System.out.print("Ingrese el nombre del trabajador: ");
            nombre = ent.nextLine();
            System.out.print("Ingrese la cedula del trabajador: ");
            cedula = ent.nextLine();
            System.out.print("Ingrese el correo del trabajador: ");
            correo = ent.nextLine();
            System.out.print("Ingrese el mes del sueldo del trabajador: ");
            mesSueldo = ent.nextLine();
            System.out.print("Ingrese el sueldo del trabajador: ");
            sueldo = ent.nextDouble();
            System.out.print("Si desea terminar el ingreso de datos,"
                    + " presione 1\nde lo contrario 2: ");
            opcion = ent.nextInt();

            Trabajador trabajador = new Trabajador(cedula, nombre,
                    correo, sueldo, mesSueldo);

            en.insertarTrabajador(trabajador);

            if (opcion == 1) {
                bandera = false;
            }
        }

        en.establecerLista();
        lista = en.obtenerLista();

        for (Trabajador t : lista) {
            System.out.println(t);
        }
    }

}
