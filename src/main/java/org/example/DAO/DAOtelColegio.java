package org.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.example.modelo.*;

public class DAOtelColegio {

        static PreparedStatement ps;
        static ResultSet rs;
        static Connection conn;
        static ConexionBD conectar = new ConexionBD();
        static  telColegio c = new telColegio();


    public static telColegio obtenerTelColegio(int idColegio) {
            try {
                // hago la conexion y ejecuto la instruccion para obtener todos los datos
                // almacenandolos en un resultset
                conectar.openConnection();
                conn = conectar.getConnection();
                ps = conn.prepareStatement("SELECT * FROM  TEL_COLEGIO WHERE ID_COLEGIO = ?;");
                ps.setInt(1, idColegio);
                rs = ps.executeQuery();

                // convierto los datos del resultset en objetos de estudiante y los agrego
                // a un List de estudiantes que posteriorment retornare
                while (rs.next()) {
                    telColegio c = new telColegio();
                    c.setIdColegio(rs.getInt(1));
                    c.setTelefonoColegio(rs.getString(2));

                }
            } catch (Exception e) {
                System.out.println("Error al obtener el telefono del colegio: " + e.getMessage());
            }

            return c;

        }

    public static void tablaTelColegio(int id_colegio, JTable tabla) {
        try {
            String q;
            if (id_colegio != 0) {
                q = "SELECT * FROM TEL_COLEGIO WHERE ID_COLEGIO = ?";
            } else {
                q = "SELECT * FROM TEL_COLEGIO";
            }

            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(q);

                if (id_colegio  != 0) {
                    statement.setInt(1, id_colegio );
                }

                ResultSet rs = statement.executeQuery();

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID_COLEGIO");
                model.addColumn("TEL_COLEGIO");

                while (rs.next()) {
                    Object[] rowData = {
                        rs.getInt("ID_COLEGIO"),
                        rs.getString("TEL_COLEGIO"),
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
