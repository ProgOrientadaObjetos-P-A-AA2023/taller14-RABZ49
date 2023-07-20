package problema01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class Enlace {

    private Connection conn;
    private ArrayList<Trabajador> lista;

    public void establecerConexion() {
        try {
            String url = "jdbc:sqlite:bd/Trabajador.db";
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarTrabajador(Trabajador t) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();

            String instruccion = String.format("INSERT INTO SalarioTrabajador "
                    + "(cedula, nombres, correo, sueldo, mesSueldo) VALUES "
                    + "('%s', '%s', '%s', %s, '%s')",
                    t.obtenerCedula(),
                    t.obtenerNombre(),
                    t.obtenerCorreo(),
                    t.obtenerSueldo(),
                    t.obtenerMesSueldo());

            statement.executeUpdate(instruccion);
            obtenerConexion().close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void establecerLista() {
        try {
            lista = new ArrayList<>();
            establecerConexion();

            Statement statement = obtenerConexion().createStatement();
            String instruccion = "SELECT * FROM SalarioTrabajador";
            ResultSet rs = statement.executeQuery(instruccion);

            while (rs.next()) {
                Trabajador t = new Trabajador(
                        rs.getString("cedula"),
                        rs.getString("nombres"),
                        rs.getString("correo"),
                        rs.getDouble("sueldo"),
                        rs.getString("mesSueldo"));

                lista.add(t);
            }

            obtenerConexion().close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Trabajador> obtenerLista() {
        return lista;
    }
}
