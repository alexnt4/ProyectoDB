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

public class DAOprendaVestir {

    static PreparedStatement ps;
    static ResultSet rs;
    static Connection conn;
    static ConexionBD conectar = new ConexionBD();
    static  prendaVestir c = new prendaVestir();


    public static List<prendaVestir> obtenerPrendasVestir(){
        List<prendaVestir> prendasVestir = new ArrayList<>();
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM PRENDA_VESTIR;");
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while(rs.next()){
                prendaVestir c = new prendaVestir();
                c.setIdPrendaVestir(rs.getInt(1));
                c.setSexo(rs.getString(2));
                c.setColor(rs.getString(3));
                c.setTela(rs.getString(4));
                c.setTipo(rs.getString(5));
                c.setTalla(rs.getString(6));
                c.setDiseno(rs.getString(7));
                c.setPieza(rs.getString(8));

                prendasVestir.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de todos: " + e.getMessage());
        }

        return prendasVestir;
    }


    public static prendaVestir obtenerPrendaVestir(int idPrendaVestir) {
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM  PRENDA_VESTIR WHERE ID_PRENDA = ?;");
            ps.setInt(1, idPrendaVestir);
            rs = ps.executeQuery();

            // convierto los datos del resultset en objetos de estudiante y los agrego
            // a un List de estudiantes que posteriorment retornare
            while (rs.next()) {
                prendaVestir c = new prendaVestir();
                c.setIdPrendaVestir(rs.getInt(1));
                c.setSexo(rs.getString(2));
                c.setColor(rs.getString(3));
                c.setTela(rs.getString(4));
                c.setTipo(rs.getString(5));
                c.setTalla(rs.getString(6));
                c.setDiseno(rs.getString(7));
                c.setPieza(rs.getString(8));

            }
        } catch (Exception e) {
            System.out.println("Error al obtener la prenda de vestir: " + e.getMessage());
        }

        return c;

    }

    public static int agregarPrendaVestir(prendaVestir prendaVestir) {
        int r = 0;
        String sql = "INSERT INTO PRENDA_VESTIR (ID_PRENDA, SEXO, COLOR, TELA, TIPO, TALLA, DISEÑOPRENDA, PIEZA) VALUES (?,?,?,?,?,?,?,?);";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, prendaVestir.getIdPrendaVestir());
            ps.setString(2, prendaVestir.getSexo());
            ps.setString(3, prendaVestir.getColor());
            ps.setString(4, prendaVestir.getTela());
            ps.setString(5, prendaVestir.getTipo());
            ps.setString(6, prendaVestir.getTalla());
            ps.setString(7, prendaVestir.getDiseno());
            ps.setString(8, prendaVestir.getPieza());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.out.println("Error al agregar la prenda de vestir: " + e.getMessage());
        }
        return r;
    }


    public static boolean actualizarPrendaVestir(prendaVestir prendaVestirActualizada) {
        boolean isUpdated = false;

        String sqlActualizar = "UPDATE prenda_vestir SET ";
        String whereClause = " WHERE id_prenda = ?";
        ArrayList<String> updates = new ArrayList<>();
        ArrayList<Object> values = new ArrayList<>();

        if (!prendaVestirActualizada.getColor().isEmpty()) {
            updates.add("COLOR = ?");
            values.add(prendaVestirActualizada.getColor());
        }

        if (!prendaVestirActualizada.getDiseno().isEmpty()) {
            updates.add("DISEÑOPRENDA = ?");
            values.add(prendaVestirActualizada.getDiseno());
        }

        if (!prendaVestirActualizada.getSexo().isEmpty()){
            updates.add("SEXO = ?");
            values.add(prendaVestirActualizada.getSexo());
        }

        if (!prendaVestirActualizada.getTela().isEmpty()) {
            updates.add("TELA = ?");
            values.add(prendaVestirActualizada.getTela());
        }

        if (!prendaVestirActualizada.getTipo().isEmpty()) {
            updates.add("TIPO = ?");
            values.add(prendaVestirActualizada.getTipo());
        }

        if (!prendaVestirActualizada.getTalla().isEmpty()) {
            updates.add("TALLA = ?");
            values.add(prendaVestirActualizada.getTalla());
        }

        if (!prendaVestirActualizada.getPieza().isEmpty()) {
            updates.add("PIEZA = ?");
            values.add(prendaVestirActualizada.getPieza());
        }

        if (prendaVestirActualizada.getIdPrendaVestir() > 0) {
            updates.add("id_prenda = ?");
            values.add(prendaVestirActualizada.getIdPrendaVestir());
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

                    statement.setInt(index, prendaVestirActualizada.getIdPrendaVestir());

                    int rowsUpdated = statement.executeUpdate();

                    if (rowsUpdated > 0) {
                        isUpdated = true;
                        System.out.println("PRENDA actualizado correctamente");
                    } else {
                        System.out.println("No se encontró el pedido con el número: " + prendaVestirActualizada.getIdPrendaVestir());
                    }
                } catch (SQLException e) {
                    System.err.println(ERROR_ACTUALIZACION + e.getMessage());
                } finally {
                    conexion.closeConnection();
                }
            }
        } else {
            System.out.println("No se han proporcionado datos para actualizar.");
        }

        return isUpdated;
    }



    public static int eliminarPrendaVestir(int idPrendaVestir) {
        int r = 0;
        String sql = "DELETE FROM PRENDA_VESTIR WHERE ID_PRENDA = ?;";
        try {
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idPrendaVestir);
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar la prenda de vestir: " + e.getMessage());
        }
        return r;
    }


      public static void tablaprendaid(int idPrenda, JTable tabla) {
        try {
            String q;
            if (idPrenda != 0) {
                q = "SELECT * FROM prenda_vestir WHERE ID_PRENDA = ?";
            } else {
                q = "SELECT * FROM prenda_vestir";
            }

            ConexionBD conexion = new ConexionBD();
            conexion.openConnection();
            Connection connection = conexion.getConnection();

            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(q);

                if (idPrenda  != 0) {
                    statement.setInt(1, idPrenda );
                }

                ResultSet rs = statement.executeQuery();

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID_PRENDA");
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
                            rs.getString("SEXO"),
                            rs.getString("COLOR"),
                            rs.getString("TELA"),
                            rs.getString("TIPO"),
                            rs.getString("TALLA"),
                            rs.getString("DISEÑOPRENDA"),
                            rs.getString("PIEZA"),
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
