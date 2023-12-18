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
        new PantallaPrincipal("administrador","Schwarzenegger"); //Activalo para pruebas y no tener que loguearse
    }
}

/*
 
        DefaultTableModel modeloVacio = new DefaultTableModel(); // Crea un nuevo modelo vacío
        Tablero.setModel(modeloVacio); 

        Tablero = new JTable();
        Tablero.setFont(new Font("arial", 2, 15));
        Tablero.setEnabled(false);
        // Ajustar el tamaño de la fuente en la tabla
        Font font = new Font("Arial", Font.PLAIN, 12); // Cambia el tamaño de la fuente según tus preferencias
        Tablero.setFont(font);

// Ajustar la altura de las filas
        Tablero.setRowHeight(30); // Cambia la altura de las filas según tus preferencias

// Ajustar el tamaño de la tabla (ancho y alto)
        int anchoTabla = 800; // Ajusta el ancho de la tabla según tus preferencias
        int altoTabla = 400; // Ajusta la altura de la tabla según tus preferencias
        Tablero.setPreferredScrollableViewportSize(new Dimension(anchoTabla, altoTabla));

        barraDesplazamiento = new JScrollPane(Tablero);
        barraDesplazamiento = new JScrollPane(Tablero);
        barraDesplazamiento.setBounds(15, 340, 890, 250);

// Establecer tamaño preferido para mostrar la tabla correctamente
        barraDesplazamiento.setPreferredSize(new Dimension(880, 240)); // Ajusta estos valores según tus necesidades

        add(barraDesplazamiento);
 */