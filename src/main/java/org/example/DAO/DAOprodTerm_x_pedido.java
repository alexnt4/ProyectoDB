package org.example.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.example.modelo.*;
import static org.example.Util.Constantes.ERROR_ACTUALIZACION;

public class DAOprodTerm_x_pedido {
    static PreparedStatement ps;
    static ResultSet rs;
    static Connection conn;
    static ConexionBD conectar = new ConexionBD();
    static prodTerm_x_pedido  c = new prodTerm_x_pedido ();

    public static List<prodTerm_x_pedido > obtenerprodTerm_x_pedido (){
        List<prodTerm_x_pedido > prodTerm_x_pedido  = new ArrayList<>();
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM prodTerm_x_pedido ;");
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while(rs.next()){
                prodTerm_x_pedido  c = new prodTerm_x_pedido ();
                c.setNumPedido(rs.getInt(1));
                c.setCodProdTerm(rs.getInt(2));
                prodTerm_x_pedido .add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de todos: " + e.getMessage());
        }

        return prodTerm_x_pedido ;
    }



    public static void tablaProdTerm_x_pedidoID(int ID, JTable tabla) {
        try {
            String q;
            if (ID != 0) {
                q = "SELECT * FROM prodTerm_x_pedido WHERE NUM_PED = ?";
            } else {
                q = "SELECT * FROM prodTerm_x_pedido";
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
                model.addColumn("NUM_PED");
                model.addColumn("COD_PRODTERM");


                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("NUM_PED"),
                            rs.getInt("COD_PRODTERM"),
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

    public static void insertarprodTerm_x_pedido (prodTerm_x_pedido  c) {
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("INSERT INTO prodTerm_x_pedido  VALUES (?,?);");
            ps.setInt(1, c.getNumPedido());
            ps.setInt(2, c.getCodProdTerm());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "prodTerm_x_pedido  insertado correctamente");
        } catch (SQLException e) {
            System.out.println(ERROR_ACTUALIZACION + e.getMessage());
        }
    }

    public static void actualizarprodTerm_x_pedido (prodTerm_x_pedido  c) {
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("UPDATE prodTerm_x_pedido  SET COD_PRODTERM = ? WHERE NUM_PED = ?;");
            ps.setInt(1, c.getCodProdTerm());
            ps.setInt(2, c.getNumPedido());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "prodTerm_x_pedido  actualizado correctamente");
        } catch (SQLException e) {
            System.out.println(ERROR_ACTUALIZACION + e.getMessage());
        }
    }

    public static void eliminarprodTerm_x_pedido(int numPedido, int codProdTerm) {
        try {
            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            // Deshabilitar restricciones de clave foránea temporalmente
            //String disableForeignKey = "SET FOREIGN_KEY_CHECKS=0;";
            //String enableForeignKey = "SET FOREIGN_KEY_CHECKS=1;";

            // Eliminar la referencia en PEDIDO
            //String deleteFromPedido = "UPDATE PEDIDO SET COD_PRODTERM = NULL WHERE NUM_PED = ? AND COD_PRODTERM = ?;";

            // Eliminar el registro en PRODTERM_X_PEDIDO
            String deleteFromProdTermXPedido = "DELETE FROM PRODTERM_X_PEDIDO WHERE NUM_PED = ? AND COD_PRODTERM = ?;";

            if (connection != null) {
                try (//PreparedStatement disableFK = connection.prepareStatement(disableForeignKey);
                     //PreparedStatement enableFK = connection.prepareStatement(enableForeignKey);
                     //PreparedStatement deletePedido = connection.prepareStatement(deleteFromPedido);
                     PreparedStatement deleteProdTermXPedido = connection.prepareStatement(deleteFromProdTermXPedido)) {

                    // Deshabilitar restricciones de clave foránea
                    //disableFK.executeUpdate();

                    // Eliminar la referencia en PEDIDO
                    //deletePedido.setInt(1, numPedido);
                    //deletePedido.setInt(2, codProdTerm);
                    //deletePedido.executeUpdate();

                    // Eliminar el registro en PRODTERM_X_PEDIDO
                    deleteProdTermXPedido.setInt(1, numPedido);
                    deleteProdTermXPedido.setInt(2, codProdTerm);
                    deleteProdTermXPedido.executeUpdate();

                    // Habilitar restricciones de clave foránea nuevamente
                    //enableFK.executeUpdate();

                    JOptionPane.showMessageDialog(null, "prodTerm_x_pedido eliminado correctamente");
                }
            }
        } catch (SQLException e) {
            System.out.println(ERROR_ACTUALIZACION + e.getMessage());
        }
    }



}