package org.example;

import java.util.ArrayList;
import java.util.List;
import org.example.DAO.DAOcliente;
import org.example.modelo.cliente;
import org.example.vista.Login;
import org.example.vista.PantallaPrincipal;

public class Main {
    public static void main(String[] args) {
        //new Login();
        new PantallaPrincipal("administrador");
    }
}