package org.example.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import org.example.controlador.controlador;
import org.example.controlador.controladorLogin;
import org.example.modelo.pedido;

public class Login extends JFrame implements ActionListener {

    JPanel panel;
    JTextField T_usuarioTitulo,T_usuario,T_passwordTitulo;
    JPasswordField T_password;
    JButton listo;
    JTextArea tituloVentana;
    static JLabel validar;

    controlador controlador = new controlador();
    PantallaPrincipal pantallaPrincipal;

    public Login(){
        super("Login");
        setSize(370,380);
        getContentPane().setBackground(new Color(0, 191, 255));
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearGui();
        repaint();
    }

    public void crearGui(){

        ImageIcon icono = new ImageIcon(getClass().getResource("/icono1.png")); //icono de la ventana
        //ImageIcon iconoScalada =  new ImageIcon(iconoOriginal.getImage().getScaledInstance(500,500,Image.SCALE_SMOOTH));
        setIconImage(icono.getImage());
        panel = new JPanel();
        panel.setBackground(new Color(0, 191, 255));
        //panel.setBackground(new Color(220, 220, 220)); //Activelo cuando quiera ver el panel
        panel.setBounds(5,5,340,330);
        panel.setLayout(null);
        add(panel);

        tituloVentana = new JTextArea();

        tituloVentana.setText(" INICIAR SESION " );

        tituloVentana.setText(" INICIAR SESIÓN " );

        tituloVentana.setFocusable(false);
        tituloVentana.setFont(new Font("arial", 3, 33));
        tituloVentana.setEditable(false);
        tituloVentana.setBorder(new LineBorder(Color.gray));
        tituloVentana.setBounds(30,50,280,40);
        panel.add(tituloVentana);

        T_usuarioTitulo = new JTextField();
        T_usuarioTitulo.setText("   ID USUARIO");
        T_usuarioTitulo.setFont(new Font("arial", 3, 15));
        T_usuarioTitulo.setEditable(false);
        T_usuarioTitulo.setBorder(new LineBorder(Color.gray));
        T_usuarioTitulo.setBounds(35,110,120,25);
        panel.add(T_usuarioTitulo);

        T_usuario = new JTextField();
        T_usuario.setBounds(35,140,280,30);
        T_usuario.setBorder(new LineBorder(Color.gray));
        panel.add(T_usuario);

        T_passwordTitulo = new JTextField();
        T_passwordTitulo.setText(" CONTRASEÑA");
        T_passwordTitulo.setFont(new Font("arial", 3, 15));
        T_passwordTitulo.setEditable(false);
        T_passwordTitulo.setBorder(new LineBorder(Color.gray));
        T_passwordTitulo.setBounds(35,180,120,25);
        panel.add(T_passwordTitulo);

        T_password = new JPasswordField();
        T_password.setBounds(35,210,280,30);
        T_password.setBorder(new LineBorder(Color.gray));
        panel.add(T_password);


        listo = new JButton("INGRESAR");
        listo.setBounds(100,280,150,30);

        listo = new JButton("LISTO");
        listo.setBounds(90,290,150,30);

        listo.addActionListener(this);
        listo.setBorder(new LineBorder(Color.gray));
        listo.setFont(new Font("cooper black",2,25));
        listo.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        listo.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        listo.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
        panel.add(listo);

        validar = new JLabel();
        validar.setText("");
        validar.setBounds(120, 250, 250, 30);
        panel.add(validar);

    }

    public static void textoErroneo(){
        validar.setForeground(Color.RED);
        validar.setText("¡¡Datos Erróneos!!!");
    }

    public static void textoIngreseData(){
        validar.setForeground(Color.black);
        validar.setText("Ingrese Datos");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listo) {
            controladorLogin control = new controladorLogin();
            String idUser = T_usuario.getText();
            String pass = T_password.getText();
            if(controladorLogin.loginController(idUser, pass) == true){
                dispose();
            };
        }
    }

}
