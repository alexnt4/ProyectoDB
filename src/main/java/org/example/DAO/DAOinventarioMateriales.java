package org.example.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DAOinventarioMateriales {

    static PreparedStatement ps;
    static ResultSet rs;
    static Connection conn;
    static ConexionBD conectar = new ConexionBD();
    static  inventarioMateriales c = new inventarioMateriales();

    public static List<inventarioMateriales> obtenerInventarioMateriales(){
        List<inventarioMateriales> inventarioMateriales = new ArrayList<>();
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM INVENTARIO_MATERIALES;");
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while(rs.next()){
                inventarioMateriales c = new inventarioMateriales();
                c.setCodMaterial(rs.getInt(1));
                c.setCantidad(rs.getInt(2));
                c.setTipo(rs.getString(3));
                c.setDesMaterial(rs.getString(4));
                c.setUniMedida(rs.getString(5));

                inventarioMateriales.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de todos: " + e.getMessage());
        }

        return inventarioMateriales;
    }

    public static void tablainventarioID(int ID, JTable tabla) {
        try {
            String q;
            if (ID != 0) {
                q = "SELECT * FROM INVENTARIO_MATERIALES WHERE CODIGO_MATERIAL = ?";
            } else {
                q = "SELECT * FROM INVENTARIO_MATERIALES";
            }

            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(q);

                if (ID != 0) {
                    statement.setInt(1, ID);
                }

                ResultSet rs = statement.executeQuery();

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("CODIGO_MATERIAL");
                model.addColumn("CANTIDAD");
                model.addColumn("TIPO");
                model.addColumn("DESC_MATERIAL");
                model.addColumn("UNI_MEDIDA");



                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("CODIGO_MATERIAL"),
                            rs.getInt("CANTIDAD"),
                            rs.getString("TIPO"),
                            rs.getString("DESC_MATERIAL"),
                            rs.getString("UNI_MEDIDA"),
                    };
                    model.addRow(rowData);
                }

                tabla.setModel(model);
                conexion.closeConnection();
            } else {
                JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }


    public static inventarioMateriales obtenerInventarioMateriales(int codMaterial) {
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM  INVENTARIO_MATERIALES WHERE CODIGO_MATERIAL = ?;");
            ps.setInt(1, codMaterial);
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while (rs.next()) {
                inventarioMateriales c = new inventarioMateriales();
                c.setCodMaterial(rs.getInt(1));
                c.setCantidad(rs.getInt(2));
                c.setTipo(rs.getString(3));
                c.setDesMaterial(rs.getString(4));
                c.setUniMedida(rs.getString(5));

            }
        } catch (Exception e) {
            System.out.println("Error al obtener el inventario de materiales: " + e.getMessage());
        }

        return c;

    }



    public static int agregarInventarioMateriales(inventarioMateriales inventarioMateriales) {
        int r = 0;
        String sql = "INSERT INTO INVENTARIO_MATERIALES (CODIGO_MATERIAL, CANTIDAD, TIPO, DESC_MATERIAL, UNI_MEDIDA) VALUES (?,?,?,?,?);";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, inventarioMateriales.getCodMaterial());
            ps.setInt(2, inventarioMateriales.getCantidad());
            ps.setString(3, inventarioMateriales.getTipo());
            ps.setString(4, inventarioMateriales.getDesMaterial());
            ps.setString(5, inventarioMateriales.getUniMedida());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar el inventario de materiales: " + e.getMessage());
        }
        return r;
    }





    public static int actualizarInventarioMateriales(inventarioMateriales inventarioMateriales) {
        int r = 0;
        String sql = "UPDATE INVENTARIO_MATERIALES SET CANTIDAD = ?, TIPO = ?, DESC_MATERIAL = ?, UNI_MEDIDA = ? WHERE CODIGO_MATERIAL = ?;";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, inventarioMateriales.getCantidad());
            ps.setString(2, inventarioMateriales.getTipo());
            ps.setString(3, inventarioMateriales.getDesMaterial());
            ps.setString(4, inventarioMateriales.getUniMedida());
            ps.setInt(5, inventarioMateriales.getCodMaterial());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar el inventario de materiales: " + e.getMessage());
        }
        return r;
    }


    public static int eliminarInventarioMateriales(int codMaterial) {
        int r = 0;
        String sql = "DELETE FROM INVENTARIO_MATERIALES WHERE CODIGO_MATERIAL = ?;";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codMaterial);
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el inventario de materiales: " + e.getMessage());
        }
        return r;
    }




}
