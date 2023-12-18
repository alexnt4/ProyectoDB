package org.example.controlador;


import org.example.DAO.DAOcliente;

import org.example.DAO.DAOpedido;

import org.example.modelo.Usuario;
import org.example.modelo.cliente;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


import java.util.Date;

public class controlador {




    public static void agregarPedido(int numPedido, java.sql.Date fechaEncargo, Double abono, java.sql.Date fechaEntrega, String medPersona, String estado, int docCliente, int facVenta, Double montoTotal) {
        org.example.modelo.pedido NuevoPedido = new org.example.modelo.pedido(numPedido, fechaEncargo, abono, fechaEntrega, medPersona, estado, docCliente, facVenta, montoTotal);
        DAOpedido.agregarPedido(NuevoPedido);
    }

    /*public boolean validarPasswordEmpleado(String usuario, String pass){
            boolean result = false;
            DAOusuario daoUsuario = new DAOusuario();
            Usuario usuario = daoUsuario.obtenerUsuario(usuario);
            String password = usuario.getPasswordUsuario();
            if (pass.equals(password)){
                result = true;
            }
            return result;
        }*/










}
