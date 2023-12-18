package org.example.controlador;


import org.example.DAO.DAOcliente;

import org.example.DAO.DAOpedido;

import org.example.modelo.Usuario;
import org.example.modelo.cliente;
import org.example.modelo.pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.util.ArrayList;


import java.util.Date;

import static org.example.DAO.DAOpedido.tablapedidoid;

public class controlador {




    public static void agregarPedido(int numPedido, java.sql.Date fechaEncargo, Double abono, java.sql.Date fechaEntrega, String medPersona, String estado, int docCliente, int facVenta, Double montoTotal, JTable tabla) {
        org.example.modelo.pedido NuevoPedido = new org.example.modelo.pedido(numPedido, fechaEncargo, abono, fechaEntrega, medPersona, estado, docCliente, facVenta, montoTotal);
        DAOpedido.agregarPedido(NuevoPedido);
        tablapedidoid(numPedido,tabla);
    }

    public static void consultarPedido(int numPedido, JTable tabla){
        tablapedidoid(numPedido, tabla);
    }

    public static void actualizarPedido(int numPedido, java.sql.Date fechaEncargo, Double abono, java.sql.Date fechaEntrega, String medPersona, String estado, int docCliente, int facVenta, Double montoTotal, JTable tabla){
        org.example.modelo.pedido PedidoActualizado = new org.example.modelo.pedido(numPedido, fechaEncargo, abono, fechaEntrega, medPersona, estado, docCliente, facVenta, montoTotal);
        DAOpedido.actualizarPedido(PedidoActualizado);
        tablapedidoid(numPedido, tabla);
    }

    public static void eliminarPedido(int numPedido){
        DAOpedido.eliminarPedido(numPedido);
    }

    /*public static void llenarTablaBuscarPedido(int numPedido, DefaultTableModel table, JTextArea tablero) {
        Object[] fila = new Object[9];
        table.setRowCount(0);

        pedido elPedido = DAOpedido.obtenerPedidoPorNumero(numPedido);

        if (elPedido != null) {
            fila[0] = elPedido.getNumPedido();
            fila[1] = elPedido.getFechaEncargado();
            fila[2] = elPedido.getAbono();
            fila[3] = elPedido.getFechaEntrega();
            fila[4] = elPedido.getMedPersona();
            fila[5] = elPedido.getEstado();
            fila[6] = elPedido.getDocCliente();
            fila[7] = elPedido.getFacVenta();
            fila[8] = elPedido.getMontoTotal();

            table.addRow(fila);

            // Construir la representación de la tabla en el JTextArea
            StringBuilder tablaTexto = new StringBuilder();
            tablaTexto.append("NUM_PED | FEC_ENCARGADO | ABONO | FEC_ENTREGA | MED_PERSONA | ESTADO | DOC_CLIENTE | FACTURA_VENTA | MONTO_TOTAL\n");
            tablaTexto.append("----------------------------------------------------------------------------------------------------------------\n");

            tablaTexto.append(String.format("%-8s|%-15s|%-7s|%-12s|%-13s|%-8s|%-12s|%-15s|%-11s\n",
                    fila[0], fila[1], fila[2], fila[3], fila[4], fila[5], fila[6], fila[7], fila[8]));

            tablero.setText(tablaTexto.toString());
        }
    }*/












}
