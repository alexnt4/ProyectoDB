package org.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.example.modelo.*;
public class DAOproveedor {

        static PreparedStatement ps;
        static ResultSet rs;
        static Connection conn;
        static ConexionBD conectar = new ConexionBD();
        static  proveedor c = new proveedor();

        public static List<proveedor> obtenerProveedores(){
            List<proveedor> proveedores = new ArrayList<>();
            try {
                // hago la conexion y ejecuto la instruccion para obtener todos los datos
                // almacenandolos en un resultset
                conectar.openConnection();
                conn = conectar.getConnection();
                ps = conn.prepareStatement("SELECT * FROM PROVEEDOR;");
                rs = ps.executeQuery();

                // convierto los datos del resultset en objetos de estudiante y los agrego
                // a un List de estudiantes que posteriorment retornare
                while(rs.next()){
                    proveedor c = new proveedor();
                    c.setNitProveedor(rs.getInt(1));
                    c.setNombreProveedor(rs.getString(2));
                    c.setDireccionProveedor(rs.getString(3));
                    c.setContacto(rs.getString(4));
                    c.setProducto(rs.getString(5));
                    c.setCodMaterial(rs.getInt(6));

                    proveedores.add(c);
                }
            } catch (Exception e) {
                System.out.println("Error al obtener la lista de todos: " + e.getMessage());
            }

            return proveedores;
        }


        public static proveedor obtenerProveedor(int nitProveedor) {
            try {
                // hago la conexion y ejecuto la instruccion para obtener todos los datos
                // almacenandolos en un resultset
                conectar.openConnection();
                conn = conectar.getConnection();
                ps = conn.prepareStatement("SELECT * FROM  PROVEEDOR WHERE NIT_PROVEEDOR = ?;");
                ps.setInt(1, nitProveedor);
                rs = ps.executeQuery();

                // convierto los datos del resultset en objetos de estudiante y los agrego
                // a un List de estudiantes que posteriorment retornare
                while (rs.next()) {
                    proveedor c = new proveedor();
                    c.setNitProveedor(rs.getInt(1));
                    c.setNombreProveedor(rs.getString(2));
                    c.setDireccionProveedor(rs.getString(3));
                    c.setContacto(rs.getString(4));
                    c.setProducto(rs.getString(5));
                    c.setCodMaterial(rs.getInt(6));


                }
            } catch (Exception e) {
                System.out.println("Error al obtener el proveedor: " + e.getMessage());
            }

            return c;

        }


        public static int agregarProveedor(proveedor proveedor) {
            int r = 0;
            String sql = "INSERT INTO PROVEEDOR (NIT_PROVEEDOR, NOM_PROVEEDOR, DIR_PROVEEDOR, CON_PROVEEDOR, PRODUCTO, CODIGO_MATERIAL) VALUES (?,?,?,?,?,?);";
            try {
                conectar.openConnection();
                conn = conectar.getConnection();
                ps = conn.prepareStatement(sql);
                ps.setInt(1, proveedor.getNitProveedor());
                ps.setString(2, proveedor.getNombreProveedor());
                ps.setString(3, proveedor.getDireccionProveedor());
                ps.setString(4, proveedor.getContacto());
                ps.setString(5, proveedor.getProducto());
                ps.setInt(6, proveedor.getCodMaterial());
                r = ps.executeUpdate();
                if (r == 1) {
                    r = 1;
                } else {
                    r = 0;
                }
            } catch (Exception e) {
                System.out.println("Error al agregar el proveedor: " + e.getMessage());
            }
            return r;
        }


        public static int actualizarProveedor(proveedor proveedor) {
            int r = 0;
            String sql = "UPDATE PROVEEDOR SET NOM_PROVEEDOR = ?, DIR_PROVEEDOR = ?, CON_PROVEEDOR = ?, PRODUCTO = ?, CODIGO_MATERIAL = ? WHERE NIT_PROVEEDOR = ?;";
            try {
                conectar.openConnection();
                conn = conectar.getConnection();
                ps = conn.prepareStatement(sql);
                ps.setString(1, proveedor.getNombreProveedor());
                ps.setString(2, proveedor.getDireccionProveedor());
                ps.setString(3, proveedor.getContacto());
                ps.setString(4, proveedor.getProducto());
                ps.setInt(5, proveedor.getCodMaterial());
                ps.setInt(6, proveedor.getNitProveedor());
                r = ps.executeUpdate();
                if (r == 1) {
                    r = 1;
                } else {
                    r = 0;
                }
            } catch (Exception e) {
                System.out.println("Error al actualizar el proveedor: " + e.getMessage());
            }
            return r;
        }

        public static int eliminarProveedor(int nitProveedor) {
            int r = 0;
            String sql = "DELETE FROM PROVEEDOR WHERE NIT_PROVEEDOR = ?;";
            try {
                conectar.openConnection();
                conn = conectar.getConnection();
                ps = conn.prepareStatement(sql);
                ps.setInt(1, nitProveedor);
                r = ps.executeUpdate();
                if (r == 1) {
                    r = 1;
                } else {
                    r = 0;
                }
            } catch (Exception e) {
                System.out.println("Error al eliminar el proveedor: " + e.getMessage());
            }
            return r;
        }
}
