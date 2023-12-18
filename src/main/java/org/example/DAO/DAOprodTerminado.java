package org.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.example.modelo.*;

public class DAOprodTerminado {

    static PreparedStatement ps;
    static ResultSet rs;
    static Connection conn;
    static ConexionBD conectar = new ConexionBD();
    static  prodTerminado c = new prodTerminado();

    public static List<prodTerminado> obtenerProdTerminado(){
        List<prodTerminado> prodTerminado = new ArrayList<>();
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM PRODUCTO_TERMINADO;");
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while(rs.next()){
                prodTerminado c = new prodTerminado();
                c.setCodProdTerm(rs.getInt(1));
                c.setIdPrenda(rs.getInt(2));
                c.setCodMaterial(rs.getInt(3));
                c.setDescripcion(rs.getString(4));
                c.setPrecio(rs.getInt(5));
                c.setEncargado(rs.getInt(6));
                c.setCanTerminados(rs.getInt(7));

                prodTerminado.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de todos: " + e.getMessage());
        }

        return prodTerminado;
    }


    public static prodTerminado obtenerProdTerminado(int codProdTerm) {
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM  PRODUCTO_TERMINADO WHERE ID_PRENDA = ?;");
            ps.setInt(1, codProdTerm);
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while (rs.next()) {
                prodTerminado c = new prodTerminado();
                c.setCodProdTerm(rs.getInt(1));
                c.setIdPrenda(rs.getInt(2));
                c.setCodMaterial(rs.getInt(3));
                c.setDescripcion(rs.getString(4));
                c.setPrecio(rs.getInt(5));
                c.setEncargado(rs.getInt(6));
                c.setCanTerminados(rs.getInt(7));

            }
        } catch (Exception e) {
            System.out.println("Error al obtener la prenda de vestir: " + e.getMessage());
        }

        return c;

    }

    public static int agregarProdTerminado(prodTerminado prodTerminado) {
        int r = 0;
        String sql = "INSERT INTO PRODUCTO_TERMINADO (COD_PROD_TERM, ID_PRENDA, CODIGO_MATERIAL, DESCRIPCION, PRECIO, ENCARGADO, CANT_TERMINADOS) VALUES (?,?,?,?,?,?,?);";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, prodTerminado.getCodProdTerm());
            ps.setInt(2, prodTerminado.getIdPrenda());
            ps.setInt(3, prodTerminado.getCodMaterial());
            ps.setString(4, prodTerminado.getDescripcion());
            ps.setInt(5, prodTerminado.getPrecio());
            ps.setInt(6, prodTerminado.getEncargado());
            ps.setInt(7, prodTerminado.getCanTerminados());
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

    public static int actualizarProdTerminado(prodTerminado prodTerminado) {
        int r = 0;
        String sql = "UPDATE PRODUCTO_TERMINADO SET ID_PRENDA = ?, CODIGO_MATERIAL = ?, DESCRIPCION = ?, PRECIO = ?, ENCARGADO = ?, CANT_TERMINADOS = ? WHERE COD_PROD_TERM = ?;";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, prodTerminado.getIdPrenda());
            ps.setInt(2, prodTerminado.getCodMaterial());
            ps.setString(3, prodTerminado.getDescripcion());
            ps.setInt(4, prodTerminado.getPrecio());
            ps.setInt(5, prodTerminado.getEncargado());
            ps.setInt(6, prodTerminado.getCanTerminados());
            ps.setInt(7, prodTerminado.getCodProdTerm());
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


    public static int eliminarProdTerminado(int codProdTerm) {
        int r = 0;
        String sql = "DELETE FROM PRODUCTO_TERMINADO WHERE COD_PROD_TERM = ?;";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codProdTerm);
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
