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
public class DAOprodTerminado {

    static PreparedStatement ps;
    static ResultSet rs;
    static Connection conn;
    static ConexionBD conectar = new ConexionBD();
    static  prodTerminado c = new prodTerminado();

    public static List<prodTerminado> obtenerProdTerminado(){
        List<prodTerminado> prodTerminado = new ArrayList<>();
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM PRODUCTO_TERMINADO;");
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while(rs.next()){
                prodTerminado c = new prodTerminado();
                c.setCodProdTerm(rs.getInt(1));
                c.setIdPrenda(rs.getInt(2));
                c.setCodMaterial(rs.getInt(3));
                c.setDescripcion(rs.getString(4));
                c.setPrecio(rs.getDouble(5));
                c.setEncargado(rs.getString(6));
                c.setCanTerminados(rs.getInt(7));


                prodTerminado.add(c);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al obtener la lista de todos: " + e.getMessage());
        }

        return prodTerminado;
    }


    public static prodTerminado obtenerProdTerminado(int codProdTerm) {
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM  PRODUCTO_TERMINADO WHERE cod_prodTerm = ?;");
            ps.setInt(1, codProdTerm);
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while (rs.next()) {
                prodTerminado c = new prodTerminado();
                c.setCodProdTerm(rs.getInt(1));
                c.setIdPrenda(rs.getInt(2));
                c.setCodMaterial(rs.getInt(3));
                c.setDescripcion(rs.getString(4));
                c.setPrecio(rs.getDouble(5));
                c.setCanTerminados(rs.getInt(6));
                c.setEncargado(rs.getString(7));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al obtener la prenda de vestir: " + e.getMessage());
        }

        return c;

    }

    public static int agregarProdTerminado(prodTerminado prodTerminado) {
        int r = 0;
        String sql = "INSERT INTO PRODUCTO_TERMINADO (COD_PRODTERM, ID_PRENDA, CODIGO_MATERIAL, DESCRIPCION, PRECIO, CANT_TERMINADOS, ENCARGADO) VALUES (?,?,?,?,?,?,?);";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, prodTerminado.getCodProdTerm());
            ps.setInt(2, prodTerminado.getIdPrenda());
            ps.setInt(3, prodTerminado.getCodMaterial());
            ps.setString(4, prodTerminado.getDescripcion());
            ps.setDouble(5, prodTerminado.getPrecio());
            ps.setInt(6, prodTerminado.getCanTerminados());
            ps.setString(7, prodTerminado.getEncargado());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al agregar la prenda de vestir: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return r;
    }

    public static boolean actualizarProdTerminado(prodTerminado prodTerminadoActualizado) {
        boolean isUpdated = false;

        String sqlActualizar = "UPDATE PRODUCTO_TERMINADO SET ";
        String whereClause = " WHERE COD_PRODTERM = ?";
        ArrayList<String> updates = new ArrayList<>();
        ArrayList<Object> values = new ArrayList<>();

        if(prodTerminadoActualizado.getCodProdTerm() > 0){
            updates.add("COD_PRODTERM = ?");
            values.add(prodTerminadoActualizado.getCodProdTerm());
        }

        if(prodTerminadoActualizado.getIdPrenda() > 0){
            updates.add("ID_PRENDA = ?");
            values.add(prodTerminadoActualizado.getIdPrenda());
        }

        if(prodTerminadoActualizado.getCodMaterial() > 0){
            updates.add("CODIGO_MATERIAL = ?");
            values.add(prodTerminadoActualizado.getCodMaterial());
        }

        if (!prodTerminadoActualizado.getDescripcion().isEmpty()) {
            updates.add("DESCRIPCION = ?");
            values.add(prodTerminadoActualizado.getDescripcion());
        }

        if(prodTerminadoActualizado.getPrecio() != null && prodTerminadoActualizado.getPrecio() > 0){
            updates.add("PRECIO = ?");
            values.add(prodTerminadoActualizado.getPrecio());
        }

        if (!prodTerminadoActualizado.getEncargado().isEmpty()) {
            updates.add("ENCARGADO = ?");
            values.add(prodTerminadoActualizado.getEncargado());
        }

        if (prodTerminadoActualizado.getCanTerminados()> 0) {
            updates.add("cant_terminados = ?");
            values.add(prodTerminadoActualizado.getCanTerminados());
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

                    statement.setInt(index, prodTerminadoActualizado.getCodProdTerm());

                    int rowsUpdated = statement.executeUpdate();

                    if (rowsUpdated > 0) {
                        isUpdated = true;
                        System.out.println("PRODUCTO TERMINADO actualizado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null,"No se encontró el pedido con el número: " + prodTerminadoActualizado.getCodProdTerm());
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


    public static int eliminarProdTerminado(int codProdTerm) {
        int r = 0;
        String sql = "DELETE FROM PRODUCTO_TERMINADO WHERE COD_PRODTERM = ?;";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codProdTerm);
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al eliminar el producto terminado: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return r;
    }

    public static void tablaProdTerminado(int iCodprodTerm, JTable tabla) {
        try {
            String q;
            if (iCodprodTerm != 0) {
                q = "SELECT * FROM PRODUCTO_TERMINADO WHERE COD_PRODTERM = ?";
            } else {
                q = "SELECT * FROM PRODUCTO_TERMINADO";
            }

            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(q);

                if (iCodprodTerm  != 0) {
                    statement.setInt(1, iCodprodTerm );
                }

                ResultSet rs = statement.executeQuery();

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("COD_PRODTERM");
                model.addColumn("ID_PRENDA");
                model.addColumn("CODIGO_MATERIAL");
                model.addColumn("DESCRIPCION");
                model.addColumn("PRECIO");
                model.addColumn("CANT_TERMINADOS");
                model.addColumn("ENCARGADO");

                while (rs.next()) {
                    Object[] rowData = {
                            rs.getInt("COD_PRODTERM"),
                            rs.getInt("ID_PRENDA"),
                            rs.getInt("CODIGO_MATERIAL"),
                            rs.getString("DESCRIPCION"),
                            rs.getDouble("PRECIO"),
                            rs.getInt("CANT_TERMINADOS"),
                            rs.getString("ENCARGADO"),

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
