package Clases;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;

public class Doctor {

    public int id_doctor;
    public String nombreDoc;
    public String especialidad;
    public double sueldo;

    public Conexion ocon = new Conexion();

    public Doctor(int _id_doctor, String _nombreDoc, String _especialidad, double _sueldo) {
        this.id_doctor = _id_doctor;
        this.nombreDoc = _nombreDoc;
        this.especialidad = _especialidad;
        this.sueldo = _sueldo;
    }

    public Doctor() {
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public ResultSet getDoctores(Conexion conect) {
        ResultSet rs = null;

        try {

            Statement stmt = conect.getConexion().createStatement();
            String query = "SELECT * FROM Doctor ORDER BY id_doctor";
            rs = stmt.executeQuery(query);

        } catch (Exception e) {
            System.out.println(e);
        }

        return rs;
    }

    public void Ingresar_Doctor(Connection conectar, String nombre, String esp, double sueldo) {

        try {
            String query = "Call ingresar_doctor(?,?,?)";
            CallableStatement cs = conectar.prepareCall(query);
            cs.setString(1, nombre);
            cs.setString(2, esp);
            cs.setDouble(3, sueldo);
            cs.execute();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void aumento_salario(Connection conectar, int id, double consulta) {

        try {
            String query = "Call aumento_salario(?,?)";
            CallableStatement cs = conectar.prepareCall(query);
            cs.setInt(1, id);
            cs.setDouble(2, consulta);
            cs.execute();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void ELiminar_Doctor(Connection conectar, int id) {
        try {

            String query = "Call eliminar_doctor(?)";
            CallableStatement cs = conectar.prepareCall(query);
            cs.setInt(1, id);
            cs.execute();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void Editar_Doctor(Connection conectar, int id_doct, String nombre, String esp, Double sueldo) {

        try {
            String query = "Call modificar_doctor(?,?,?,?)";
            CallableStatement cs = conectar.prepareCall(query);
            cs.setInt(1, id_doct);
            cs.setString(2, nombre);
            cs.setString(3, esp);
            cs.setDouble(4, sueldo);
            cs.execute();

        } catch (Exception e) {
            System.out.println(e);

        }
    }

}
