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
        //new PantallaPrincipal("administrador","Schwarzenegger"); //Activalo para pruebas y no tener que loguearse
        new PantallaPrincipal("vendedor", "Bill Gates");//Si quiero entrar como vendedor
    }
}