package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import org.example.modelo.*;

import static org.example.Util.Constantes.*;

public class DAOusuario {

        PreparedStatement ps;
        ResultSet rs;
        Connection conn;
        ConexionBD conectar = new ConexionBD();
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
                        "Usuario (idUsuario, nombreUsuario, passwordUsuario, tipoUsuario) " +
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
                                statement.setString(2, usuario.getPasswordUsuario());
                                statement.setString(3, usuario.getNombreUsuario());
                                statement.setString(4, usuario.getTipoUsuario());


                                // Ejecutar la sentencia SQL
                                filasAfectadas = statement.executeUpdate();

                                System.out.println("Filas afectadas: " + filasAfectadas);
                        }
                        catch (SQLException e){System.err.println(ERROR_SENTENCIA_SQL + e.getMessage());}
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
                        System.out.println("Error al obtener la lista de todos: " + e.getMessage());
                }

                return usuarios;
        }

        public static boolean actualizarUsuario(Usuario usuarioModificado) {
                boolean isUpdated = false;

                // Sentencia SQL para actualizar el estudiante

                String sql_actualizar = "UPDATE Usuario SET idUsuario = ?, nombre = ?, passwordUsuario= ?, tipoUsuario= ?";

                // Obtener la conexión
                ConexionBD conexion = new ConexionBD();
                conexion.openConnection();
                Connection connection = conexion.getConnection();

                if (connection != null) {
                        try (PreparedStatement statement = connection.prepareStatement(sql_actualizar)) {
                                // Obtener los nuevos valores del estudiante que se actualizarán
                                String id_usuario = usuarioModificado.getIdUsuario();
                                String nombre = usuarioModificado.getNombreUsuario();
                                String pass = usuarioModificado.getPasswordUsuario();
                                String car = usuarioModificado.getTipoUsuario();


                                // Establecer los valores de los parámetros en la sentencia SQL
                                statement.setString(1,id_usuario);
                                statement.setString(2,nombre);
                                statement.setString(3,pass);


                                // Ejecutar la actualización
                                int filasActualizadas = statement.executeUpdate();

                                if (filasActualizadas > 0) {
                                        isUpdated = true;
                                        // System.out.println("El Estudiante con Id_usiario " + Id_usuario + " ha sido actualizado correctamente.");
                                } else {
                                        System.out.println("No se encontró el Estudiante con Id_usuario "  + id_usuario+ " en la base de datos.");
                                }
                        } catch (SQLException e) {
                                System.err.println(ERROR_ACTUALIZACION + e.getMessage());
                        } finally {
                                // Cerrar la conexión
                                conexion.closeConnection();
                        }
                }

                return isUpdated;
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
                                System.err.println(ERROR_DE_CONSULTA + e.getMessage());
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
                                        System.out.println(NO_SE_ENCONTRO_USUARIO + idUsuario);
                                }

                                resultSet.close();
                        } catch (SQLException e) {
                                System.err.println(ERROR_DE_CONSULTA + e.getMessage());
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
                                        System.out.println(NO_SE_ENCONTRO_USUARIO + idUsuario);
                                }

                                resultSet.close();
                        } catch (SQLException e) {
                                System.err.println(ERROR_DE_CONSULTA + e.getMessage());
                        } finally {
                                // Cerrar la conexión
                                conexion.closeConnection();
                        }
                }

                return tipoUsuario;
        }



}
