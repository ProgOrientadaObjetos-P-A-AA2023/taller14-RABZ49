package problema02;

import java.sql.Statement;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Enlace {

    private Connection conn;
    private ArrayList<Estudiantes> dataC;

    public ArrayList<Estudiantes> obtenerLista() {
        return dataC;
    }

    public void establecerConexion() {

        try {
            String url = "jdbc:sqlite:bd/base001.base";
            conn = DriverManager.getConnection(url); 

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarEstudiante(Estudiantes estudiantes) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO estudiante (nombre, apellido,"
                    + "calificacion1, calificacion2, calificacion3) "
                    + "VALUES ('%s', '%s', %s, %s, %s)",
                    estudiantes.obtenerNombre(),
                    estudiantes.obtenerApellido(),
                    estudiantes.obtenerCalificacion1(),
                    estudiantes.obtenerCalificacion2(),
                    estudiantes.obtenerCalificacion3());
            
            statement.executeUpdate(data);
            obtenerConexion().close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public void establecerLista() {
        dataC = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "SELECT * FROM estudiante;";
            ResultSet rs = statement.executeQuery(data);
            
            while (rs.next()) {
                Estudiantes e = new Estudiantes(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDouble("calificacion1"), 
                        rs.getDouble("calificacion2"), 
                        rs.getDouble("calificacion3"));
                e.establecerPromedio();
                dataC.add(e);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

}
