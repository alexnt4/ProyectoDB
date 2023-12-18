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

public class inventario_materiales extends JPanel implements ActionListener{
    JTextField T_codigoTitulo;
    static JTextField T_codigo;
    JTextField T_descTitulo;
    static JTextField T_desc;
    JTextField T_tipoTitulo;
    static JTextField T_tipo ;
    JTextField T_medidaTitulo;
    static JTextField T_medida;
    JTextField T_cantidadTitulo;
    static JTextField T_cantidad;
    static ButtonGroup bg; //Boton de grupo para que se seleccione solo uno radio buton
    static JTable Tablero;
    static JLabel validar;
    JScrollPane barraDesplazamiento;
    JButton listo;
    JTextArea tituloVentana;
    JRadioButton insertar;
    JRadioButton consultar;
    JRadioButton actualizar;
    JRadioButton eliminar;

    static String tipo;

    public inventario_materiales(String cargo){
        inventario_materiales.tipo = cargo;
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
        tituloVentana.setText("                              TABLA INVENTARIO                                 ");
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

        T_codigoTitulo = new JTextField();
        T_codigoTitulo.setText(" CODIGO MATERIAL *");
        T_codigoTitulo.setFont(new Font("arial", 3, 17));
        T_codigoTitulo.setEditable(false);
        T_codigoTitulo.setBorder(new LineBorder(Color.gray));
        T_codigoTitulo.setBounds(15,80,190,30);
        add(T_codigoTitulo);

        T_codigo  = new JTextField();
        T_codigo .setBounds(225,80,220,31);
        T_codigo .setBorder(new LineBorder(Color.gray));
        add(T_codigo );

        T_descTitulo = new JTextField();
        T_descTitulo.setText(" DESCRIPCION MATERIAL ");
        T_descTitulo.setFont(new Font("arial", 3, 15));
        T_descTitulo.setEditable(false);
        T_descTitulo.setBorder(new LineBorder(Color.gray));
        T_descTitulo.setBounds(15,130,190,30);
        add(T_descTitulo);

        T_desc = new JTextField();
        T_desc.setBounds(225,130,220,31);
        T_desc.setBorder(new LineBorder(Color.gray));
        add( T_desc);

        T_tipoTitulo = new JTextField();
        T_tipoTitulo.setText(" TIPO MATERIAL");
        T_tipoTitulo.setFont(new Font("arial", 3, 15));
        T_tipoTitulo.setBorder(new LineBorder(Color.gray));
        T_tipoTitulo.setEditable(false);
        T_tipoTitulo.setBounds(15,180,190,30);
        add(T_tipoTitulo);

        T_tipo = new JTextField();
        T_tipo.setBounds(225,180,220,31);
        T_tipo.setBorder(new LineBorder(Color.gray));
        add(T_tipo);

        T_medidaTitulo = new JTextField();
        T_medidaTitulo.setText(" UNIDAD DE MEDIDA");
        T_medidaTitulo.setFont(new Font("arial", 3, 15));
        T_medidaTitulo.setBorder(new LineBorder(Color.gray));
        T_medidaTitulo.setEditable(false);
        T_medidaTitulo.setBounds(15,230,190,30);
        add(T_medidaTitulo);

        T_medida = new JTextField();
        T_medida.setBounds(225,230,220,30);
        T_medida.setBorder(new LineBorder(Color.gray));
        add(T_medida);

        T_cantidadTitulo = new JTextField();
        T_cantidadTitulo.setText(" CANTIDAD");
        T_cantidadTitulo.setFont(new Font("arial", 3, 15));
        T_cantidadTitulo.setBorder(new LineBorder(Color.gray));
        T_cantidadTitulo.setEditable(false);
        T_cantidadTitulo.setBounds(475,80,190,30);
        add(T_cantidadTitulo);

        T_cantidad = new JTextField();
        T_cantidad.setBounds(685,80,220,30);
        T_cantidad.setBorder(new LineBorder(Color.gray));
        add(T_cantidad);

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
            T_codigo.setText("");
            T_medida.setText("");
            T_tipo.setText("");
            T_desc.setText("");
            T_cantidad.setText("");
            validar.setText("");
            if(Objects.equals(tipo, "administrador")){
                bg.clearSelection();
            }
        DefaultTableModel modeloVacio = new DefaultTableModel(); // Crea un nuevo modelo vacío
        Tablero.setModel(modeloVacio); 
        }

         
    public void validarCampos(){
        validar.setText("");
        validar.setForeground(Color.red);
        if (T_codigo.getText().isEmpty()) {
            validar.setText("LLENAR EL CAMPO CODIGO DE MATERIAL!");
        } else {
            try {
                int numeroPedido = Integer.parseInt(T_codigo.getText());
    
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

