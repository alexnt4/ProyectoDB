package org.example.DAO;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.example.modelo.*;

public class DAOprendaVestir {

    static PreparedStatement ps;
    static ResultSet rs;
    static Connection conn;
    static ConexionBD conectar = new ConexionBD();
    static  prendaVestir c = new prendaVestir();


    public static List<prendaVestir> obtenerPrendasVestir(){
        List<prendaVestir> prendasVestir = new ArrayList<>();
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM PRENDA_VESTIR;");
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while(rs.next()){
                prendaVestir c = new prendaVestir();
                c.setIdPrendaVestir(rs.getInt(1));
                c.setSexo(rs.getString(2));
                c.setColor(rs.getString(3));
                c.setTela(rs.getString(4));
                c.setTipo(rs.getString(5));
                c.setTalla(rs.getString(6));
                c.setDiseno(rs.getString(7));
                c.setPieza(rs.getString(8));

                prendasVestir.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de todos: " + e.getMessage());
        }

        return prendasVestir;
    }


    public static prendaVestir obtenerPrendaVestir(int idPrendaVestir) {
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM  PRENDA_VESTIR WHERE ID_PRENDA = ?;");
            ps.setInt(1, idPrendaVestir);
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while (rs.next()) {
                prendaVestir c = new prendaVestir();
                c.setIdPrendaVestir(rs.getInt(1));
                c.setSexo(rs.getString(2));
                c.setColor(rs.getString(3));
                c.setTela(rs.getString(4));
                c.setTipo(rs.getString(5));
                c.setTalla(rs.getString(6));
                c.setDiseno(rs.getString(7));
                c.setPieza(rs.getString(8));

            }
        } catch (Exception e) {
            System.out.println("Error al obtener la prenda de vestir: " + e.getMessage());
        }

        return c;

    }

    public static int agregarPrendaVestir(prendaVestir prendaVestir) {
        int r = 0;
        String sql = "INSERT INTO PRENDA_VESTIR (ID_PRENDA, SEXO, COLOR, TELA, TIPO, TALLA, DISEÑOPRENDA, PIEZA) VALUES (?,?,?,?,?,?,?,?);";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, prendaVestir.getIdPrendaVestir());
            ps.setString(2, prendaVestir.getSexo());
            ps.setString(3, prendaVestir.getColor());
            ps.setString(4, prendaVestir.getTela());
            ps.setString(5, prendaVestir.getTipo());
            ps.setString(6, prendaVestir.getTalla());
            ps.setString(7, prendaVestir.getDiseno());
            ps.setString(8, prendaVestir.getPieza());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar la prenda de vestir: " + e.getMessage());
        }
        return r;
    }


    public static int actualizarPrendaVestir(prendaVestir prendaVestir) {
        int r = 0;
        String sql = "UPDATE PRENDA_VESTIR SET SEXO = ?, COLOR = ?, TELA = ?, TIPO = ?, TALLA = ?, DISEÑOPRENDA = ?, PIEZA = ? WHERE ID_PRENDA = ?;";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, prendaVestir.getSexo());
            ps.setString(2, prendaVestir.getColor());
            ps.setString(3, prendaVestir.getTela());
            ps.setString(4, prendaVestir.getTipo());
            ps.setString(5, prendaVestir.getTalla());
            ps.setString(6, prendaVestir.getDiseno());
            ps.setString(7, prendaVestir.getPieza());
            ps.setInt(8, prendaVestir.getIdPrendaVestir());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar la prenda de vestir: " + e.getMessage());
        }
        return r;
    }



    public static int eliminarPrendaVestir(int idPrendaVestir) {
        int r = 0;
        String sql = "DELETE FROM PRENDA_VESTIR WHERE ID_PRENDA = ?;";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idPrendaVestir);
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar la prenda de vestir: " + e.getMessage());
        }
        return r;
    }


}
