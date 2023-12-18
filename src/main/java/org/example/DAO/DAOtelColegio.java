package org.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.example.modelo.*;

public class DAOtelColegio {

        static PreparedStatement ps;
        static ResultSet rs;
        static Connection conn;
        static ConexionBD conectar = new ConexionBD();
        static  telColegio c = new telColegio();


        public static telColegio obtenerTelColegio(int idColegio) {
            try {
                // hago la conexion y ejecuto la instruccion para obtener todos los datos
                // almacenandolos en un resultset
                conectar.openConnection();
                conn = conectar.getConnection();
                ps = conn.prepareStatement("SELECT * FROM  TEL_COLEGIO WHERE ID_COLEGIO = ?;");
                ps.setInt(1, idColegio);
                rs = ps.executeQuery();

                // convierto los datos del resultset en objetos de estudiante y los agrego
                // a un List de estudiantes que posteriorment retornare
                while (rs.next()) {
                    telColegio c = new telColegio();
                    c.setIdColegio(rs.getInt(1));
                    c.setTelefonoColegio(rs.getInt(2));

                }
            } catch (Exception e) {
                System.out.println("Error al obtener el telefono del colegio: " + e.getMessage());
            }

            return c;

        }

}
