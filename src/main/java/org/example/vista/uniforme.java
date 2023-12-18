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

public class uniforme extends JPanel implements ActionListener{
    JTextField T_idTitulo;
    static JTextField T_id;
    JTextField T_caractTitulo;
    static JTextField T_caract;
    JTextField T_idColegioTitulo;
    static JTextField T_idColegio;
    static ButtonGroup bg; //Boton de grupo para que se seleccione solo uno radio buton
    static JTable Tablero;
    JScrollPane barraDesplazamiento;
    JButton listo;
    JTextArea tituloVentana;
    JRadioButton insertar;
    JRadioButton consultar;
    JRadioButton actualizar;
    JRadioButton eliminar;
    static String tipo;
    static JLabel validar;


    public uniforme(String cargo){
        uniforme.tipo = cargo;
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
        tituloVentana.setText("                            TABLA UNIFORME                                 ");
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

        T_idTitulo = new JTextField();
        T_idTitulo.setText(" ID PRENDA *");
        T_idTitulo.setFont(new Font("arial", 3, 17));
        T_idTitulo.setEditable(false);
        T_idTitulo.setBorder(new LineBorder(Color.gray));
        T_idTitulo.setBounds(15,80,250,30);
        add(T_idTitulo);

        T_id = new JTextField();
        T_id.setBounds(285,80,220,31);
        T_id.setBorder(new LineBorder(Color.gray));
        add(T_id);

        T_caractTitulo = new JTextField();
        T_caractTitulo.setText(" CARACTERISTICA ESPECIAL");
        T_caractTitulo.setFont(new Font("arial", 3, 17));
        T_caractTitulo.setEditable(false);
        T_caractTitulo.setBorder(new LineBorder(Color.gray));
        T_caractTitulo.setBounds(15,130,250,30);

        T_caract = new JTextField();
        T_caract.setBounds(285,130,220,31);
        T_caract.setBorder(new LineBorder(Color.gray));

        T_idColegioTitulo = new JTextField();
        T_idColegioTitulo.setText(" ID COLEGIO");
        T_idColegioTitulo.setFont(new Font("arial", 3, 15));
        T_idColegioTitulo.setBorder(new LineBorder(Color.gray));
        T_idColegioTitulo.setEditable(false);
        T_idColegioTitulo.setBounds(15,180,250,30);

        T_idColegio = new JTextField();
        T_idColegio.setBounds(285,180,220,31);
        T_idColegio.setBorder(new LineBorder(Color.gray));

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
            add(T_caractTitulo);
            add(T_caract);
            add(T_idColegioTitulo);
            add(T_idColegio);




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
        T_caract.setText("");
        T_idColegio.setText("");
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
            validar.setText("LLENAR EL CAMPO ID PRENDA");
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
           if(Objects.equals(tipo, "administrador")){  
            //Si es admin evalua los dos campos
            validarCampos();
               if (insertar.isSelected()){
                   int IDprenda = Integer.parseInt(T_id.getText());
                   String carac = T_caract.getText();
                   int IDcolegio = Integer.parseInt(T_idColegio.getText());
                   controlador control = new controlador();
                   controlador.agregarUniforme(IDprenda, carac, IDcolegio, Tablero);
                   validar.setForeground(Color.black);
                   validar.setText("               DATO INSERTADO");
               } else if (actualizar.isSelected()) {
                   int IDprenda = Integer.parseInt(T_id.getText());
                   String carac = T_caract.getText();
                   int  IDcolegio = T_idColegio.getText().isEmpty() ? 0 : Integer.parseInt(T_idColegio.getText());
                   controlador control = new controlador();
                   controlador.actualizarUniforme(IDprenda, carac, IDcolegio, Tablero);
                   validar.setForeground(new Color(0,128,0));
                   validar.setText("                DATO ACTUALIZADO");
               } else if (consultar.isSelected()) {
                   int ID = Integer.parseInt(T_id.getText());
                   controlador.consultarUniforme(ID, Tablero);
                   validar.setForeground(Color.black);
                   validar.setText("                RESULTADO DE CONSULTA");
               } else if (eliminar.isSelected()) {
                   int ID = Integer.parseInt(T_id.getText());
                   controlador.eliminarUniforme(ID);
                   validar.setForeground(new Color(75, 0, 130));
                   validar.setText("               ELIMINADO");
               } else {
                   validar.setForeground(Color.red);
                   validar.setText("ESCOJA UNA OPCION");
               }
        }else{//Es vendedor y solo evalua llave primaria

            if (T_id.getText().isEmpty()) {
                validar.setForeground(Color.red);
                validar.setText("LLENAR EL CAMPO ID PRENDA!");
            }else{
                //En llave primaria hay algo
                int ID = Integer.parseInt(T_id.getText());
                controlador.consultarUniforme(ID, Tablero);
                validar.setForeground(Color.black);
                validar.setText("RESULTADO DE LA CONSULTA");
            }
            
        }
        }
    }
}
