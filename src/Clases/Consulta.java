package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Consulta {

    public int id_consulta;
    public int id_paciente;
    public int id_doctor;
    public double precio_consulta;
    public String fecha;
    public String hora;
    public String medicina;

    private Conexion con=new Conexion();

    public Consulta(int id_consulta, int id_paciente, int id_doctor, double precio_consulta, String fecha, String hora, String medicina) {
        this.id_consulta = id_consulta;
        this.id_paciente = id_paciente;
        this.id_doctor = id_doctor;
        this.precio_consulta = precio_consulta;
        this.fecha = fecha;
        this.hora = hora;
        this.medicina = medicina;
    }

    public Consulta(int id_paciente, int id_doctor, double precio_consulta, String fecha, String hora, String medicina) {
        this.id_paciente = id_paciente;
        this.id_doctor = id_doctor;
        this.precio_consulta = precio_consulta;
        this.fecha = fecha;
        this.hora = hora;
        this.medicina = medicina;
    }
    
    

    public Consulta() {
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public double getPrecio_consulta() {
        return precio_consulta;
    }

    public void setPrecio_consulta(double precio_consulta) {
        this.precio_consulta = precio_consulta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMedicina() {
        return medicina;
    }

    public void setMedicina(String medicina) {
        this.medicina = medicina;
    }
    
    public ResultSet getConsulta(Connection conect, int id) {
        ResultSet rs = null;

        try {

            Statement stmt = conect.createStatement();
            String query = "SELECT c.id_consulta, c.id_paciente, c.id_doctor, p.nombre, c.precio ,c.fecha, c.hora FROM consulta c join "
                            + "paciente p on c.id_paciente=p.id_paciente where p.id_paciente="+id+";";
            rs = stmt.executeQuery(query);

        } catch (Exception e) {
            System.out.println(e);
        }

        return rs;
    }

    public void insertCon(Conexion con)
    {
        try
        {
            String query = "INSERT INTO consulta(id_consulta, id_paciente, id_doctor, precio , fecha, hora, medicina) "
                            + "VALUES (default, ?, ?, ?, ?, ?, ?);";
      
            PreparedStatement pst = con.getConexion().prepareStatement(query);
            pst.setInt(1, id_paciente);
            pst.setInt(2, id_doctor);
            pst.setDouble(3, precio_consulta);
            pst.setString(4, fecha);
            pst.setString(5, hora);
            pst.setString(6, medicina);
            pst.execute();
        }
        catch(Exception e) 
        {
           System.out.println(e);
        }
    }

    
}
