package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.example.modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static org.example.Util.Constantes.ERROR_ACTUALIZACION;

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
            JOptionPane.showMessageDialog(null,"Error al obtener la lista de todos: " + e.getMessage());
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
            JOptionPane.showMessageDialog(null,"Error al obtener el uniforme: " + e.getMessage());
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


    public static boolean actualizarUniforme(uniforme uniformeModificado) {
        boolean isUpdated = false;

        String sqlActualizar = "UPDATE Uniforme SET ";
        String whereClause = " WHERE ID_PRENDA = ?";
        ArrayList<String> updates = new ArrayList<>();
        ArrayList<Object> values = new ArrayList<>();

        if (!uniformeModificado.getCaracEspecial().isEmpty()) {
            updates.add("CARAC_ESPECIAL = ?");
            values.add(uniformeModificado.getCaracEspecial());
        }

        if (uniformeModificado.getIdColegio() > 0) {
            updates.add("ID_COLEGIO = ?");
            values.add(uniformeModificado.getIdColegio());
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

                    statement.setInt(index, uniformeModificado.getIdPrenda());

                    int rowsUpdated = statement.executeUpdate();

                    if (rowsUpdated > 0) {
                        isUpdated = true;
                        System.out.println("Pedido actualizado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null,"No se encontró el pedido con el número: " + uniformeModificado.getIdPrenda());
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,ERROR_ACTUALIZACION + e.getMessage());
                } finally {
                    conexion.closeConnection();
                }
            }
        } else {
            System.out.println("No se han proporcionado datos para actualizar.");
        }

        return isUpdated;
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
            JOptionPane.showMessageDialog(null, "Error al eliminar el uniforme: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return r;
    }

    public static void tablauniformeID(int ID, JTable tabla) {
        try {
            String q;
            if (ID != 0) {
                q = "SELECT * FROM uniforme WHERE ID_PRENDA = ?";
            } else {
                q = "SELECT * FROM uniforme";
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
                model.addColumn("ID_PRENDA");
                model.addColumn("CARAC_ESPECIAL");
                model.addColumn("ID_COLEGIO");

                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("ID_PRENDA"),
                            rs.getString("CARAC_ESPECIAL"),
                            rs.getInt("ID_COLEGIO")
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
