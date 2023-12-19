package org.example.vista;

import org.example.controlador.controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

public class proveedor extends JPanel implements ActionListener{
    JTextField T_nitTitulo;
    static JTextField T_nit;
    JTextField T_nombreTitulo;
    static JTextField T_nombre;
    JTextField T_dirTitulo;
    static JTextField T_dir ;
    JTextField T_contactTitulo;
    static JTextField T_contact;
    JTextField T_prodTitulo;
    static JTextField T_prod;
    JTextField T_codMaterialTitulo;
    static JTextField T_codMaterial;
    static ButtonGroup bg; //Boton de grupo para que se seleccione solo uno radio buton
    static JTable Tablero;
    JTextField T_telefonoTitulo;
    static JTextField T_telefono;
    JScrollPane barraDesplazamiento;
    JButton listo,ConsultarTelefono;
    JTextArea tituloVentana;
    JRadioButton insertar;
    JRadioButton consultar;
    JRadioButton actualizar;
    JRadioButton eliminar;
    static JLabel validar;


    static String tipo;

    public proveedor (String cargo){
        proveedor.tipo = cargo;
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
        tituloVentana.setText("                           TABLA PROVEEDOR                                ");
        tituloVentana.setFocusable(false);
        tituloVentana.setFont(new Font("arial", 3, 30));
        tituloVentana.setEditable(false);
        tituloVentana.setBorder(new LineBorder(Color.gray));
        tituloVentana.setBounds(15,15,705,40);
        add(tituloVentana);

        validar = new JLabel();
        validar.setText("");
        validar.setBounds(160, 610, 660, 30);
        validar.setFont(new Font("arial",1,30));
        add(validar);

        T_nitTitulo = new JTextField();
        T_nitTitulo.setText(" NIT *");
        T_nitTitulo.setFont(new Font("arial", 3, 17));
        T_nitTitulo.setEditable(false);
        T_nitTitulo.setBorder(new LineBorder(Color.gray));
        T_nitTitulo.setBounds(15,80,190,30);
        add(T_nitTitulo);

        T_nit  = new JTextField();
        T_nit.setBounds(225,80,220,31);
        T_nit.setBorder(new LineBorder(Color.gray));
        add(T_nit);

        T_nombreTitulo = new JTextField();
        T_nombreTitulo.setText(" NOMBRE ");
        T_nombreTitulo.setFont(new Font("arial", 3, 15));
        T_nombreTitulo.setEditable(false);
        T_nombreTitulo.setBorder(new LineBorder(Color.gray));
        T_nombreTitulo.setBounds(15,130,190,30);

        T_nombre = new JTextField();
        T_nombre.setBounds(225,130,220,31);
        T_nombre.setBorder(new LineBorder(Color.gray));

        T_dirTitulo = new JTextField();
        T_dirTitulo.setText(" DIRECCIÓN");
        T_dirTitulo.setFont(new Font("arial", 3, 15));
        T_dirTitulo.setBorder(new LineBorder(Color.gray));
        T_dirTitulo.setEditable(false);
        T_dirTitulo.setBounds(15,180,190,30);

        T_dir = new JTextField();
        T_dir.setBounds(225,180,220,31);
        T_dir.setBorder(new LineBorder(Color.gray));

        T_contactTitulo = new JTextField();
        T_contactTitulo.setText(" CONTACTO");
        T_contactTitulo.setFont(new Font("arial", 3, 15));
        T_contactTitulo.setBorder(new LineBorder(Color.gray));
        T_contactTitulo.setEditable(false);
        T_contactTitulo.setBounds(15,230,190,30);

        T_contact = new JTextField();
        T_contact.setBounds(225,230,220,30);
        T_contact.setBorder(new LineBorder(Color.gray));

        T_prodTitulo = new JTextField();
        T_prodTitulo.setText(" PRODUCTO");
        T_prodTitulo.setFont(new Font("arial", 3, 15));
        T_prodTitulo.setBorder(new LineBorder(Color.gray));
        T_prodTitulo.setEditable(false);
        T_prodTitulo.setBounds(475,80,190,30);

        T_prod = new JTextField();
        T_prod.setBounds(685,80,220,30);
        T_prod.setBorder(new LineBorder(Color.gray));

        T_codMaterialTitulo = new JTextField();
        T_codMaterialTitulo.setText(" CODIGO MATERIAL");
        T_codMaterialTitulo.setFont(new Font("arial", 3, 15));
        T_codMaterialTitulo.setBorder(new LineBorder(Color.gray));
        T_codMaterialTitulo.setEditable(false);
        T_codMaterialTitulo.setBounds(475,130,190,30);

        T_codMaterial = new JTextField();
        T_codMaterial.setBounds(685,130,220,30);
        T_codMaterial.setBorder(new LineBorder(Color.gray));

        T_telefonoTitulo = new JTextField();
        T_telefonoTitulo.setText(" TELEFONO PROVEEDOR ");
        T_telefonoTitulo.setFont(new Font("arial", 3, 14));
        T_telefonoTitulo.setBorder(new LineBorder(Color.gray));
        T_telefonoTitulo.setEditable(false);
        T_telefonoTitulo.setBounds(475,180,190,30);


        T_telefono = new JTextField();
        T_telefono.setBounds(685,180,220,30);
        T_telefono.setBorder(new LineBorder(Color.gray));

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

        if(Objects.equals(tipo, "administrador")){
            add(T_nombreTitulo);
            add(T_nombre);
            add(T_dirTitulo);
            add(T_dir);
            add(T_contactTitulo);
            add(T_contact);
            add(T_prodTitulo);
            add(T_prod);
            add(T_codMaterialTitulo);
            add(T_codMaterial);
            add(T_telefonoTitulo);
            add(T_telefono);
            ConsultarTelefono.setBounds(475,230,190,30);    
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
            T_nit.setText("");
            T_contact.setText("");
            T_dir.setText("");
            T_telefono.setText("");
            T_nombre.setText("");
            T_prod .setText("");
            T_codMaterial.setText("");
            validar.setText("");
            DefaultTableModel modeloVacio = new DefaultTableModel(); // Crea un nuevo modelo vacío
        Tablero.setModel(modeloVacio); 
            if(Objects.equals(tipo, "administrador")){
                bg.clearSelection();
            }
        }

        public void validarCampos(){
        validar.setText("");
        validar.setForeground(Color.red);
        if (T_nit.getText().isEmpty()) {
            validar.setText("LLENAR EL CAMPO NIT PROVEEDOR");
        } else {
            try {
                int numeroPedido = Integer.parseInt(T_nit.getText());
    
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
                   int NIT = Integer.parseInt(T_nit.getText());
                   String Nombre = T_nombre.getText();
                   String Direccion = T_dir.getText();
                   String Contacto = T_contact.getText();
                   String Producto = T_prod.getText();
                   int codMaterial = Integer.parseInt(T_codMaterial.getText());
                   controlador control = new controlador();
                   controlador.agregarProveedor(NIT, Nombre, Direccion, Contacto, Producto, codMaterial, Tablero);
                   validar.setForeground(Color.black);
                   validar.setText("               DATO INSERTADO");
               } else if (actualizar.isSelected()) {
                   int NIT = Integer.parseInt(T_nit.getText());
                   String Nombre = T_nombre.getText();
                   String Direccion = T_dir.getText();
                   String Contacto = T_contact.getText();
                   String Producto = T_prod.getText();
                   int codMaterial = T_codMaterial.getText().isEmpty() ? 0 : Integer.parseInt(T_codMaterial.getText());
                   controlador control = new controlador();
                   controlador.actualizarProveedor(NIT, Nombre, Direccion, Contacto, Producto, codMaterial, Tablero);
                   validar.setForeground(new Color(0,128,0));
                   validar.setText("                DATO ACTUALIZADO");
               } else if (consultar.isSelected()) {
                   int NIT = Integer.parseInt(T_nit.getText());
                   controlador.consultarProveedor(NIT, Tablero);
                   validar.setForeground(Color.black);
                   validar.setText("                RESULTADO DE CONSULTA");
               } else if (eliminar.isSelected()) {
                   int NIT = Integer.parseInt(T_nit.getText());
                   controlador.eliminarProveedor(NIT);
                   validar.setForeground(new Color(75, 0, 130));
                   validar.setText("               ELIMINADO");
               } else {
                   validar.setForeground(Color.red);
                   validar.setText("ESCOJA UNA OPCION");
               }

        }else{//Es vendedor y solo evalua llave primaria
                if (T_nit.getText().isEmpty()) {
                    validar.setForeground(Color.red);
                    validar.setText("LLENAR EL CAMPO NIT PROVEEDOR!");
                }else{
                    //En llave primaria hay algo
                    int NIT = Integer.parseInt(T_nit.getText());
                    controlador.consultarProveedor(NIT, Tablero);

                    validar.setForeground(Color.black);
                    validar.setText("RESULTADO DE LA CONSULTA");
                }
           }
        }
        if(e.getSource() == ConsultarTelefono){
            if (T_nit.getText().isEmpty()) {
                validar.setForeground(Color.red);
                validar.setText("LLENAR EL CAMPO NIT PROVEEDOR!");
            }else{
                int nitProveedor = Integer.parseInt(T_nit.getText());
                controlador control = new controlador();
                controlador.consultarTelProveedor(nitProveedor, Tablero);
                validar.setForeground(Color.black);
                validar.setText("RESULTADO DE LA CONSULTA");
            }
        }
    }
}
