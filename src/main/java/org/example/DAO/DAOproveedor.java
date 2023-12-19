package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.example.modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static org.example.Util.Constantes.ERROR_ACTUALIZACION;

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
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de todos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
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
            JOptionPane.showMessageDialog(null, "Error al obtener el proveedor " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
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
            JOptionPane.showMessageDialog(null, "Error al agregar el proveedor " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return r;
    }


    public static boolean actualizarProveedor(proveedor proveedorModificado) {
        boolean isUpdated = false;

        String sqlActualizar = "UPDATE Proveedor SET ";
        String whereClause = " WHERE NIT_PROVEEDOR = ?";
        ArrayList<String> updates = new ArrayList<>();
        ArrayList<Object> values = new ArrayList<>();

        if (!proveedorModificado.getNombreProveedor().isEmpty()) {
            updates.add("NOM_PROVEEDOR = ?");
            values.add(proveedorModificado.getNombreProveedor());
        }

        if (!proveedorModificado.getDireccionProveedor().isEmpty()){
            updates.add("DIR_PROVEEDOR = ?");
            values.add(proveedorModificado.getDireccionProveedor());
        }

        if (!proveedorModificado.getContacto().isEmpty()) {
            updates.add("CON_PROVEEDOR = ?");
            values.add(proveedorModificado.getContacto());
        }

        if (!proveedorModificado.getProducto().isEmpty()) {
            updates.add("PRODUCTO = ?");
            values.add(proveedorModificado.getProducto());
        }

        if (proveedorModificado.getCodMaterial() > 0) {
            updates.add("CODIGO_MATERIAL = ?");
            values.add(proveedorModificado.getCodMaterial());
        }

        if (!updates.isEmpty()) {
            sqlActualizar += String.join(", ", updates) + whereClause;

            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(sqlActualizar)) {
                    int index = 1;

                    for (Object value : values) {
                        if (value instanceof Date) {
                            statement.setDate(index++, (Date) value);
                        } else if (value instanceof Double) {
                            statement.setDouble(index++, (Double) value);
                        } else if (value instanceof Integer) {
                            statement.setInt(index++, (Integer) value);
                        } else if (value instanceof String) {
                            statement.setString(index++, (String) value);
                        }
                    }

                    statement.setInt(index, proveedorModificado.getNitProveedor());

                    int rowsUpdated = statement.executeUpdate();

                    if (rowsUpdated > 0) {
                        isUpdated = true;
                        System.out.println("Proveedor actualizado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el proveedor con el número: " + proveedorModificado.getNitProveedor());
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,ERROR_ACTUALIZACION + e.getMessage());
                    e.printStackTrace();
                } finally {
                    conexion.closeConnection();
                }
            }
        } else {
            System.out.println("No se han proporcionado datos para actualizar.");
        }

        return isUpdated;
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
            JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return r;
    }

    public static void tablaproveedorNIT(int NIT, JTable tabla) {
        try {
            String q;
            if (NIT != 0) {
                q = "SELECT * FROM proveedor WHERE NIT_PROVEEDOR = ?";
            } else {
                q = "SELECT * FROM proveedor";
            }

            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(q);

                if (NIT != 0) {
                    statement.setInt(1, NIT);
                }

                ResultSet rs = statement.executeQuery();

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("NIT_PROVEEDOR");
                model.addColumn("NOM_PROVEEDOR");
                model.addColumn("DIR_PROVEEDOR");
                model.addColumn("CON_PROVEEDOR");
                model.addColumn("PRODUCTO");
                model.addColumn("CODIGO_MATERIAL");

                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("NIT_PROVEEDOR"),
                            rs.getString("NOM_PROVEEDOR"),
                            rs.getString("DIR_PROVEEDOR"),
                            rs.getString("CON_PROVEEDOR"),
                            rs.getString("PRODUCTO"),
                            rs.getInt("CODIGO_MATERIAL"),
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
}
