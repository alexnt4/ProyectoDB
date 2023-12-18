package org.example.DAO;

import org.example.modelo.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.example.modelo.*;
public class DAOcolegio {

    static PreparedStatement ps;
    static ResultSet rs;
    static Connection conn;
    static ConexionBD conectar = new ConexionBD();
    static colegio c = new colegio();

    public static List<colegio> obtenerColegios(){
        List<colegio> colegios = new ArrayList<>();
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM colegio;");
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while(rs.next()){
                colegio c = new colegio();
                c.setIdColegio(rs.getInt(1));
                c.setNombreColegio(rs.getString(2));
                c.setDireccionColegio(rs.getString(3));
                c.setContacto(rs.getString(4));

                colegios.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de todos: " + e.getMessage());
        }

        return colegios;
    }




    public static colegio obtenerColegio(int idCliente){
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM cliente WHERE idCliente = ?;");
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while(rs.next()){
                colegio c = new colegio();
                c.setIdColegio(rs.getInt(1));
                c.setNombreColegio(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el cliente: " + e.getMessage());
        }

        return c;
    }

    public static int agregarColegio(colegio colegio) {
        int r = 0;
        String sql = "INSERT INTO colegio (ID_COLEGIO, NOM_COLEGIO, DIR_COLEGIO, CONTACTO) VALUES (?,?,?,?);";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, colegio.getIdColegio());
            ps.setString(2, colegio.getNombreColegio());
            ps.setString(3, colegio.getDireccionColegio());
            ps.setString(4, colegio.getContacto());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar el colegio: " + e.getMessage());
        }
        return r;
    }


    public static int actualizarColegio(colegio colegio) {
        int r = 0;
        String sql = "UPDATE colegio SET NOM_COLEGIO = ?, DIR_COLEGIO = ?, CONTACTO = ? WHERE ID_COLEGIO = ?;";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, colegio.getNombreColegio());
            ps.setString(2, colegio.getDireccionColegio());
            ps.setString(3, colegio.getContacto());
            ps.setInt(4, colegio.getIdColegio());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar el colegio: " + e.getMessage());
        }
        return r;
    }


    public static int eliminarColegio(int idColegio) {
        int r = 0;
        String sql = "DELETE FROM colegio WHERE ID_COLEGIO = ?;";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idColegio);
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el colegio: " + e.getMessage());
        }
        return r;
    }
}
