package org.example.vista;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class PantallaPrincipal extends JFrame implements ActionListener{
    JPanel panel_principal,panel_segundario;
    JTextArea tituloVentana;
    JLabel label;
    JButton B_cliente,B_colegio,B_inventario_materiales,B_pedido,B_prenda_vestir,B_prodterm_X_pedido,
    B_producto_terminado, B_proveedor,B_uniforme,B_informe,B_usuario,B_back;

    //Declarar las otras vistas
    colegio Colegio;
    cliente Cliente;
    inventario_materiales Inventario_Materiales;
    pedido Pedido;
    Usuario usuario;
    String tipo;

    //Construccion
    public PantallaPrincipal (String cargo){
        
        super("Base Of Data");
        setSize(1300,700);
        getContentPane().setBackground(new Color(0, 191, 255));
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.tipo = cargo;
        GenerarGui();
        repaint();//Forzar repintura

        Cliente = new cliente(tipo);
        add(Cliente);

        Colegio = new colegio(tipo);
        add(Colegio);

        Inventario_Materiales = new inventario_materiales(tipo);
        add(Inventario_Materiales);

        Pedido = new pedido();
        add(Pedido);

        usuario = new Usuario();
        add(usuario);

    }

    public void GenerarGui(){
        panel_principal = new JPanel();
        panel_principal.setBackground(new Color(0, 191, 255));
        //panel_principal.setBackground(new Color(220, 220, 220)); //Activelo cuando quiera ver el panel
        panel_principal.setBounds(5,5,350,650);
        panel_principal.setLayout(null);
        panel_principal.setVisible(true);
        add(panel_principal);

        tituloVentana = new JTextArea();
        tituloVentana.setText("             TABLAS             ");
        tituloVentana.setFont(new Font("arial", 1, 27));
        tituloVentana.setEditable(false);
        tituloVentana.setBorder(new LineBorder(Color.gray));
        tituloVentana.setBounds(10,0,320,40);
        panel_principal.add(tituloVentana);

        panel_segundario = new JPanel();
        panel_segundario.setBackground(new Color(0, 191, 255));
        //panel_segundario.setBackground(Color.red); //Activelo cuando quiera ver el panel
        panel_segundario.setBounds(350,5,580,650);
        panel_segundario.setLayout(null);
        panel_segundario.setVisible(true);
        add(panel_segundario);
        
        B_cliente = new JButton("CLIENTE");
        B_cliente.setBounds(10, 50,320,40);
        B_cliente.addActionListener(this);
        B_cliente.setBorder(new LineBorder(Color.gray));
        B_cliente.setFont(new Font("cooper black",1,20));
        B_cliente.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        B_cliente.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        B_cliente.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
        panel_principal.add(B_cliente);

        B_colegio= new JButton("COLEGIO");
        B_colegio.setBounds(10, 100,320,40);
        B_colegio.addActionListener(this);
        B_colegio.setBorder(new LineBorder(Color.gray));
        B_colegio.setFont(new Font("cooper black",1,20));
        B_colegio.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        B_colegio.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        B_colegio.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
        panel_principal.add(B_colegio);

        
        B_inventario_materiales= new JButton("INVENTARIO MATERIALES");
        B_inventario_materiales.setBounds(10, 150,320,40);
        B_inventario_materiales.addActionListener(this);
        B_inventario_materiales.setBorder(new LineBorder(Color.gray));
        B_inventario_materiales.setFont(new Font("cooper black",1,20));
        B_inventario_materiales.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        B_inventario_materiales.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        B_inventario_materiales.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
        panel_principal.add(B_inventario_materiales);

        B_pedido= new JButton("PEDIDO");
        B_pedido.setBounds(10, 200,320,40);
        B_pedido.addActionListener(this);
        B_pedido.setBorder(new LineBorder(Color.gray));
        B_pedido.setFont(new Font("cooper black",1,20));
        B_pedido.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        B_pedido.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        B_pedido.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
        panel_principal.add(B_pedido);

        B_prenda_vestir = new JButton("PRENDA VESTIR");
        B_prenda_vestir.setBounds(10, 250,320,40);
        //B_prenda_vestir.addActionListener(this);
        B_prenda_vestir.setBorder(new LineBorder(Color.gray));
        B_prenda_vestir.setFont(new Font("cooper black",1,20));
        B_prenda_vestir.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        B_prenda_vestir.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        B_prenda_vestir.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
        panel_principal.add(B_prenda_vestir);

        B_prodterm_X_pedido = new JButton("PROD TERMINADO X PEDIDO");
        B_prodterm_X_pedido.setBounds(10, 300,320,40);
        //B_prodterm_X_pedido.addActionListener(this);
        B_prodterm_X_pedido.setBorder(new LineBorder(Color.gray));
        B_prodterm_X_pedido.setFont(new Font("cooper black",1,19));
        B_prodterm_X_pedido.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        B_prodterm_X_pedido.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        B_prodterm_X_pedido.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
        panel_principal.add(B_prodterm_X_pedido);

        B_producto_terminado = new JButton("PRODUCTO TERMINADO");
        B_producto_terminado.setBounds(10, 350,320,40);
        //B_producto_terminado.addActionListener(this);
        B_producto_terminado.setBorder(new LineBorder(Color.gray));
        B_producto_terminado.setFont(new Font("cooper black",1,20));
        B_producto_terminado.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        B_producto_terminado.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        B_producto_terminado.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
        panel_principal.add(B_producto_terminado);

        B_proveedor = new JButton("PROOVEEDOR");
        B_proveedor.setBounds(10, 400,320,40);
        //B_proveedor.addActionListener(this);
        B_proveedor.setBorder(new LineBorder(Color.gray));
        B_proveedor.setFont(new Font("cooper black",1,20));
        B_proveedor.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        B_proveedor.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        B_proveedor.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
        panel_principal.add(B_proveedor);

        B_uniforme = new JButton("UNIFORME");
        B_uniforme.setBounds(10, 450,320,40);
        //B_uniforme.addActionListener(this);
        B_uniforme.setBorder(new LineBorder(Color.gray));
        B_uniforme.setFont(new Font("cooper black",1,20));
        B_uniforme.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        B_uniforme.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        B_uniforme.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
        panel_principal.add(B_uniforme);

        B_informe = new JButton("INFORME");
        B_informe.setBounds(10, 500,320,40);
        //B_informe.addActionListener(this);
        B_informe.setBorder(new LineBorder(Color.gray));
        B_informe.setFont(new Font("cooper black",1,20));
        B_informe.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        B_informe.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        B_informe.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
        panel_principal.add(B_informe);

        if(Objects.equals(tipo, "administrador")){
            B_usuario = new JButton("USUARIO");
            B_usuario.setBounds(10, 550,320,40);
            B_usuario.addActionListener(this);
            B_usuario.setBorder(new LineBorder(Color.gray));
            B_usuario.setFont(new Font("cooper black",1,20));
            B_usuario.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
            B_usuario.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
            B_usuario.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
            panel_principal.add(B_usuario);
        }

        B_back= new JButton("Cerrar Sesión ");
        B_back.setBounds(10, 620,140,30);
        B_back.addActionListener(this);
        B_back.setBorder(new LineBorder(Color.gray));
        B_back.setFont(new Font("arial",1,14));
        B_back.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        B_back.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        B_back.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
        panel_principal.add(B_back);

        /* 
        ImageIcon imgOriginal = new ImageIcon(getClass().getResource("/30495.jpg"));
        ImageIcon imgScalada = new ImageIcon(imgOriginal.getImage().getScaledInstance(570,480,Image.SCALE_SMOOTH));
        label = new JLabel(imgScalada);
        label.setBounds(0,0,570,480);
        panel_segundario.add(label);
 */
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == B_cliente){
            panel_segundario.setVisible(false);
            Colegio.setVisible(false);
            colegio.vaciarCampos();
            Cliente.setVisible(true);
            Inventario_Materiales.setVisible(false);
            inventario_materiales.vaciarCampos();
            usuario.setVisible(false);
            Usuario.vaciarCampos();
            Pedido.setVisible(false);
            pedido.vaciarCampos();
        }
        
        if(e.getSource() == B_colegio){
            panel_segundario.setVisible(false);
            Colegio.setVisible(true);
            Cliente.setVisible(false);
            cliente.vaciarCampos();
            Inventario_Materiales.setVisible(false);
            inventario_materiales.vaciarCampos();
            usuario.setVisible(false);
            Usuario.vaciarCampos();
            Pedido.setVisible(false);
            pedido.vaciarCampos();
        }

        if(e.getSource() == B_inventario_materiales){
            panel_segundario.setVisible(false);
            Colegio.setVisible(false);
            colegio.vaciarCampos();
            Cliente.setVisible(false);
            cliente.vaciarCampos();
            Inventario_Materiales.setVisible(true);
            usuario.setVisible(false);
            Usuario.vaciarCampos();
            Pedido.setVisible(false);
            pedido.vaciarCampos();
        }

        if(e.getSource() == B_usuario){
            panel_segundario.setVisible(false);
            Colegio.setVisible(false);
            colegio.vaciarCampos();
            Cliente.setVisible(false);
            cliente.vaciarCampos();
            Inventario_Materiales.setVisible(false);
            inventario_materiales.vaciarCampos();
            usuario.setVisible(true);
            Pedido.setVisible(false);
            pedido.vaciarCampos();
        }

        if(e.getSource() == B_pedido){
            panel_segundario.setVisible(false);
            Colegio.setVisible(false);
            colegio.vaciarCampos();
            Cliente.setVisible(false);
            cliente.vaciarCampos();
            Inventario_Materiales.setVisible(false);
            inventario_materiales.vaciarCampos();
            usuario.setVisible(false);
            Pedido.setVisible(true);
            pedido.vaciarCampos();
        }

        if(e.getSource() == B_back){
            new Login();
            this.dispose();
        }

    }
}
