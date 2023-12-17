package org.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.example.modelo.*;

import static org.example.Util.Constantes.*;




public class DAOcliente {

    PreparedStatement ps;
    ResultSet rs;
    Connection conn;
    ConexionBD conectar = new ConexionBD();
    cliente c = new cliente();

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

    public cliente obtenerCliente(int idCliente){
        try {
            // hago la conexion y ejecuto la instruccion para obtener todos los datos
            // almacenandolos en un resultset
            conectar.openConnection();
            conn = conectar.getConnection();
            ps = conn.prepareStatement("SELECT * FROM cliente WHERE idCliente = ?;");
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



    public static void main(String[] args) {
        DAOcliente dao = new DAOcliente();
        List<cliente> clientes = dao.obtenerClientes();
        for (cliente c : clientes) {
            System.out.println(c.getIdCliente() + " " + c.getNombreCliente());
        }
    }
    


}
