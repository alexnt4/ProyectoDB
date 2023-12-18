package org.example.controlador;


import org.example.DAO.*;

import org.example.modelo.Usuario;
import org.example.modelo.cliente;
import org.example.modelo.pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.util.ArrayList;


import java.util.Date;

import static org.example.DAO.DAOpedido.tablapedidoid;
import static org.example.DAO.DAOproveedor.tablaproveedorNIT;
import static org.example.DAO.DAOuniforme.tablauniformeID;
import static org.example.DAO.DAOusuario.tablaUsuarioID;

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

    public static void agregarProveedor(int nitProveedor, String nombreProveedor, String direccionProveedor, String contacto, String producto, int codMaterial, JTable tabla){
        org.example.modelo.proveedor NuevoProveedor = new org.example.modelo.proveedor(nitProveedor, nombreProveedor, direccionProveedor, contacto, producto, codMaterial);
        DAOproveedor.agregarProveedor(NuevoProveedor);
        tablaproveedorNIT(nitProveedor, tabla);
    }

    public static void actualizarProveedor(int nitProveedor, String nombreProveedor, String direccionProveedor, String contacto, String producto, int codMaterial, JTable tabla){
        org.example.modelo.proveedor ProveedorActualizado = new org.example.modelo.proveedor(nitProveedor, nombreProveedor, direccionProveedor, contacto, producto, codMaterial);
        DAOproveedor.actualizarProveedor(ProveedorActualizado);
        tablaproveedorNIT(nitProveedor, tabla);
    }

    public static void consultarProveedor(int nitProveedor, JTable tabla){tablaproveedorNIT(nitProveedor, tabla);}

    public static void eliminarProveedor(int nitProveedor){DAOproveedor.eliminarProveedor(nitProveedor);}

    public static void agregarUniforme(int idPrenda, String caracEspecial, int idColegio, JTable tabla){
        org.example.modelo.uniforme NuevoUniforme = new org.example.modelo.uniforme(idPrenda, caracEspecial, idColegio);
        DAOuniforme.agregarUniforme(NuevoUniforme);
        tablauniformeID(idPrenda, tabla);
    }


    public static void actualizarUniforme(int idprenda, String carac, int idcolegio, JTable tablero) {
        org.example.modelo.uniforme UniformeActualizado = new org.example.modelo.uniforme(idprenda, carac, idcolegio);
        DAOuniforme.actualizarUniforme(UniformeActualizado);
        tablauniformeID(idprenda,tablero);
    }

    public static void consultarUniforme(int idprenda, JTable tabla){tablauniformeID(idprenda, tabla);}

    public static void eliminarUniforme(int idprenda){DAOuniforme.eliminarUniforme(idprenda);}

    public static void agregarUsuario(String idUsuario, String nombreUsuario, String passwordUsuario, String tipoUsuario, JTable tablero){
        org.example.modelo.Usuario NuevoUsuario = new org.example.modelo.Usuario(idUsuario, nombreUsuario, passwordUsuario, tipoUsuario);
        DAOusuario.AgregarUsuario(NuevoUsuario);
        tablaUsuarioID(idUsuario, tablero);
    }

    public static void actualizarUsuario(String idUsuario, String nombreUsuario, String passwordUsuario, String tipoUsuario, JTable tablero){
        org.example.modelo.Usuario UsuarioActualizado = new org.example.modelo.Usuario(idUsuario, nombreUsuario, passwordUsuario, tipoUsuario);
        DAOusuario.actualizarUsuario(UsuarioActualizado);
        tablaUsuarioID(idUsuario,tablero);
    }

    public static void consultarUsuario(String idUsuario, JTable tablero){tablaUsuarioID(idUsuario, tablero);}

    public static void eliminarUsuario(String idUsuario){DAOusuario.eliminarUsuario(idUsuario);}
}
