package Clases;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Paciente {

    public int id_Paciente;
    public String nombrePaci;
    public double consulta;
    public int id_Doctor;

    public Paciente(int _id_Paciente, String _nombrePaci, double _consulta, int _id_Doctor) {
        this.id_Paciente = _id_Paciente;
        this.nombrePaci = _nombrePaci;
        this.consulta = _consulta;
        this.id_Doctor = _id_Doctor;
    }

    public Paciente() {
    }

    public int getId_Paciente() {
        return id_Paciente;
    }

    public void setId_Paciente(int id_Paciente) {
        this.id_Paciente = id_Paciente;
    }

    public String getNombrePaci() {
        return nombrePaci;
    }

    public void setNombrePaci(String nombrePaci) {
        this.nombrePaci = nombrePaci;
    }

    public double getConsulta() {
        return consulta;
    }

    public void setConsulta(double consulta) {
        this.consulta = consulta;
    }

    public int getId_Doctor() {
        return id_Doctor;
    }

    public void setId_Doctor(int id_Doctor) {
        this.id_Doctor = id_Doctor;
    }

    public ResultSet getPacientes(Conexion conect) {
        ResultSet rs = null;

        try {
            Statement stmt = conect.getConexion().createStatement();
            String query = "SELECT * FROM Paciente ORDER BY id_paciente;";
            rs = stmt.executeQuery(query);

        } catch (Exception e) {
            System.out.println("No funciono el procedimiento");
        }

        return rs;
    }

    public ResultSet mostrarPorId(Connection conect, int id) {
        ResultSet rs = null;
        try {

            Statement stm = conect.createStatement();
            String query = "Select * from paciente where id_doctor=" + id;
            rs = stm.executeQuery(query);

        } catch (Exception e) {
            System.out.println(e);

        }
        return rs;
    }

    public void Ingresar_Paciente(Connection conectar, String nombre, double consulta, int id_doc) {

        try {
            String query = "Call ingresar_pacientes(?,?,?)";
            CallableStatement cs = conectar.prepareCall(query);

            cs.setString(1, nombre);
            cs.setDouble(2, consulta);
            cs.setInt(3, id_doc);
            cs.execute();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void Eliminar_Paciente(Connection conectar, int id_paci) {
        try {
            String query = "Call eliminar_paciente(?)";
            CallableStatement cs = conectar.prepareCall(query);
            cs.setInt(1, id_paci);
            cs.execute();
        } catch (Exception e) {
         System.out.println(e);
        }
    }
    
    public void Editar_Paciente(Connection conectar, int id_paci, String nombre, double consulta, int id_doc) {
        try {
            String query = "Call modificar_paciente(?,?,?,?)";
            CallableStatement cs = conectar.prepareCall(query);
            cs.setInt(1, id_paci);
            cs.setString(2, nombre);
            cs.setDouble(3, consulta);
            cs.setInt(4, id_doc);

            cs.execute();

        } catch (Exception e) {
            System.out.println(e);

        }

    }

}
