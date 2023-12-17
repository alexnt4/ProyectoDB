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

public class colegio extends JPanel{
    JTextField T_idTitulo;
    static JTextField T_id;
    JTextField T_nomTitulo;
    static JTextField T_nom;
    JTextField T_dirTitulo;
    static JTextField T_dir ;
    JTextField T_contactoTitulo;
    static JTextField T_contacto;
    JTextField T_telefonoTitulo;
    static JTextField T_telefono;
    static ButtonGroup bg; //Boton de grupo para que se seleccione solo uno radio buton
    static JTextArea Tablero;
    JScrollPane barraDesplazamiento;
    JButton listo;
    JTextArea tituloVentana;
    JRadioButton insertar;
    JRadioButton consultar;
    JRadioButton actualizar;
    JRadioButton eliminar;

    public colegio(){
        GuiColegio(); //Funcion que genera la vista
        vaciarCampos();
    }

    public void GuiColegio(){
        setLayout(null);
        setBounds(350,5,580,650);
        setBackground(new Color(0, 191, 255));
        //setBackground(new Color(220, 220, 220)); //Activelo cuando quiera ver el panel
        setVisible(false);

        tituloVentana = new JTextArea();
        tituloVentana.setText(" TABLA COLEGIO");
        tituloVentana.setFocusable(false);
        tituloVentana.setFont(new Font("arial", 3, 33));
        tituloVentana.setEditable(false);
        tituloVentana.setBorder(new LineBorder(Color.gray));
        tituloVentana.setBounds(30,15,310,40);
        add(tituloVentana);

        T_idTitulo = new JTextField();
        T_idTitulo.setText(" ID  COLEGIO");
        T_idTitulo.setFont(new Font("arial", 3, 17));
        T_idTitulo.setEditable(false);
        T_idTitulo.setBorder(new LineBorder(Color.gray));
        T_idTitulo.setBounds(30,80,190,30);
        add(T_idTitulo);

        T_id  = new JTextField();
        T_id .setBounds(240,80,290,31);
        T_id .setBorder(new LineBorder(Color.gray));
        add(T_id );

         T_nomTitulo = new JTextField();
         T_nomTitulo.setText(" NOMBRE COLEGIO ");
         T_nomTitulo.setFont(new Font("arial", 3, 17));
         T_nomTitulo.setEditable(false);
         T_nomTitulo.setBorder(new LineBorder(Color.gray));
         T_nomTitulo.setBounds(30,130,190,30);
        add( T_nomTitulo);

         T_nom = new JTextField();
         T_nom.setBounds(240,130,290,31);
         T_nom.setBorder(new LineBorder(Color.gray));
        add( T_nom);

        T_dirTitulo = new JTextField();
        T_dirTitulo.setText(" DIRECCION  COLEGIO");
        T_dirTitulo.setFont(new Font("arial", 3, 17));
        T_dirTitulo.setBorder(new LineBorder(Color.gray));
        T_dirTitulo.setEditable(false);
        T_dirTitulo.setBounds(30,180,190,30);
        add(T_dirTitulo);

        T_dir = new JTextField();
        T_dir.setBounds(240,180,290,31);
        T_dir.setBorder(new LineBorder(Color.gray));
        add(T_dir);

        T_contactoTitulo = new JTextField();
        T_contactoTitulo.setText(" CONTACTO COLEGIO");
        T_contactoTitulo.setFont(new Font("arial", 3, 15));
        T_contactoTitulo.setBorder(new LineBorder(Color.gray));
        T_contactoTitulo.setEditable(false);
        T_contactoTitulo.setBounds(30,230,190,30);
        add(T_contactoTitulo);

        T_contacto = new JTextField();
        T_contacto.setBounds(240,230,290,30);
        T_contacto.setBorder(new LineBorder(Color.gray));
        add(T_contacto);

        T_telefonoTitulo = new JTextField();
        T_telefonoTitulo.setText(" TELEFONO COLEGIO");
        T_telefonoTitulo.setFont(new Font("arial", 3, 15));
        T_telefonoTitulo.setBorder(new LineBorder(Color.gray));
        T_telefonoTitulo.setEditable(false);
        T_telefonoTitulo.setBounds(30,280,190,30);
        add(T_telefonoTitulo);

        T_telefono = new JTextField();
        T_telefono.setBounds(240,280,290,30);
        T_telefono.setBorder(new LineBorder(Color.gray));
        add(T_telefono);

        listo = new JButton("Listo ");
        listo.setBounds(360,15,165,40);
        //listo.addActionListener(this);
        listo.setBorder(new LineBorder(Color.gray));
        listo.setForeground(Color.BLACK); //Color de la letra
        listo.setFont(new Font("cooper black",2,25));
        listo.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        listo.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        listo.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
       
        add(listo);

        insertar = new JRadioButton("Insertar");
        insertar.setBounds(30, 330, 115, 30);
        insertar.setFont(new Font("arial",1,15));
        insertar.setContentAreaFilled(true); //Le quito el fondo
        insertar.setFocusPainted(false); //Que no quede seleccionada
        insertar.setBorder(new LineBorder(Color.gray));
        add(insertar);

        consultar = new JRadioButton("consultar");
        consultar.setBounds(160, 330, 115, 30);
        consultar.setFont(new Font("arial",1,15));
        consultar.setBorderPainted(false);
        consultar.setFocusPainted(false); //Que no quede seleccionada
        consultar.setContentAreaFilled(true); //Le quito el fondo
        consultar.setBorder(new LineBorder(Color.gray));
        add(consultar);

        actualizar = new JRadioButton("actualizar");
        actualizar.setBounds(285, 330, 115, 30);
        actualizar.setFont(new Font("arial",1,15));
        actualizar.setBorderPainted(false);
        actualizar.setFocusPainted(false); //Que no quede seleccionada
        actualizar.setContentAreaFilled(true); //Le quito el fondo
        actualizar.setBorder(new LineBorder(Color.gray));
        add(actualizar);

        eliminar = new JRadioButton("eliminar");
        eliminar.setBounds(415, 330, 115, 30);
        eliminar.setFont(new Font("arial",1,15));
        eliminar.setBorderPainted(false);
        eliminar.setFocusPainted(false); //Que no quede seleccionada
        eliminar.setContentAreaFilled(true); //Le quito el fondo
        eliminar.setBorder(new LineBorder(Color.gray));
        add(eliminar);

        bg = new ButtonGroup();
        bg.add(insertar);
        bg.add(actualizar);
        bg.add(consultar);
        bg.add(eliminar);

        Tablero = new JTextArea();
        Tablero.setFont(new Font("arial", 2, 15));
        Tablero.setEditable(true);
        barraDesplazamiento = new JScrollPane(Tablero);
        barraDesplazamiento.setBounds(30,380,503,250);
        barraDesplazamiento.setBorder(new LineBorder(Color.gray));
        add(barraDesplazamiento);
    }

    public static void vaciarCampos() {
        T_id.setText("");
        T_contacto.setText("");
        T_dir.setText("");
         T_nom.setText("");
        T_telefono.setText("");
        Tablero.setText("");
        bg.clearSelection();
    }
}
