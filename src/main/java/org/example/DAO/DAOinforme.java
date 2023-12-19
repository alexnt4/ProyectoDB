package org.example.DAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.example.Util.Constantes.ERROR_ACTUALIZACION;
import static org.example.Util.Constantes.ERROR_DE_CONSULTA;
public class DAOinforme {
    public static void tabla1(JTable tabla) {
        try {
            String q = " select p.num_ped, p.fec_encargado, p.abono, p.fec_entrega, p.med_persona, p.estado, p.doc_cliente, p.factura_venta, p.monto_total\n" +
                    "from pedido p inner join prodterm_x_pedido pp on\n" +
                    "p.num_ped = pp.num_ped\n" +
                    "inner join producto_terminado pr on\n" +
                    "pp.cod_prodterm = pr.cod_prodterm\n" +
                    "where p.estado ilike '%Pendiente%' and pr.encargado ilike 'True'\n" +
                    "order by p.fec_encargado ;";

            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(q);


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

    public static void tabla2(JTable tabla) {
        try {
            String q = "select p.doc_cliente, p.num_ped, pr.id_prenda, pr.descripcion\n" +
                    "from pedido p inner join prodterm_x_pedido pp on\n" +
                    "p.num_ped = pp.num_ped\n" +
                    "inner join producto_terminado pr on\n" +
                    "pp.cod_prodterm = pr.cod_prodterm\n" +
                    "where p.estado ilike '%Pendiente%' and pr.encargado ilike 'True'\n" +
                    "group by p.doc_cliente, p.num_ped, pr.id_prenda, pr.descripcion";

            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(q);


                ResultSet rs = statement.executeQuery();

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("DOC_CLIENTE");
                model.addColumn("NUM_PED");
                model.addColumn("ID_PRENDA");
                model.addColumn("DESCRIPCION");

                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("DOC_CLIENTE"),
                            rs.getInt("NUM_PED"),
                            rs.getInt("ID_PRENDA"),
                            rs.getString("DESCRIPCION")
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


    public static void tabla3(JTable tabla) {
        try {
            String q = "SELECT pr.ID_PRENDA, pr.descripcion,\n" +
                    "       SUM(pr.CANT_TERMINADOS) - COALESCE(SUM(CASE WHEN pr.ENCARGADO ILIKE '%True%' THEN pr.CANT_TERMINADOS ELSE 0 END), 0) AS CANTIDAD_DISPONIBLE\n" +
                    "FROM PRODUCTO_TERMINADO pr\n" +
                    "GROUP BY pr.ID_PRENDA, pr.descripcion;";

            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(q);


                ResultSet rs = statement.executeQuery();

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID_PRENDA");
                model.addColumn("DESCRIPCION");
                model.addColumn("CANTIDAD_DISPONIBLE");

                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("ID_PRENDA"),
                            rs.getString("DESCRIPCION"),
                            rs.getInt("CANTIDAD_DISPONIBLE")
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

    public static void tabla4(JTable tabla) {
        try {
            String q = "SELECT DISTINCT C.ID_COLEGIO, C.NOM_COLEGIO, C.DIR_COLEGIO, C.CONTACTO\n" +
                    "FROM COLEGIO C\n" +
                    "INNER JOIN UNIFORME U ON C.ID_COLEGIO = U.ID_COLEGIO;";

            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(q);


                ResultSet rs = statement.executeQuery();

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID_COLEGIO");
                model.addColumn("NOM_COLEGIO");
                model.addColumn("DIR_COLEGIO");
                model.addColumn("CONTACTO");

                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("ID_COLEGIO"),
                            rs.getString("NOM_COLEGIO"),
                            rs.getString("DIR_COLEGIO"),
                            rs.getString("CONTACTO")
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

    public static void tabla5(int idColegio, JTable tabla) {
        try {
            String q = "SELECT UV.ID_PRENDA, UV.CARAC_ESPECIAL, PV.SEXO, PV.COLOR, PV.TELA, PV.TIPO, PV.TALLA, PV.DISEÑOPRENDA, PV.PIEZA\n" +
                    "FROM UNIFORME UV\n" +
                    "INNER JOIN PRENDA_VESTIR PV ON UV.ID_PRENDA = PV.ID_PRENDA\n" +
                    "WHERE UV.ID_COLEGIO = ?;";

            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(q);
                statement.setInt(1, idColegio); // Establecer el valor del parámetro ID_COLEGIO

                ResultSet rs = statement.executeQuery();

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID_PRENDA");
                model.addColumn("CARAC_ESPECIAL");
                model.addColumn("SEXO");
                model.addColumn("COLOR");
                model.addColumn("TELA");
                model.addColumn("TIPO");
                model.addColumn("TALLA");
                model.addColumn("DISEÑOPRENDA");
                model.addColumn("PIEZA");

                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("ID_PRENDA"),
                            rs.getString("CARAC_ESPECIAL"),
                            rs.getString("SEXO"),
                            rs.getString("COLOR"),
                            rs.getString("TELA"),
                            rs.getString("TIPO"),
                            rs.getString("TALLA"),
                            rs.getString("DISEÑOPRENDA"),
                            rs.getString("PIEZA")
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

    public static void tabla6(JTable tabla) {
        try {
            String q = "SELECT C.ID_COLEGIO, C.NOM_COLEGIO, sum(PT.CANT_TERMINADOS) AS TOTAL_PRODUCTOS_VENDIDOS\n" +
                    "FROM COLEGIO C\n" +
                    "INNER JOIN UNIFORME U ON C.ID_COLEGIO = U.ID_COLEGIO\n" +
                    "INNER JOIN PRODUCTO_TERMINADO PT ON U.ID_PRENDA = PT.ID_PRENDA\n" +
                    "INNER JOIN PRODTERM_X_PEDIDO PP ON PT.COD_PRODTERM = PP.COD_PRODTERM\n" +
                    "GROUP BY C.ID_COLEGIO, C.NOM_COLEGIO\n" +
                    "ORDER BY C.ID_COLEGIO, C.NOM_COLEGIO;";

            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(q);


                ResultSet rs = statement.executeQuery();

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID_COLEGIO");
                model.addColumn("NOM_COLEGIO");
                model.addColumn("TOTAL_PRODUCTOS_VENDIDOS");

                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("ID_COLEGIO"),
                            rs.getString("NOM_COLEGIO"),
                            rs.getInt("TOTAL_PRODUCTOS_VENDIDOS")
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


    public static void tabla7(JTable tabla) {
        try {
            String q = "select sum(monto_total) as Total_Ventas\n" +
                    "from pedido";

            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(q);


                ResultSet rs = statement.executeQuery();

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("TOTAL_VENTAS");

                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("TOTAL_VENTAS")
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
