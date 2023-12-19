package org.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.example.modelo.*;

public class DAOtelProveedor {

        static PreparedStatement ps;
        static ResultSet rs;
        static Connection conn;
        static ConexionBD conectar = new ConexionBD();
        static  telProveedor p = new telProveedor();


    public static telProveedor obtenerTelProveedor(int nit_proveedor) {
            try {
                // hago la conexion y ejecuto la instruccion para obtener todos los datos
                // almacenandolos en un resultset
                conectar.openConnection();
                conn = conectar.getConnection();
                ps = conn.prepareStatement("SELECT * FROM  TEL_PROVEEDOR WHERE nit_PROVEEDOR = ?;");
                ps.setInt(1, nit_proveedor);
                rs = ps.executeQuery();

                // convierto los datos del resultset en objetos de estudiante y los agrego
                // a un List de estudiantes que posteriorment retornare
                while (rs.next()) {
                    telProveedor c = new telProveedor();
                    p.setNitProveedor(rs.getInt(1));
                    p.setTelefonoProveedor(rs.getString(2));

                }
            } catch (Exception e) {
                System.out.println("Error al obtener el telefono del proveedor: " + e.getMessage());
            }

            return p;

        }

    public static void tablatelProveedor(int nit_proveedor, JTable tabla) {
        try {
            String q;
            if (nit_proveedor != 0) {
                q = "SELECT * FROM TEL_PROVEEDOR WHERE nit_PROVEEDOR = ?";
            } else {
                q = "SELECT * FROM TEL_PROVEEDOR";
            }

            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(q);

                if (nit_proveedor  != 0) {
                    statement.setInt(1, nit_proveedor );
                }

                ResultSet rs = statement.executeQuery();

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("NIT_PROVEEDOR");
                model.addColumn("TEL_PROVEEDOR");

                while (rs.next()) {
                    Object[] rowData = {
                        rs.getInt("NIT_PROVEEDOR"),
                        rs.getString("TEL_PROVEEDOR"),
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
