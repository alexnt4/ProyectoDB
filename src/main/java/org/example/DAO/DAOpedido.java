package org.example.DAO;

import org.example.modelo.pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
                JOptionPane.showMessageDialog(null, "Error al agregar pedido: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Error al obtener pedidos: " + e.getMessage() + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
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

        String sqlActualizar = "UPDATE Pedido SET ";
        String whereClause = " WHERE NUM_PED = ?";
        ArrayList<String> updates = new ArrayList<>();
        ArrayList<Object> values = new ArrayList<>();

        if (pedidoModificado.getFechaEncargado() != null) {
            updates.add("FEC_ENCARGADO = ?");
            values.add(new java.sql.Date(pedidoModificado.getFechaEncargado().getTime()));
        }

        if (pedidoModificado.getAbono() != null && pedidoModificado.getAbono() > 0) {
            updates.add("ABONO = ?");
            values.add(pedidoModificado.getAbono());
        }

        if (pedidoModificado.getFechaEntrega() != null) {
            updates.add("FEC_ENTREGA = ?");
            values.add(new java.sql.Date(pedidoModificado.getFechaEntrega().getTime()));
        }

        if (!pedidoModificado.getMedPersona().isEmpty()) {
            updates.add("MED_PERSONA = ?");
            values.add(pedidoModificado.getMedPersona());
        }

        if (!pedidoModificado.getEstado().isEmpty()) {
            updates.add("ESTADO = ?");
            values.add(pedidoModificado.getEstado());
        }

        if (pedidoModificado.getDocCliente() > 0) {
            updates.add("DOC_CLIENTE = ?");
            values.add(pedidoModificado.getDocCliente());
        }

        if (pedidoModificado.getFacVenta() == 0 && Objects.equals(pedidoModificado.getEstado(), "Entregado")) {
            int nuevoNumeroFactura = obtenerProximoNumeroFactura(); // Función que obtiene el siguiente número de factura
            updates.add("FACTURA_VENTA = ?");
            values.add(nuevoNumeroFactura);
        }

        if((pedidoModificado.getFacVenta() == obtenerPedidoPorNumero(pedidoModificado.getNumPedido()).getFacVenta()) &&  Objects.equals(pedidoModificado.getEstado(), "Entregado")){
            int c = obtenerPedidoAeliminar(pedidoModificado.getNumPedido());
            DAOprodTerm_x_pedido.eliminarprodTerm_x_pedido(pedidoModificado.getNumPedido(), obtenerPedidoAeliminar(pedidoModificado.getNumPedido()));
            DAOprodTerminado.eliminarProductoTerminado(c);

        }

        if((pedidoModificado.getFacVenta() != 0) &&  !Objects.equals(pedidoModificado.getEstado(), "Entregado")){
            updates.add("FACTURA_VENTA = ?");
            values.add(0);
        }


        if (pedidoModificado.getMontoTotal() != null && pedidoModificado.getMontoTotal() > 0) {
            updates.add("MONTO_TOTAL = ?");
            values.add(pedidoModificado.getMontoTotal());
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
                            statement.setDate(index++, (java.sql.Date) value);
                        } else if (value instanceof Double) {
                            statement.setDouble(index++, (Double) value);
                        } else if (value instanceof Integer) {
                            statement.setInt(index++, (Integer) value);
                        } else if (value instanceof String) {
                            statement.setString(index++, (String) value);
                        }
                    }

                    statement.setInt(index, pedidoModificado.getNumPedido());

                    int rowsUpdated = statement.executeUpdate();

                    if (rowsUpdated > 0) {
                        isUpdated = true;
                        System.out.println("Pedido actualizado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null,"No se encontró el pedido con el número: " + pedidoModificado.getNumPedido());
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar pedido: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Error al eliminar pedido " + e.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Error al obtener pedido " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } finally {
                conexion.closeConnection();
            }
        } else {
            System.err.println("Error al establecer la conexión a la base de datos.");
        }

        return pedidoEncontrado;
    }

    public static void tablapedidoid(int numPedido, JTable tabla) {
        try {
            String q;
            if (numPedido != 0) {
                q = "SELECT * FROM pedido WHERE NUM_PED = ?";
            } else {
                q = "SELECT * FROM pedido";
            }

            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(q);

                if (numPedido != 0) {
                    statement.setInt(1, numPedido);
                }

                ResultSet rs = statement.executeQuery();

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("NUM_PED");
                model.addColumn("FEC_ENCARGADO");
                model.addColumn("ABONO");
                model.addColumn("FEC_ENTREGA");
                model.addColumn("MED_PERSONA");
                model.addColumn("ESTADO");
                model.addColumn("DOC_CLIENTE");
                model.addColumn("FACTURA_VENTA");
                model.addColumn("MONTO_TOTAL");

                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("NUM_PED"),
                            rs.getDate("FEC_ENCARGADO"),
                            rs.getDouble("ABONO"),
                            rs.getDate("FEC_ENTREGA"),
                            rs.getString("MED_PERSONA"),
                            rs.getString("ESTADO"),
                            rs.getInt("DOC_CLIENTE"),
                            rs.getInt("FACTURA_VENTA"),
                            rs.getDouble("MONTO_TOTAL")
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

    public static int obtenerProximoNumeroFactura() {
        int nuevoNumeroFactura = 0;

        ConexionBD conexion = new ConexionBD();
        conexion.openConnection();
        Connection connection = conexion.getConnection();

        if (connection != null) {
            try {
                // Consulta para obtener el máximo número de factura actual
                String consultaMaxFactura = "SELECT MAX(FACTURA_VENTA) FROM Pedido";

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(consultaMaxFactura);

                if (resultSet.next()) {
                    int maxFacturaActual = resultSet.getInt(1);
                    // Incrementar en uno para obtener el siguiente número de factura
                    nuevoNumeroFactura = maxFacturaActual + 1;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener el próximo número de factura: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } finally {
                conexion.closeConnection();
            }
        } else {
            System.out.println("Error en la conexión a la base de datos");
        }

        return nuevoNumeroFactura;
    }

    public static int obtenerPedidoAeliminar(int numeroPedido) {
        int CodigoEliminar = 0;

        ConexionBD conexion = new ConexionBD();
        conexion.openConnection();
        Connection connection = conexion.getConnection();

        if (connection != null) {
            try {
                String consultaCodigoEliminar = "SELECT pp.cod_prodterm " +
                        "FROM producto_terminado pr INNER JOIN prodterm_x_pedido pp ON " +
                        "pr.cod_prodterm = pp.cod_prodterm " +
                        "WHERE pp.num_ped = ?";

                PreparedStatement statement = connection.prepareStatement(consultaCodigoEliminar);
                statement.setInt(1, numeroPedido);

                ResultSet resultSet = statement.executeQuery();

                // Asignar el valor al CodigoEliminar si hay resultados
                if (resultSet.next()) {
                    do {
                        CodigoEliminar = resultSet.getInt("cod_prodterm");
                    } while (resultSet.next());
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener el codigo a eliminar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } finally {
                conexion.closeConnection();
            }
        } else {
            System.out.println("Error en la conexión a la base de datos");
        }

        return CodigoEliminar;
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
