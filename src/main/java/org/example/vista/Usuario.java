package org.example.vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Usuario extends JPanel{
    JTextField T_idTitulo,T_rolTitulo;
    static JTextField T_id;
    JTextField T_nomTitulo;
    static JTextField T_nom;
    JTextField T_contraTitulo;
    static JTextField T_contra ;
    static ButtonGroup bg; //Boton de grupo para que se seleccione solo uno radio buton
    static JTextArea Tablero;
    JScrollPane barraDesplazamiento;
    JButton listo;
    JTextArea tituloVentana;
    JRadioButton insertar;
    JRadioButton consultar;
    JRadioButton actualizar;
    JRadioButton eliminar;

    JRadioButton administrador;
    JRadioButton vendedor;

    static ButtonGroup bg1;


    public Usuario(){
        Gui(); //Funcion que genera la vista
        vaciarCampos();
    }

    public void Gui(){
        setLayout(null);
        setBounds(350,5,920,650);
        setBackground(new Color(0, 191, 255));
        //setBackground(new Color(220, 220, 220)); //Activelo cuando quiera ver el panel
        setVisible(false);

        tituloVentana = new JTextArea();
        tituloVentana.setText("                  GESTION DE USUARIOS                                 ");
        tituloVentana.setFocusable(false);
        tituloVentana.setFont(new Font("arial", 3, 33));
        tituloVentana.setEditable(false);
        tituloVentana.setBorder(new LineBorder(Color.gray));
        tituloVentana.setBounds(15,15,705,40);
        add(tituloVentana);

        T_idTitulo = new JTextField();
        T_idTitulo.setText(" ID  USUARIO");
        T_idTitulo.setFont(new Font("arial", 3, 17));
        T_idTitulo.setEditable(false);
        T_idTitulo.setBorder(new LineBorder(Color.gray));
        T_idTitulo.setBounds(15,80,190,30);
        add(T_idTitulo);

        T_id  = new JTextField();
        T_id.setBounds(225,80,220,31);
        T_id.setBorder(new LineBorder(Color.gray));
        add(T_id );

         T_nomTitulo = new JTextField();
         T_nomTitulo.setText(" NOMBRE USUARIO");
         T_nomTitulo.setFont(new Font("arial", 3, 17));
         T_nomTitulo.setEditable(false);
         T_nomTitulo.setBorder(new LineBorder(Color.gray));
         T_nomTitulo.setBounds(15,130,190,30);
        add( T_nomTitulo);

         T_nom = new JTextField();
         T_nom.setBounds(240,130,290,31);
         T_nom.setBounds(225,130,220,31);
        add( T_nom);

        T_contraTitulo = new JTextField();
        T_contraTitulo.setText(" CONTRASEÑA");
        T_contraTitulo.setFont(new Font("arial", 3, 17));
        T_contraTitulo.setBorder(new LineBorder(Color.gray));
        T_contraTitulo.setEditable(false);
        T_contraTitulo.setBounds(15,180,190,30);
        add(T_contraTitulo);

        T_contra = new JTextField();
        T_contra.setBounds(225,180,220,31);
        T_contra.setBorder(new LineBorder(Color.gray));
        add(T_contra);


        listo = new JButton("Listo ");
        listo.setBounds(740,15,165,40);
        //listo.addActionListener(this);
        listo.setBorder(new LineBorder(Color.gray));
        listo.setForeground(Color.BLACK); //Color de la letra
        listo.setFont(new Font("cooper black",2,25));
        listo.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        listo.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        listo.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
        add(listo);

        T_rolTitulo = new JTextField();
        T_rolTitulo.setText(" ROL");
        T_rolTitulo.setFont(new Font("arial", 3, 17));
        T_rolTitulo.setEditable(false);
        T_rolTitulo.setBorder(new LineBorder(Color.gray));
        T_rolTitulo.setBounds(475,80,320,30);
        add(T_rolTitulo);


        administrador = new JRadioButton("Administrador");
        administrador.setBounds(475,130, 150, 30);
        administrador.setFont(new Font("arial",1,15));
        administrador.setContentAreaFilled(true); //Le quito el fondo
        administrador.setFocusPainted(false); //Que no quede seleccionada
        administrador.setBorder(new LineBorder(Color.gray));
        administrador.setBackground(Color.white);
        add(administrador);

        vendedor = new JRadioButton("Vendedor");
        vendedor.setBounds(645,130, 150, 30);
        vendedor.setFont(new Font("arial",1,15));
        vendedor.setContentAreaFilled(true); //Le quito el fondo
        vendedor.setFocusPainted(false); //Que no quede seleccionada
        vendedor.setBorder(new LineBorder(Color.gray));
        vendedor.setBackground(Color.white);
        add(vendedor);

        insertar = new JRadioButton("insertar");
        insertar.setBounds(15, 280, 115, 30);
        insertar.setFont(new Font("arial",1,15));
        insertar.setContentAreaFilled(true); //Le quito el fondo
        insertar.setFocusPainted(false); //Que no quede seleccionada
        insertar.setBorder(new LineBorder(Color.gray));
        insertar.setBackground(Color.WHITE);
        add(insertar);

        consultar = new JRadioButton("consultar");
        consultar.setBounds(150, 280, 115, 30);
        consultar.setFont(new Font("arial",1,15));
        consultar.setBorderPainted(false);
        consultar.setFocusPainted(false); //Que no quede seleccionada
        consultar.setContentAreaFilled(true); //Le quito el fondo
        consultar.setBorder(new LineBorder(Color.gray));
        consultar.setBackground(Color.WHITE);
        add(consultar);

        actualizar = new JRadioButton("actualizar");
        actualizar.setBounds(285, 280, 115, 30);
        actualizar.setFont(new Font("arial",1,15));
        actualizar.setBorderPainted(false);
        actualizar.setFocusPainted(false); //Que no quede seleccionada
        actualizar.setContentAreaFilled(true); //Le quito el fondo
        actualizar.setBorder(new LineBorder(Color.gray));
        actualizar.setBackground(Color.WHITE);
        add(actualizar);

        eliminar = new JRadioButton("eliminar");
        eliminar.setBounds(420, 280, 115, 30);
        eliminar.setFont(new Font("arial",1,15));
        eliminar.setBorderPainted(false);
        eliminar.setFocusPainted(false); //Que no quede seleccionada
        eliminar.setContentAreaFilled(true); //Le quito el fondo
        eliminar.setBorder(new LineBorder(Color.gray));
        eliminar.setBackground(Color.WHITE);
        add(eliminar);

        bg = new ButtonGroup();
        bg.add(insertar);
        bg.add(actualizar);
        bg.add(consultar);
        bg.add(eliminar);

        bg1 = new ButtonGroup();
        bg1.add(administrador);
        bg1.add(vendedor);

        Tablero = new JTextArea();
        Tablero.setFont(new Font("arial", 2, 15));
        Tablero.setEditable(true);
        barraDesplazamiento = new JScrollPane(Tablero);
        barraDesplazamiento.setBounds(15,340,890,250);
        barraDesplazamiento.setBorder(new LineBorder(Color.gray));
        add(barraDesplazamiento);
    }

    public static void vaciarCampos() {
        T_id.setText("");
        T_contra.setText("");
        T_nom.setText("");
        Tablero.setText("");
        bg.clearSelection();
        bg1.clearSelection();
    }
}
