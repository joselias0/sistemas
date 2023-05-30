package Clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private Connection conexion;
    
    public Conexion()
    {
      try{
              Class.forName("org.postgresql.Driver") ;
              conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/estructura","postgres", "1234") ;
        }catch(Exception e) {   
        System.out.println("No se conecto a la Base de Datos...");
        } 
    }  
    
    public Connection getConexion(){
        return this.conexion;
    }
}
