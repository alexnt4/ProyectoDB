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

public class colegio extends JPanel implements ActionListener{
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
    static JTable Tablero;
    JScrollPane barraDesplazamiento;
    JButton listo,ConsultarTelefono;
    JTextArea tituloVentana;
    JRadioButton insertar;
    JRadioButton consultar;
    JRadioButton actualizar;
    JRadioButton eliminar;
    static JLabel validar;
    static String tipo;

    public colegio(String cargo){
        colegio.tipo = cargo;
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
        tituloVentana.setText("                               TABLA COLEGIO                                ");
        tituloVentana.setFocusable(false);
        tituloVentana.setFont(new Font("arial", 3, 33));
        tituloVentana.setEditable(false);
        tituloVentana.setBorder(new LineBorder(Color.gray));
        tituloVentana.setBounds(15,15,705,40);
        add(tituloVentana);

        T_idTitulo = new JTextField();
        T_idTitulo.setText(" ID  COLEGIO *");
        T_idTitulo.setFont(new Font("arial", 3, 17));
        T_idTitulo.setEditable(false);
        T_idTitulo.setBorder(new LineBorder(Color.gray));
        T_idTitulo.setBounds(15,80,190,30);
        add(T_idTitulo);

        T_id  = new JTextField();
        T_id .setBounds(225,80,220,31);
        T_id .setBorder(new LineBorder(Color.gray));
        add(T_id );

        
        validar = new JLabel();
        validar.setText("");
        validar.setBounds(160, 610, 660, 30);
        validar.setFont(new Font("arial",1,30));
        add(validar);

         T_nomTitulo = new JTextField();
         T_nomTitulo.setText(" NOMBRE COLEGIO ");
         T_nomTitulo.setFont(new Font("arial", 3, 17));
         T_nomTitulo.setEditable(false);
         T_nomTitulo.setBorder(new LineBorder(Color.gray));
         T_nomTitulo.setBounds(15,130,190,30);

         T_nom = new JTextField();
         T_nom.setBounds(225,130,220,31);
         T_nom.setBorder(new LineBorder(Color.gray));

        T_dirTitulo = new JTextField();
        T_dirTitulo.setText(" DIRECCION  COLEGIO");
        T_dirTitulo.setFont(new Font("arial", 3, 17));
        T_dirTitulo.setBorder(new LineBorder(Color.gray));
        T_dirTitulo.setEditable(false);
        T_dirTitulo.setBounds(15,180,190,30);

        T_dir = new JTextField();
        T_dir.setBounds(225,180,220,31);
        T_dir.setBorder(new LineBorder(Color.gray));

        T_contactoTitulo = new JTextField();
        T_contactoTitulo.setText(" CONTACTO COLEGIO");
        T_contactoTitulo.setFont(new Font("arial", 3, 15));
        T_contactoTitulo.setBorder(new LineBorder(Color.gray));
        T_contactoTitulo.setEditable(false);
        T_contactoTitulo.setBounds(15,230,190,30);

        T_contacto = new JTextField();
        T_contacto.setBounds(225,230,220,30);
        T_contacto.setBorder(new LineBorder(Color.gray));

        T_telefonoTitulo = new JTextField();
        T_telefonoTitulo.setText(" TELEFONO COLEGIO");
        T_telefonoTitulo.setFont(new Font("arial", 3, 15));
        T_telefonoTitulo.setBorder(new LineBorder(Color.gray));
        T_telefonoTitulo.setEditable(false);
        T_telefonoTitulo.setBounds(475,80,190,30);

        T_telefono = new JTextField();
        T_telefono.setBounds(685,80,220,30);
        T_telefono.setBorder(new LineBorder(Color.gray));

        listo = new JButton("Consultar ");
        listo.setBounds(740,15,165,40);
        listo.addActionListener(this);
        listo.setBorder(new LineBorder(Color.gray));
        listo.setForeground(Color.BLACK); //Color de la letra
        listo.setFont(new Font("cooper black",2,25));
        listo.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        listo.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        listo.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
        add(listo);

        ConsultarTelefono= new JButton("Consultar Telefono");
        ConsultarTelefono.setBounds(15,130,190,30);
        ConsultarTelefono.addActionListener(this);
        ConsultarTelefono.setBorder(new LineBorder(Color.gray));
        ConsultarTelefono.setForeground(Color.BLACK); //Color de la letra
        ConsultarTelefono.setFont(new Font("arial", 3, 16));
        ConsultarTelefono.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        ConsultarTelefono.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        ConsultarTelefono.setFocusPainted(false);
        add(ConsultarTelefono);

        if(Objects.equals(tipo, "administrador")){
        listo.setText("Listo ");

        insertar = new JRadioButton("Insertar");
        insertar.setBounds(15, 280, 115, 30);
        insertar.setFont(new Font("arial",1,15));
        insertar.setContentAreaFilled(true); //Le quito el fondo
        insertar.setFocusPainted(false); //Que no quede seleccionada
        insertar.setBorder(new LineBorder(Color.gray));
        add(insertar);

        consultar = new JRadioButton("consultar");
        consultar.setBounds(150, 280, 115, 30);
        consultar.setFont(new Font("arial",1,15));
        consultar.setBorderPainted(false);
        consultar.setFocusPainted(false); //Que no quede seleccionada
        consultar.setContentAreaFilled(true); //Le quito el fondo
        consultar.setBorder(new LineBorder(Color.gray));
        add(consultar);

        actualizar = new JRadioButton("actualizar");
        actualizar.setBounds(285, 280, 115, 30);
        actualizar.setFont(new Font("arial",1,15));
        actualizar.setBorderPainted(false);
        actualizar.setFocusPainted(false); //Que no quede seleccionada
        actualizar.setContentAreaFilled(true); //Le quito el fondo
        actualizar.setBorder(new LineBorder(Color.gray));
        add(actualizar);

        eliminar = new JRadioButton("eliminar");
        eliminar.setBounds(420, 280, 115, 30);
        eliminar.setFont(new Font("arial",1,15));
        eliminar.setBorderPainted(false);
        eliminar.setFocusPainted(false); //Que no quede seleccionada
        eliminar.setContentAreaFilled(true); //Le quito el fondo
        eliminar.setBorder(new LineBorder(Color.gray));
        add(eliminar);

        ConsultarTelefono.setBounds(475,130,190,30);
        add(T_telefono);
        add(T_telefonoTitulo);
        add(T_contacto);
        add(T_contactoTitulo);
        add(T_dir);
        add(T_dirTitulo);
        add( T_nom);
        add( T_nomTitulo);

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
        T_contacto.setText("");
        T_dir.setText("");
        T_nom.setText("");
        T_telefono.setText("");
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
            validar.setText("LLENAR EL CAMPO ID COLEGIO!");
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

                    // Resto de tu lógica para validar otros campos si es necesario
                    if (eliminar.isSelected()) {
                        int idColegio = Integer.parseInt(T_id.getText());
                        controlador control = new controlador();
                        controlador.eliminarColegio(Integer.parseInt(T_id.getText()));
                        validar.setForeground(new Color(75, 0, 130));
                        validar.setText("               ELIMINADO");
                    } else if (actualizar.isSelected()) {
                        int idColegio = Integer.parseInt(T_id.getText());
                        String nombreColegio = T_nom.getText();
                        String direccionColegio = T_dir.getText();
                        String contactoColegio = T_contacto.getText();
                        //int telefonoColegio = Integer.parseInt(T_telefono.getText());
                        controlador control = new controlador();
                        controlador.actualizarColegio(idColegio, nombreColegio, direccionColegio, contactoColegio, Tablero);
                        validar.setForeground(new Color(0,128,0));
                        validar.setText("                DATO ACTUALIZADO");
                    } else if (consultar.isSelected()) {
                        int idColegio = Integer.parseInt(T_id.getText());
                        controlador control = new controlador();
                        controlador.consultarColegio(idColegio, Tablero);
                        validar.setForeground(Color.black);
                        validar.setText("RESULTADO DE LA CONSULTA");
                    } else if (insertar.isSelected()) {
                        int idColegio = Integer.parseInt(T_id.getText());
                        String nombreColegio = T_nom.getText();
                        String direccionColegio = T_dir.getText();
                        String contactoColegio = T_contacto.getText();
                        //int telefonoColegio = Integer.parseInt(T_telefono.getText());
                        controlador control = new controlador();
                        controlador.agregarColegio(idColegio, nombreColegio, direccionColegio, contactoColegio, Tablero);
                        validar.setForeground(Color.black);
                        validar.setText("               DATO INSERTADO");
                    }

            }else{//Es vendedor y solo evalua llave primaria
 
                if (T_id.getText().isEmpty()) {
                    validar.setForeground(Color.red);
                    validar.setText("LLENAR EL CAMPO ID COLEGIO!");
                }else{
                    //En llave primaria hay algo
                    int idColegio = Integer.parseInt(T_id.getText());
                    controlador control = new controlador();
                    controlador.consultarColegio(idColegio, Tablero);
                    validar.setForeground(Color.black);
                    validar.setText("RESULTADO DE LA CONSULTA");
                }
            }
        }
        if(e.getSource() == ConsultarTelefono){
            if (T_id.getText().isEmpty()) {
                validar.setForeground(Color.red);
                validar.setText("LLENAR EL CAMPO ID COLEGIO!");
            }else{
                int idColegio = Integer.parseInt(T_id.getText());
                controlador control = new controlador();
                controlador.consultarTelColegio(idColegio, Tablero);
                validar.setForeground(Color.black);
                validar.setText("RESULTADO DE LA CONSULTA");
            }
        }
    }
}
