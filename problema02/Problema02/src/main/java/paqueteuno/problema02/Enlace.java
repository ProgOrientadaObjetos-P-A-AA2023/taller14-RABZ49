/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paqueteuno.problema02;

import java.sql.Statement;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Enlace {
    /** 
     * Connect to a sample database 
     * @return 
    */
    private Connection conn;
    private ArrayList<Estudiantes> dataC;

    public ArrayList<Estudiantes> obtenerDataC() {
        return dataC;
    }

   
       
    public void establecerConexion() {  
        
        try {  
            // db parameters  
            String url = "jdbc:sqlite:bd/base01.bd";  
            // create a connection to the database  
            conn = DriverManager.getConnection(url);
            // es un metodo estatico, porque no se crea un objeto.
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
        
    } 
    
    public Connection obtenerConexion(){
        return conn;
    }
    
    public void insertarCiudad(Estudiantes estudiantes) {  
  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO Estudiantes (nombre,apellido,"
                    + "calificacion1,calificacion2,calificacion3,promedio) "
                    + "values ('%s', %s,%s)", estudiantes.obtenerNombre(), 
                    estudiantes.obtenerApellido(),
                    estudiantes.obtenerCalificacion1(),
                    estudiantes.obtenerCalificacion2(),
                    estudiantes.obtenerCalificacion3(),
                    estudiantes.obtenerPromedio());
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarCiudad");
             System.out.println(e.getMessage());  
             
        }  
    }
    
    public void establecerDataCiudad() {  
        dataC = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from Ciudad;";
            
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                Estudiantes listaestu = new Estudiantes("nombre",
                        "apellido", 0, 0, 0);
                dataC.add(listaestu);
            }
            
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarCiudad");
             System.out.println(e.getMessage());  
             
        }  
        
    }
     
}  
