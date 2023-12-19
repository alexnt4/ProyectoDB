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

import static org.example.Util.Constantes.*;

//import static org.example.Util.Constantes.ERROR_ACTUALIZACION;

public class DAOcliente {

    static PreparedStatement ps;
    static ResultSet rs;
    static Connection conn;
    static ConexionBD conectar = new ConexionBD();
    static cliente c = new cliente();

    public List<cliente> obtenerClientes(){
        List<cliente> clientes = new ArrayList<>();
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM cliente;");
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while(rs.next()){
                cliente c = new cliente();
                c.setIdCliente(rs.getInt(1));
                c.setNombreCliente(rs.getString(2));


                clientes.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la lista de todos: " + e.getMessage());
        }

        return clientes;
    }

    public static void tablaclienteID(int ID, JTable tabla) {
        try {
            String q;
            if (ID != 0) {
                q = "SELECT * FROM cliente WHERE DOC_CLIENTE = ?";
            } else {
                q = "SELECT * FROM cliente";
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
                model.addColumn("DOC_CLIENTE");
                model.addColumn("NOM_CLIENTE");


                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("DOC_CLIENTE"),
                            rs.getString("NOM_CLIENTE"),
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


    public static cliente obtenerCliente(int idCliente){
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM cliente WHERE DOC_CLIENTE = ?;");
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while(rs.next()){
                c.setIdCliente(rs.getInt(1));
                c.setNombreCliente(rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la lista de todos: " + e.getMessage());
        }

        return c;
    }

    public static int agregarCliente(cliente cliente) {
        String sqlGuardar = "INSERT INTO cliente (DOC_CLIENTE, NOM_CLIENTE) " +
                "VALUES (?, ?)";

        int filasAfectadas = 0;

        ConexionBD conexion = new ConexionBD();
        conexion.openConnection();
        Connection connection = conexion.getConnection();

        if (connection != null) {
            try (PreparedStatement statement = connection.prepareStatement(sqlGuardar)) {
                statement.setInt(1, cliente.getIdCliente());
                statement.setString(2, cliente.getNombreCliente());


                filasAfectadas = statement.executeUpdate();
                System.out.println("Filas afectadas al agregar pedido: " + filasAfectadas);
            } catch (SQLException e) {
                System.err.println(ERROR_ACTUALIZACION + e.getMessage());
            } finally {
                conexion.closeConnection();
            }
        }
        return filasAfectadas;
    }

    public static int actualizarCliente(cliente cliente) {
        String sqlActualizar = "UPDATE cliente SET DOC_CLIENTE = ?, NOM_CLIENTE = ? WHERE DOC_CLIENTE = ?";

        int filasAfectadas = 0;

        ConexionBD conexion = new ConexionBD();
        conexion.openConnection();
        Connection connection = conexion.getConnection();

        if (connection != null) {
            try (PreparedStatement statement = connection.prepareStatement(sqlActualizar)) {
                statement.setInt(1, cliente.getIdCliente());
                statement.setString(2, cliente.getNombreCliente());
                statement.setInt(3, cliente.getIdCliente());

                filasAfectadas = statement.executeUpdate();
                System.out.println("Filas afectadas al actualizar pedido: " + filasAfectadas);
            } catch (SQLException e) {
                System.err.println(ERROR_ACTUALIZACION + e.getMessage());
            } finally {
                conexion.closeConnection();
            }
        }
        return filasAfectadas;
    }

    public static int eliminarCliente(int idCliente) {
        String sqlEliminar = "DELETE FROM cliente WHERE DOC_CLIENTE = ?";

        int filasAfectadas = 0;

        ConexionBD conexion = new ConexionBD();
        conexion.openConnection();
        Connection connection = conexion.getConnection();

        if (connection != null) {
            try (PreparedStatement statement = connection.prepareStatement(sqlEliminar)) {
                statement.setInt(1, idCliente);

                filasAfectadas = statement.executeUpdate();
                System.out.println("Filas afectadas al eliminar pedido: " + filasAfectadas);
            } catch (SQLException e) {
                System.err.println(ERROR_ACTUALIZACION + e.getMessage());
            } finally {
                conexion.closeConnection();
            }
        }
        return filasAfectadas;
    }






    public static void main(String[] args) {
        DAOcliente dao = new DAOcliente();
        List<cliente> clientes = dao.obtenerClientes();
        for (cliente c : clientes) {
            System.out.println(c.getIdCliente() + " " + c.getNombreCliente());
        }
    }
    


}
