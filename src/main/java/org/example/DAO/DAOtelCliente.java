package org.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.example.modelo.*;

public class DAOtelCliente{

        static PreparedStatement ps;
        static ResultSet rs;
        static Connection conn;
        static ConexionBD conectar = new ConexionBD();
        static  telCliente cl = new telCliente();


    public static telCliente obtenertelCliente(int nit_Cliente) {
            try {
                // hago la conexion y ejecuto la instruccion para obtener todos los datos
                // almacenandolos en un resultset
                conectar.openConnection();
                conn = conectar.getConnection();
                ps = conn.prepareStatement("SELECT * FROM  TEL_Cliente WHERE doc_cliente = ?;");
                ps.setInt(1, nit_Cliente);
                rs = ps.executeQuery();

                // convierto los datos del resultset en objetos de estudiante y los agrego
                // a un List de estudiantes que posteriorment retornare
                while (rs.next()) {
                    telCliente cl = new telCliente();
                    cl.setIdCliente(rs.getInt(1));
                    cl.setTelefonoCliente(rs.getString(2));

                }
            } catch (Exception e) {
                System.out.println("Error al obtener el telefono del Cliente: " + e.getMessage());
            }

            return cl;

        }

    public static void tablatelCliente(int doc_Cliente, JTable tabla) {
        try {
            String q;
            if (doc_Cliente != 0) {
                q = "SELECT * FROM TEL_Cliente WHERE doc_cliente = ?";
            } else {
                q = "SELECT * FROM TEL_Cliente";
            }

            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(q);

                if (doc_Cliente  != 0) {
                    statement.setInt(1, doc_Cliente );
                }

                ResultSet rs = statement.executeQuery();

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("doc_cliente");
                model.addColumn("TEL_Cliente");

                while (rs.next()) {
                    Object[] rowData = {
                        rs.getInt("doc_cliente"),
                        rs.getString("TEL_Cliente"),
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
