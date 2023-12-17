package org.example.controlador;

import org.example.DAO.DAOusuario;
import org.example.modelo.Usuario;
import org.example.vista.Login;
import org.example.vista.PantallaPrincipal;

import javax.swing.*;

public class controladorLogin {
    //valida si el password ingresado por usuario es igual que el password guardado en base de datos

    Login login;
    public static boolean validarPasswordUsuario(String idUser, String pass) {
        boolean result = false;
        DAOusuario daoUsuario = new DAOusuario();
        Usuario usuario = daoUsuario.obtenerUsuarioPorID(idUser);
        String password = usuario.getPasswordUsuario();
        if (pass.equals(password)) {
            result = true;
        }
        return result;
    }

    public static Boolean loginController(String idUser, String pass) {
        Boolean valor = false;
        if (!idUser.isEmpty() && !pass.isEmpty()) { // Verificamos que el ID no sea cero y que la contraseña no esté vacía
            if (validarPasswordUsuario(idUser, pass)) {
                DAOusuario daoUsuario = new DAOusuario();
                Usuario usuario = daoUsuario.obtenerUsuarioPorID(String.valueOf(idUser));
                String nombreUsuario = usuario.getPasswordUsuario();
                String cargoUsuario = usuario.getTipoUsuario();
                JOptionPane.showMessageDialog(null, "BIENVENIDO " + nombreUsuario);
                valor = true;
                PantallaPrincipal userUI = new PantallaPrincipal(cargoUsuario);
                userUI.setVisible(true);
            } else {
                Login.textoErroneo();
            }
        } else {
            Login.textoIngreseData();
        }
        return valor;
    }

}
