package org.example.vista;

import org.example.controlador.controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class prodterm_x_pedido extends JPanel implements ActionListener{
    JTextField T_idTitulo;
    static JTextField T_id;
    JTextField T_nomTitulo;
    static JTextField T_nom;
    static ButtonGroup bg; //Boton de grupo para que se seleccione solo uno radio buton
    static JTable Tablero;
    JScrollPane barraDesplazamiento;
    JButton listo;
    JTextArea tituloVentana;
    JRadioButton insertar;
    JRadioButton consultar;
    JRadioButton actualizar;
    JRadioButton eliminar;
    static JLabel validar;
    static String tipo;

    public prodterm_x_pedido(String cargo){
        prodterm_x_pedido.tipo = cargo;
        Gui();
        vaciarCampos();
    }
    public void Gui(){
        setLayout(null);
        setBounds(350,5,920,650);
        setBackground(new Color(0, 191, 255));
        //setBackground(new Color(220, 220, 220)); //Activelo cuando quiera ver el panel
        setVisible(false);

        tituloVentana = new JTextArea();
        tituloVentana.setText("        PRODUCTO TERMINADO X PEDIDO                          ");
        tituloVentana.setFocusable(false);
        tituloVentana.setFont(new Font("arial", 3, 33));
        tituloVentana.setEditable(false);
        tituloVentana.setBorder(new LineBorder(Color.gray));
        tituloVentana.setBounds(15,15,705,40);
        add(tituloVentana);


        validar = new JLabel();
        validar.setText("");
        validar.setBounds(160, 610, 660, 30);
        validar.setFont(new Font("arial",1,30));
        add(validar);
        validar.setText("");

        T_idTitulo = new JTextField();
        T_idTitulo.setText(" NUMERO PEDIDO *");
        T_idTitulo.setFont(new Font("arial", 3, 17));
        T_idTitulo.setEditable(false);
        T_idTitulo.setBorder(new LineBorder(Color.gray));
        T_idTitulo.setBounds(15,80,300,30);
        add(T_idTitulo);

        T_id = new JTextField();
        T_id.setBounds(335,80,220,31);
        T_id.setBorder(new LineBorder(Color.gray));
        add(T_id);

        T_nomTitulo = new JTextField();
        T_nomTitulo.setText(" CODIGO PRODUCTO TERMINADO");
        T_nomTitulo.setFont(new Font("arial", 3, 17));
        T_nomTitulo.setEditable(false);
        T_nomTitulo.setBorder(new LineBorder(Color.gray));
        T_nomTitulo.setBounds(15,130,300,30);
        add(T_nomTitulo);

        T_nom = new JTextField();
        T_nom.setBounds(335,130,220,31);
        T_nom.setBorder(new LineBorder(Color.gray));
        add(T_nom);

        listo = new JButton("Consultar ");
        listo.setBounds(740,15,165,40);
        listo.addActionListener(this);
        listo.setBorder(new LineBorder(Color.gray));
        listo.setForeground(Color.BLACK); //Color de la letra
        listo.setFont(new Font("cooper black",2,25));
        listo.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        listo.setContentAreaFilled(true); //Establece si el área sde contenido del botón debe ser dibujada o no.
        listo.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
       
        add(listo);

        if(Objects.equals(tipo, "administrador")){
            listo.setText("Listo ");

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
        }
    

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
    }

    public static void vaciarCampos() {
        T_id.setText("");
        T_nom.setText("");
        DefaultTableModel modeloVacio = new DefaultTableModel(); // Crea un nuevo modelo vacío
        Tablero.setModel(modeloVacio); 
        validar.setText("");
        if(Objects.equals(tipo, "administrador")){
            bg.clearSelection();
        }
    }






        
    public void validarCampos(){
        validar.setText("");
        validar.setForeground(Color.red);
        if (T_id.getText().isEmpty()) {
            validar.setText("LLENAR EL CAMPO NUMERO PEDIDO");
        } else {
            try {
                int numeroPedido = Integer.parseInt(T_id.getText());
    
                // Resto de tu lógica para validar otros campos si es necesario
                if (!eliminar.isSelected() && !actualizar.isSelected() && !consultar.isSelected() && !insertar.isSelected()) {
                    validar.setText("       ESCOJA UN CAMPO!");
                }
            } catch (NumberFormatException e) {
                validar.setText("EL CAMPO NUMERO DE PEDIDO DEBE SER UN NÚMERO ENTERO!");
                }
            }  
        }

    public void actionPerformed(ActionEvent e) {
        validar.setText(""); //Vaciar el texto
        if (e.getSource() == listo) {
           //Validar si es admin
           if(Objects.equals(tipo, "administrador")) {
               //Si es admin evalua los dos campos
               validarCampos();
               controlador control = new controlador();
               if (insertar.isSelected()) {
                   int numeroPedido = Integer.parseInt(T_id.getText());
                   int codProdTerm = Integer.parseInt(T_nom.getText());
                   controlador.agregarProdTerm_x_pedido(numeroPedido, codProdTerm, Tablero);
                   validar.setForeground(Color.black);
                   validar.setText("INSERTAR");
               } else if (actualizar.isSelected()) {
                   int numeroPedido = Integer.parseInt(T_id.getText());
                   int codProdTerm = Integer.parseInt(T_nom.getText());
                   controlador.actualizarProdTerm_x_pedido(numeroPedido, codProdTerm, Tablero);
                   validar.setForeground(Color.black);
                   validar.setText("ACTUALIZAR");

               } else if (consultar.isSelected()) {
                   int numeroPedido = Integer.parseInt(T_id.getText());
                   controlador.consultarProdTerm_x_pedido(numeroPedido, Tablero);
                   validar.setForeground(Color.black);
                   validar.setText("CONSULTAR");
               } else if (eliminar.isSelected()) {
                   int numeroPedido = Integer.parseInt(T_id.getText());
                   int Pedido = Integer.parseInt(T_nom.getText());
                   controlador.eliminarProdTerm_x_pedido(numeroPedido, Pedido);
                   validar.setForeground(Color.black);
                   validar.setText("ELIMINAR");
               }
           }

            else{//Es vendedor y solo evalua llave primaria

            if (T_id.getText().isEmpty()) {
                validar.setForeground(Color.red);
                validar.setText("LLENAR EL CAMPO NUMERO PEDIDO!");
            }else{
                int numeroPedido = Integer.parseInt(T_id.getText());
                controlador control = new controlador();
                controlador.consultarProdTerm_x_pedido(numeroPedido, Tablero);
                //En llave primaria hay algo
                validar.setForeground(Color.black);
                validar.setText("RESULTADO DE LA CONSULTA");
            }
            
        }
        }
    }
}
