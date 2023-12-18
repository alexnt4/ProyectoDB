package org.example.vista;

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

public class proveedor extends JPanel implements ActionListener{
    JTextField T_nitTitulo;
    static JTextField T_nit;
    JTextField T_idPrendaTitulo;
    static JTextField T_idPrenda;
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
    JScrollPane barraDesplazamiento;
    JButton listo;
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

        T_idPrendaTitulo = new JTextField();
        T_idPrendaTitulo.setText(" NOMBRE ");
        T_idPrendaTitulo.setFont(new Font("arial", 3, 15));
        T_idPrendaTitulo.setEditable(false);
        T_idPrendaTitulo.setBorder(new LineBorder(Color.gray));
        T_idPrendaTitulo.setBounds(15,130,190,30);
        add(T_idPrendaTitulo);

        T_idPrenda = new JTextField();
        T_idPrenda.setBounds(225,130,220,31);
        T_idPrenda.setBorder(new LineBorder(Color.gray));
        add( T_idPrenda);

        T_dirTitulo = new JTextField();
        T_dirTitulo.setText(" DIRECCIÓN");
        T_dirTitulo.setFont(new Font("arial", 3, 15));
        T_dirTitulo.setBorder(new LineBorder(Color.gray));
        T_dirTitulo.setEditable(false);
        T_dirTitulo.setBounds(15,180,190,30);
        add(T_dirTitulo);

        T_dir = new JTextField();
        T_dir.setBounds(225,180,220,31);
        T_dir.setBorder(new LineBorder(Color.gray));
        add(T_dir);

        T_contactTitulo = new JTextField();
        T_contactTitulo.setText(" CONTACTO");
        T_contactTitulo.setFont(new Font("arial", 3, 15));
        T_contactTitulo.setBorder(new LineBorder(Color.gray));
        T_contactTitulo.setEditable(false);
        T_contactTitulo.setBounds(15,230,190,30);
        add(T_contactTitulo);

        T_contact = new JTextField();
        T_contact.setBounds(225,230,220,30);
        T_contact.setBorder(new LineBorder(Color.gray));
        add(T_contact);

        T_prodTitulo = new JTextField();
        T_prodTitulo.setText(" PRODUCTO");
        T_prodTitulo.setFont(new Font("arial", 3, 15));
        T_prodTitulo.setBorder(new LineBorder(Color.gray));
        T_prodTitulo.setEditable(false);
        T_prodTitulo.setBounds(475,80,190,30);
        add(T_prodTitulo);

        T_prod = new JTextField();
        T_prod.setBounds(685,80,220,30);
        T_prod.setBorder(new LineBorder(Color.gray));
        add(T_prod);

        T_codMaterialTitulo = new JTextField();
        T_codMaterialTitulo.setText(" CODIGO MATERIAL");
        T_codMaterialTitulo.setFont(new Font("arial", 3, 15));
        T_codMaterialTitulo.setBorder(new LineBorder(Color.gray));
        T_codMaterialTitulo.setEditable(false);
        T_codMaterialTitulo.setBounds(475,130,190,30);
        add(T_codMaterialTitulo);

        T_codMaterial = new JTextField();
        T_codMaterial.setBounds(685,130,220,30);
        T_codMaterial.setBorder(new LineBorder(Color.gray));
        add(T_codMaterial);

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
            T_idPrenda.setText("");
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
            //Validar
            validarCampos();
        }
    }
}
