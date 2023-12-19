package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import org.example.modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static org.example.Util.Constantes.*;

public class DAOusuario {

        static PreparedStatement ps;
        ResultSet rs;
        static Connection conn;
        static ConexionBD conectar = new ConexionBD();
        Usuario u = new Usuario();

        /*public List<usuario> obtenerUsuarios(){
            List<usuario> usuarios = new ArrayList<>();
            try {
                // hago la conexion y ejecuto la instruccion para obtener todos los datos
                // almacenandolos en un resultset
                conectar.openConnection();
                conn = conectar.getConnection();*/
        public static int AgregarUsuario(Usuario usuario){
                String sql_guardar;
                sql_guardar="INSERT INTO " +
                        "Usuario (id_Usuario, nombre, contrasena, cargo) " +
                        "VALUES (?, ?, ?, ?)";

                int filasAfectadas = 0;

                // Obtener la conexión
                ConexionBD conexion = new ConexionBD();
                conexion.openConnection();
                Connection connection = conexion.getConnection();
                if (connection != null) {
                        try(PreparedStatement statement = connection.prepareStatement(sql_guardar)){
                                // Establecer los valores de los parámetros en la sentencia SQL
                                statement.setString(1, usuario.getIdUsuario());
                                statement.setString(2, usuario.getNombreUsuario());
                                statement.setString(3, usuario.getPasswordUsuario());
                                statement.setString(4, usuario.getTipoUsuario());


                                // Ejecutar la sentencia SQL
                                filasAfectadas = statement.executeUpdate();

                                System.out.println("Filas afectadas: " + filasAfectadas);
                        }
                        catch (SQLException e){JOptionPane.showMessageDialog(null,ERROR_SENTENCIA_SQL + e.getMessage());}
                        catch(Exception e){ System.out.println(e); }
                        finally {
                                // Cerrar la conexión
                                conexion.closeConnection();
                        }
                }
                return filasAfectadas;
        }

        public List<Usuario> obtenerUsuario(){
                List<Usuario> usuarios = new ArrayList<>();
                try {
                        // hago la conexion y ejecuto la instruccion para obtener todos los datos
                        // almacenandolos en un resultset
                        conectar.openConnection();
                        conn = conectar.getConnection();
                        ps = conn.prepareStatement("SELECT * FROM Usuario;");
                        rs = ps.executeQuery();

                        // convierto los datos del resultset en objetos de estudiante y los agrego
                        // a un List de estudiantes que posteriorment retornare
                        while(rs.next()){
                                Usuario u = new Usuario();
                                u.setIdUsuario(rs.getString(1));
                                u.setNombreUsuario(rs.getString(2));


                                usuarios.add(u);
                        }
                } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,"Error al obtener la lista de todos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

                return usuarios;
        }


        public Usuario obtenerUsuarioPorID(String idUsuario) {
                Usuario usuario = new Usuario();
                String sql_consulta = "SELECT * FROM Usuario WHERE id_usuario = ?";

                // Obtener la conexión
                ConexionBD conexion = new ConexionBD();
                conexion.openConnection();
                Connection connection = conexion.getConnection();

                if (connection != null) {
                        try (PreparedStatement statement = connection.prepareStatement(sql_consulta)) {
                                // Establecer el valor del parámetro en la sentencia SQL
                                statement.setString(1, String.valueOf(idUsuario));

                                // Ejecutar la consulta
                                ResultSet resultSet = statement.executeQuery();

                                if (resultSet.next()) {
                                        // Obtener los valores de las columnas y asignarlos al objeto Usuario
                                        usuario.setIdUsuario(resultSet.getString("id_usuario"));
                                        usuario.setNombreUsuario(resultSet.getString("nombre"));
                                        usuario.setPasswordUsuario(resultSet.getString("contrasena"));
                                        usuario.setTipoUsuario(resultSet.getString("cargo"));

                                }

                                resultSet.close();
                        } catch (SQLException e) {
                                JOptionPane.showMessageDialog(null, ERROR_DE_CONSULTA + e.getMessage());
                        } finally {
                                // Cerrar la conexión
                                conexion.closeConnection();
                        }
                }

                return usuario;
        }

        public static String obtenerNombreUsuarioPorID(String idUsuario) {
                String nombreUsuario = null;
                String sql_consulta = "SELECT nombre FROM Usuario WHERE id_usuario = ?";

                // Obtener la conexión
                ConexionBD conexion = new ConexionBD();
                conexion.openConnection();
                Connection connection = conexion.getConnection();

                if (connection != null) {
                        try (PreparedStatement statement = connection.prepareStatement(sql_consulta)) {
                                // Establecer el valor del parámetro en la sentencia SQL
                                statement.setInt(1, Integer.parseInt(idUsuario));

                                // Ejecutar la consulta
                                ResultSet resultSet = statement.executeQuery();

                                if (resultSet.next()) {
                                        // Obtener el valor del campo "nombre_usuario"
                                        nombreUsuario = resultSet.getString("nombre");
                                } else {
                                        JOptionPane.showMessageDialog(null, NO_SE_ENCONTRO_USUARIO + idUsuario);
                                }

                                resultSet.close();
                        } catch (SQLException e) {
                                JOptionPane.showMessageDialog(null, ERROR_DE_CONSULTA + e.getMessage());
                        } finally {
                                // Cerrar la conexión
                                conexion.closeConnection();
                        }
                }

                return nombreUsuario;
        }

        public static String obtenerTipoUsuarioPorID(String idUsuario) {
                String tipoUsuario = null;
                String sql_consulta = "SELECT cargo FROM Usuario WHERE id_usuario = ?::integer";

                // Obtener la conexión
                ConexionBD conexion = new ConexionBD();
                conexion.openConnection();
                Connection connection = conexion.getConnection();

                if (connection != null) {
                        try (PreparedStatement statement = connection.prepareStatement(sql_consulta)) {
                                // Establecer el valor del parámetro en la sentencia SQL
                                statement.setInt(1, Integer.parseInt(idUsuario));

                                // Ejecutar la consulta
                                ResultSet resultSet = statement.executeQuery();

                                if (resultSet.next()) {
                                        // Obtener el valor del campo "nombre_usuario"
                                        tipoUsuario = resultSet.getString("cargo");
                                } else {
                                        JOptionPane.showMessageDialog(null,NO_SE_ENCONTRO_USUARIO + idUsuario);
                                }

                                resultSet.close();
                        } catch (SQLException e) {
                                JOptionPane.showMessageDialog(null,ERROR_DE_CONSULTA + e.getMessage());
                        } finally {
                                // Cerrar la conexión
                                conexion.closeConnection();
                        }
                }

                return tipoUsuario;
        }

        public static void tablaUsuarioID(String ID, JTable tabla) {
                try {
                        String q;
                        if (!Objects.equals(ID, "Todo")) {
                                q = "SELECT * FROM usuario WHERE ID_USUARIO = ?";
                        } else {
                                q = "SELECT * FROM usuario";
                        }

                        ConexionBD conexion = new ConexionBD();
                        conexion.openConnection();
                        Connection connection = conexion.getConnection();

                        if (connection != null) {
                                PreparedStatement statement = connection.prepareStatement(q);

                                if (!Objects.equals(ID, "Todo")) {
                                        statement.setString(1, ID);
                                }

                                ResultSet rs = statement.executeQuery();

                                DefaultTableModel model = new DefaultTableModel();
                                model.addColumn("ID_USUARIO");
                                model.addColumn("NOMBRE");
                                model.addColumn("CONTRASENA");
                                model.addColumn("CARGO");


                                while (rs.next()) {
                                        Object[] rowData = {
                                                rs.getString("ID_USUARIO"),
                                                rs.getString("NOMBRE"),
                                                rs.getString("CONTRASENA"),
                                                rs.getString("CARGO")
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

        public static boolean actualizarUsuario(Usuario usuarioModificado) {
                boolean isUpdated = false;

                String sqlActualizar = "UPDATE usuario SET ";
                String whereClause = " WHERE ID_USUARIO = ?";
                ArrayList<String> updates = new ArrayList<>();
                ArrayList<Object> values = new ArrayList<>();

                if (!usuarioModificado.getNombreUsuario().isEmpty()) {
                        updates.add("NOMBRE = ?");
                        values.add(usuarioModificado.getNombreUsuario());
                }

                if (!usuarioModificado.getPasswordUsuario().isEmpty()) {
                        updates.add("CONTRASENA = ?");
                        values.add(usuarioModificado.getPasswordUsuario());
                }
                if (!usuarioModificado.getTipoUsuario().isEmpty()) {
                        updates.add("CARGO = ?");
                        values.add(usuarioModificado.getTipoUsuario());
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

                                        statement.setString(index, usuarioModificado.getIdUsuario());

                                        int rowsUpdated = statement.executeUpdate();

                                        if (rowsUpdated > 0) {
                                                isUpdated = true;
                                                System.out.println("Usuario actualizado correctamente");
                                        } else {
                                                JOptionPane.showMessageDialog(null,"No se encontró el usuario con el id: " + usuarioModificado.getIdUsuario());
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


        public static int eliminarUsuario(String idPrenda) {
                int r = 0;
                String sql = "DELETE FROM USUARIO WHERE ID_USUARIO = ?;";
                try {
                        conectar.openConnection();
                        conn = conectar.getConnection();
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, idPrenda);
                        r = ps.executeUpdate();
                        if (r == 1) {
                                r = 1;
                        } else {
                                r = 0;
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,"Error al eliminar el usuario: " + e.getMessage());
                }
                return r;
        }
}
