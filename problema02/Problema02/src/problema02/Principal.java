package problema02;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Enlace en = new Enlace();
        ArrayList<Estudiantes> list;
        
        en.establecerLista();
        list = en.obtenerLista();
        
        for (Estudiantes estudiantes : list) {
            System.out.println(estudiantes);
        }
    }
    
}
