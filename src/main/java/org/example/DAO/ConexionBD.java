package org.example.DAO;

import static org.example.Util.Constantes.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author alex
 */
public class ConexionBD {
    private Connection conn;

    private final String url = "jdbc:postgresql://localhost:5432/ProyectoFinal";
    private final String username = "postgres";
    private final String password = "bbcita";


    public void openConnection() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the PostgreSQL server successfully.");



        } catch (SQLException e) {
            System.err.println(ERROR_DE_CONEXION + e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println(ERROR_DE_CIERRE_DE_CONEXION + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();
        conexionBD.openConnection();
        conexionBD.closeConnection();
    }
}