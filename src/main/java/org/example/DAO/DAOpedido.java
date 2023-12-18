package org.example.DAO;

import org.example.modelo.pedido;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.example.Util.Constantes.ERROR_ACTUALIZACION;
import static org.example.Util.Constantes.ERROR_DE_CONSULTA;

public class DAOpedido {

    public static int agregarPedido(pedido pedido) {
        String sqlGuardar = "INSERT INTO Pedido (NUM_PED, FEC_ENCARGADO, ABONO, FEC_ENTREGA, MED_PERSONA, ESTADO, DOC_CLIENTE, FACTURA_VENTA, MONTO_TOTAL) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        int filasAfectadas = 0;

        ConexionBD conexion = new ConexionBD();
        conexion.openConnection();
        Connection connection = conexion.getConnection();

        if (connection != null) {
            try (PreparedStatement statement = connection.prepareStatement(sqlGuardar)) {
                statement.setInt(1, pedido.getNumPedido());
                statement.setDate(2, new java.sql.Date(pedido.getFechaEncargado().getTime())); // Cambio aquí
                statement.setDouble(3, pedido.getAbono());
                statement.setDate(4, new java.sql.Date(pedido.getFechaEntrega().getTime())); // Cambio aquí
                statement.setString(5, pedido.getMedPersona());
                statement.setString(6, pedido.getEstado());
                statement.setInt(7, pedido.getDocCliente());
                statement.setInt(8, pedido.getFacVenta());
                statement.setDouble(9, pedido.getMontoTotal());

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

    public static List<pedido> obtenerPedidos() {
        List<pedido> pedidos = new ArrayList<>();

        ConexionBD conexion = new ConexionBD();
        conexion.openConnection();
        Connection connection = conexion.getConnection();

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM pedido");

                while (resultSet.next()) {
                    pedido pedido = new pedido();
                    pedido.setNumPedido(resultSet.getInt("NUM_PED"));
                    pedido.setFechaEncargado(resultSet.getDate("FEC_ENCARGADO"));
                    pedido.setAbono(resultSet.getDouble("ABONO"));
                    pedido.setFechaEntrega(resultSet.getDate("FEC_ENTREGA"));
                    pedido.setMedPersona(resultSet.getString("MED_PERSONA"));
                    pedido.setEstado(resultSet.getString("ESTADO"));
                    pedido.setDocCliente(resultSet.getInt("DOC_CLIENTE"));
                    pedido.setFacVenta(resultSet.getInt("FACTURA_VENTA"));
                    pedido.setMontoTotal(resultSet.getDouble("MONTO_TOTAL"));

                    // Debug: Imprimir los datos obtenidos para cada pedido
                    System.out.println("Pedido obtenido: " + pedido.getNumPedido() + " - " + pedido.getEstado());

                    pedidos.add(pedido);
                }
            } catch (SQLException e) {
                System.err.println(ERROR_DE_CONSULTA + e.getMessage());
            } finally {
                conexion.closeConnection();
            }
        } else {
            System.err.println("Error al establecer la conexión a la base de datos.");
        }
        return pedidos;
    }


    public static boolean actualizarPedido(pedido pedidoModificado) {
        boolean isUpdated = false;

        String sqlActualizar = "UPDATE Pedido SET FEC_ENCARGADO = ?, ABONO = ?, FEC_ENTREGA = ?, MED_PERSONA = ?, ESTADO = ?, DOC_CLIENTE = ?, FACTURA_VENTA = ?, MONTO_TOTAL = ? WHERE NUM_PED = ?";

        ConexionBD conexion = new ConexionBD();
        conexion.openConnection();
        Connection connection = conexion.getConnection();

        if (connection != null) {
            try (PreparedStatement statement = connection.prepareStatement(sqlActualizar)) {
                statement.setDate(1, new java.sql.Date(pedidoModificado.getFechaEncargado().getTime())); // Cambio aquí
                statement.setDouble(2, pedidoModificado.getAbono());
                statement.setDate(3, new java.sql.Date(pedidoModificado.getFechaEntrega().getTime())); // Cambio aquí
                statement.setString(4, pedidoModificado.getMedPersona());
                statement.setString(5, pedidoModificado.getEstado());
                statement.setInt(6, pedidoModificado.getDocCliente());
                statement.setInt(7, pedidoModificado.getFacVenta());
                statement.setDouble(8, pedidoModificado.getMontoTotal());
                statement.setInt(9, pedidoModificado.getNumPedido());

                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {
                    isUpdated = true;
                    System.out.println("Pedido actualizado correctamente");
                } else {
                    System.out.println("No se encontró el pedido con el número: " + pedidoModificado.getNumPedido());
                }
            } catch (SQLException e) {
                System.err.println(ERROR_ACTUALIZACION + e.getMessage());
            } finally {
                conexion.closeConnection();
            }
        }

        return isUpdated;
    }

    public static boolean eliminarPedido(int numPedido) {
        boolean isDeleted = false;

        String sqlEliminar = "DELETE FROM Pedido WHERE NUM_PED = ?";

        ConexionBD conexion = new ConexionBD();
        conexion.openConnection();
        Connection connection = conexion.getConnection();

        if (connection != null) {
            try (PreparedStatement statement = connection.prepareStatement(sqlEliminar)) {
                statement.setInt(1, numPedido);

                int rowsDeleted = statement.executeUpdate();

                if (rowsDeleted > 0) {
                    isDeleted = true;
                    System.out.println("Pedido eliminado correctamente");
                } else {
                    System.out.println("No se encontró el pedido con el número: " + numPedido);
                }
            } catch (SQLException e) {
                System.err.println(ERROR_ACTUALIZACION + e.getMessage());
            } finally {
                conexion.closeConnection();
            }
        }

        return isDeleted;
    }

    public static pedido obtenerPedidoPorNumero(int numPedido) {
        pedido pedidoEncontrado = null;

        ConexionBD conexion = new ConexionBD();
        conexion.openConnection();
        Connection connection = conexion.getConnection();

        if (connection != null) {
            try {
                String sql = "SELECT * FROM pedido WHERE NUM_PED = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, numPedido);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    pedidoEncontrado = new pedido();
                    pedidoEncontrado.setNumPedido(resultSet.getInt("NUM_PED"));
                    pedidoEncontrado.setFechaEncargado(resultSet.getDate("FEC_ENCARGADO"));
                    pedidoEncontrado.setAbono(resultSet.getDouble("ABONO"));
                    pedidoEncontrado.setFechaEntrega(resultSet.getDate("FEC_ENTREGA"));
                    pedidoEncontrado.setMedPersona(resultSet.getString("MED_PERSONA"));
                    pedidoEncontrado.setEstado(resultSet.getString("ESTADO"));
                    pedidoEncontrado.setDocCliente(resultSet.getInt("DOC_CLIENTE"));
                    pedidoEncontrado.setFacVenta(resultSet.getInt("FACTURA_VENTA"));
                    pedidoEncontrado.setMontoTotal(resultSet.getDouble("MONTO_TOTAL"));
                }
            } catch (SQLException e) {
                System.err.println(ERROR_DE_CONSULTA + e.getMessage());
            } finally {
                conexion.closeConnection();
            }
        } else {
            System.err.println("Error al establecer la conexión a la base de datos.");
        }

        return pedidoEncontrado;
    }




    public static void main(String[] args) {
        pedido pedidoBuscado = DAOpedido.obtenerPedidoPorNumero(5001);
        System.out.println(pedidoBuscado.getFechaEncargado());


        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // Insertar un nuevo pedido
            Date fechaEncargado = new Date(sdf.parse("2023-12-17").getTime());
            Date fechaEntrega = new Date(sdf.parse("2023-12-18").getTime());
            pedido nuevoPedido = new pedido(1, fechaEncargado, 100.00, fechaEntrega, "Juan", "Pendiente", 10001, 001, 500.00);

            int filasAfectadas = DAOpedido.agregarPedido(nuevoPedido);
            if (filasAfectadas > 0) {
                System.out.println("Se ha agregado un nuevo pedido.");
            } else {
                System.out.println("Hubo un problema al agregar el pedido.");
            }



            // Obtener la lista de pedidos
            List<pedido> pedidos = DAOpedido.obtenerPedidos();

            if (pedidos.isEmpty()) {
                System.out.println("No se encontraron pedidos.");
            } else {
                System.out.println("Lista de pedidos:");
                for (pedido pedido : pedidos) {
                    System.out.println(pedido.getNumPedido() + " - " + pedido.getEstado());
                }
            }

            // Actualizar un pedido existente
            pedido pedidoExistente = DAOpedido.obtenerPedidoPorNumero(1);
            if (pedidoExistente != null) {
                pedidoExistente.setFechaEncargado(new Date(sdf.parse("2023-12-18").getTime()));
                pedidoExistente.setAbono(150.00);
                pedidoExistente.setFechaEntrega(new Date(sdf.parse("2023-12-20").getTime()));
                pedidoExistente.setMedPersona("María");
                pedidoExistente.setEstado("En proceso");
                pedidoExistente.setDocCliente(10001); // Asegúrate de que este número exista en la base de datos
                pedidoExistente.setFacVenta(002);
                pedidoExistente.setMontoTotal(600.00);

                boolean actualizado = DAOpedido.actualizarPedido(pedidoExistente);

                if (actualizado) {
                    System.out.println("Pedido actualizado correctamente.");
                } else {
                    System.out.println("Hubo un problema al actualizar el pedido.");
                }
            } else {
                System.out.println("El pedido no existe en la base de datos.");
            }




            // Eliminar un pedido (cambiar por un número de pedido existente)
            int numeroPedidoAEliminar = 1;
            boolean eliminado = DAOpedido.eliminarPedido(numeroPedidoAEliminar);
            if (eliminado) {
                System.out.println("El pedido con número " + numeroPedidoAEliminar + " ha sido eliminado.");
            } else {
                System.out.println("No se encontró el pedido con número " + numeroPedidoAEliminar);
            }



        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    }
