package org.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.example.modelo.*;

public class DAOuniforme {
    static PreparedStatement ps;
    static ResultSet rs;
    static Connection conn;
    static ConexionBD conectar = new ConexionBD();
    static  uniforme c = new uniforme();


    public static List<uniforme> obtenerUniformes() {
        List<uniforme> uniformes = new ArrayList<>();
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM uniforme;");
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while (rs.next()) {
                uniforme c = new uniforme();
                c.setIdPrenda(rs.getInt(1));
                c.setCaracEspecial(rs.getString(2));
                c.setIdColegio(rs.getInt(3));

                uniformes.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de todos: " + e.getMessage());
        }

        return uniformes;
    }
    public static uniforme obtenerUniforme(int idPrenda) {
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM  UNIFORME WHERE ID_PRENDA = ?;");
            ps.setInt(1, idPrenda);
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while (rs.next()) {
                uniforme c = new uniforme();
                c.setIdPrenda(rs.getInt(1));
                c.setCaracEspecial(rs.getString(2));
                c.setIdColegio(rs.getInt(3));

            }
        } catch (Exception e) {
            System.out.println("Error al obtener el uniforme: " + e.getMessage());
        }

        return c;

    }


    public static int agregarUniforme(uniforme uniforme) {
        int r = 0;
        String sql = "INSERT INTO UNIFORME (ID_PRENDA, CARAC_ESPECIAL, ID_COLEGIO) VALUES (?,?,?);";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uniforme.getIdPrenda());
            ps.setString(2, uniforme.getCaracEspecial());
            ps.setInt(3, uniforme.getIdColegio());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar el uniforme: " + e.getMessage());
        }
        return r;
    }


    public static int actualizarUniforme(uniforme uniforme) {
        int r = 0;
        String sql = "UPDATE UNIFORME SET CARAC_ESPECIAL = ?, ID_COLEGIO = ? WHERE ID_PRENDA = ?;";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, uniforme.getCaracEspecial());
            ps.setInt(2, uniforme.getIdColegio());
            ps.setInt(3, uniforme.getIdPrenda());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar el uniforme: " + e.getMessage());
        }
        return r;
    }


    public static int eliminarUniforme(int idPrenda) {
        int r = 0;
        String sql = "DELETE FROM UNIFORME WHERE ID_PRENDA = ?;";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idPrenda);
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el uniforme: " + e.getMessage());
        }
        return r;
    }
}
