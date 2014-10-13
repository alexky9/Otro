
package barmex;

import java.sql.*;
import java.util.*;

public class EquiposDB {
    Connection connection;
    private boolean connectionFree = true;
    private ArrayList equipos;

    public EquiposDB () throws Exception {
        try {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             connection = DriverManager.getConnection("jdbc:mysql://192.168.10.250/barmex_1","barpro","barpro");
       
        }
        catch (Exception e) {
            throw new Exception ("No se pudo abrir la base de datos biblioteca: " + e.getMessage ());
        }
    }

    protected synchronized Connection getConnection () {
        while (this.connectionFree == false) {
            try {
                wait ();
            }
            catch (InterruptedException e) {
            }
        }
        this.connectionFree = false;
        notify ();
        return this.connection;
    }

    protected synchronized void releaseConnection () {
        while (this.connectionFree == true) {
            try {
                wait ();
            }
            catch (InterruptedException e) {
            }
        }
        this.connectionFree = true;
        notify ();
    }

    public Equipo getEquipo (String nombre) {
        try {
            this.getConnection ();
            PreparedStatement preparedStatement = this.connection.prepareStatement 
              ("SELECT id, nombre, asignacion, caracteristica, tipo, sucof, comentario, respaldos, contraseña, productkey FROM equipo" + 
               " WHERE nombre = ?");
            preparedStatement.setString (1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery ();
            if (resultSet.next ()) {
                Equipo n = new Equipo(1, nombre, nombre, nombre, nombre, nombre, nombre, nombre, nombre, nombre, null, null, null, null, null, null, null, null);
                preparedStatement.close ();
                this.releaseConnection ();
                return n;
            }
            else {
                preparedStatement.close ();
                this.releaseConnection ();
                return null;
            }
        }
        catch (SQLException e) {
            this.releaseConnection ();
            return null;
        }
    }

    public int insertarLibro (Equipo n) {
        int rowsAffected = 0;
        try {
            this.getConnection ();
            PreparedStatement i = this.connection.prepareStatement 
                 ("INSERT INTO equipo (nombre, asignacion, caracteristica, tipo, "
                + "sucof, comentario, respaldos, contraseña, productkey) "
                         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            i.setString (1, Equipo.getNombre(String));
            i.setString (2, Equipo.getAsignacion());
            i.setString (3, Equipo.getCaracteristica ());
            i.setString (4, Equipo.getTipo ());
            i.setString (5, Equipo.getSucof ());
            i.setString (6, Equipo.getComentario ());
            rowsAffected = i.executeUpdate ();
            i.close ();
            this.releaseConnection ();
        }
        catch (SQLException e) {
            this.releaseConnection ();
            return 0;
        }
        return rowsAffected;
    }

    public int borrarEquipo (String nombre){
        int rowsAffected = 0;
        try {
            this.getConnection ();
            PreparedStatement preparedStatement = 
                this.connection.prepareStatement ("DELETE FROM equipo WHERE nombre = ?");
            preparedStatement.setString (1, nombre);
            rowsAffected = preparedStatement.executeUpdate ();
            preparedStatement.close ();
            this.releaseConnection ();
        }
        catch (SQLException e) {
            this.releaseConnection ();
            return 0;
        }
        return rowsAffected;
    }

   

    public Collection getEquipos () {
        equipos = new ArrayList ();
        try {
            this.getConnection ();
            PreparedStatement preparedStatement = this.connection.prepareStatement 
                  ("SELECT id, nombre, asignacion, caracteristica, tipo, sucof, respaldos, comentario, contraseña, productkey FROM equipo");
            ResultSet resultSet = preparedStatement.executeQuery ();
            while (resultSet.next ()) {
                Equipo a = new Equipo(Integer.SIZE, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                equipos.add (equipos);
            }
            preparedStatement.close ();
        }
        catch (SQLException e) {
            return null;
        }
        this.releaseConnection ();

        return equipos;
    }

    public void close () {
        try {
            this.connection.close ();
        }
        catch (SQLException e) {
            System.out.println (e.getMessage ());
        }
    }

}
