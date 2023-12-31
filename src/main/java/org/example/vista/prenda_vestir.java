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

import org.example.controlador.controlador;

public class prenda_vestir extends JPanel implements ActionListener{
    JTextField T_idTitulo;
    static JTextField T_id;
    JTextField T_colorTitulo;
    static JTextField T_color;
    JTextField T_tipoTitulo;
    static JTextField T_tipo ;
    JTextField T_telaTitulo;
    static JTextField T_tela;
    JTextField T_diseloTitulo;
    static JTextField T_diselo;
    JTextField T_tallaTitulo;
    static JTextField T_talla;
    JTextField T_piezaTitulo;
    static JTextField T_pieza;
    static ButtonGroup bg; //Boton de grupo para que se seleccione solo uno radio buton
    static JTable Tablero;
    JScrollPane barraDesplazamiento;
    JButton listo;
    static JLabel validar;
    JTextArea tituloVentana;
    JRadioButton insertar;
    JRadioButton consultar;
    JRadioButton actualizar;
    JRadioButton eliminar;

    JRadioButton M;
    JRadioButton F;

    static ButtonGroup bg1;

    static String tipo;

    public prenda_vestir(String cargo){
        prenda_vestir.tipo = cargo;
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
        tituloVentana.setText("                              PRENDA                                 ");
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

        T_idTitulo = new JTextField();
        T_idTitulo.setText(" ID PRENDA *");
        T_idTitulo.setFont(new Font("arial", 3, 17));
        T_idTitulo.setEditable(false);
        T_idTitulo.setBorder(new LineBorder(Color.gray));
        T_idTitulo.setBounds(15,80,190,30);
        add(T_idTitulo);

        T_id  = new JTextField();
        T_id.setBounds(225,80,220,31);
        T_id.setBorder(new LineBorder(Color.gray));
        add(T_id );

        T_colorTitulo = new JTextField();
        T_colorTitulo.setText(" COLOR DE PRENDA ");
        T_colorTitulo.setFont(new Font("arial", 3, 15));
        T_colorTitulo.setEditable(false);
        T_colorTitulo.setBorder(new LineBorder(Color.gray));
        T_colorTitulo.setBounds(15,130,190,30);
        

        T_color = new JTextField();
        T_color.setBounds(225,130,220,31);
        T_color.setBorder(new LineBorder(Color.gray));
        

        T_tipoTitulo = new JTextField();
        T_tipoTitulo.setText(" TIPO DE PRENDA");
        T_tipoTitulo.setFont(new Font("arial", 3, 15));
        T_tipoTitulo.setBorder(new LineBorder(Color.gray));
        T_tipoTitulo.setEditable(false);
        T_tipoTitulo.setBounds(15,180,190,30);
       

        T_tipo = new JTextField();
        T_tipo.setBounds(225,180,220,31);
        T_tipo.setBorder(new LineBorder(Color.gray));
        

        T_telaTitulo = new JTextField();
        T_telaTitulo.setText(" TELA DE PRENDA ");
        T_telaTitulo.setFont(new Font("arial", 3, 15));
        T_telaTitulo.setBorder(new LineBorder(Color.gray));
        T_telaTitulo.setEditable(false);
        T_telaTitulo.setBounds(15,230,190,30);
        

        T_tela = new JTextField();
        T_tela.setBounds(225,230,220,30);
        T_tela.setBorder(new LineBorder(Color.gray));
        

        T_diseloTitulo = new JTextField();
        T_diseloTitulo.setText(" DISEÑO DE PRENDA");
        T_diseloTitulo.setFont(new Font("arial", 3, 15));
        T_diseloTitulo.setBorder(new LineBorder(Color.gray));
        T_diseloTitulo.setEditable(false);
        T_diseloTitulo.setBounds(475,80,190,30);
        

        T_diselo = new JTextField();
        T_diselo.setBounds(685,80,220,30);
        T_diselo.setBorder(new LineBorder(Color.gray));
        

        T_tallaTitulo = new JTextField();
        T_tallaTitulo.setText(" TALLA DE PRENDA");
        T_tallaTitulo.setFont(new Font("arial", 3, 15));
        T_tallaTitulo.setBorder(new LineBorder(Color.gray));
        T_tallaTitulo.setEditable(false);
        T_tallaTitulo.setBounds(475,130,190,30);
        

        T_talla = new JTextField();
        T_talla.setBounds(685,130,220,30);
        T_talla.setBorder(new LineBorder(Color.gray));
        

        T_piezaTitulo = new JTextField();
        T_piezaTitulo.setText(" PIEZA DE PRENDA ");
        T_piezaTitulo.setFont(new Font("arial", 3, 15));
        T_piezaTitulo.setBorder(new LineBorder(Color.gray));
        T_piezaTitulo.setEditable(false);
        T_piezaTitulo.setBounds(475,180,190,30);


        T_pieza = new JTextField();
        T_pieza.setBounds(685,180,220,30);
        T_pieza.setBorder(new LineBorder(Color.gray));


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

        M = new JRadioButton("Masculino");
        M.setBounds(475,230, 150, 30);
        M.setFont(new Font("arial",1,15));
        M.setContentAreaFilled(true); //Le quito el fondo
        M.setFocusPainted(false); //Que no quede seleccionada
        M.setBorder(new LineBorder(Color.gray));
        M.setBackground(Color.white);

        F = new JRadioButton("Femenino");
        F.setBounds(645,230, 150, 30);
        F.setFont(new Font("arial",1,15));
        F.setContentAreaFilled(true); //Le quito el fondo
        F.setFocusPainted(false); //Que no quede seleccionada
        F.setBorder(new LineBorder(Color.gray));
        F.setBackground(Color.white);


        bg1 = new ButtonGroup();
        bg1.add(M);
        bg1.add(F);

        if(Objects.equals(tipo, "administrador")){
            listo.setText("Listo ");
            add(T_pieza);
            add(T_piezaTitulo);
            add(T_colorTitulo);
            add( T_color); 
            add(T_tipoTitulo);
            add(T_tipo);
            add(T_telaTitulo);add(T_tipo);add(T_telaTitulo);add(T_tela);add(T_diseloTitulo);add(T_diselo);
            add(T_tallaTitulo);add(T_talla);add(T_piezaTitulo);add(T_pieza);add(F);add(M);
    
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
            T_tela.setText("");
            T_tipo.setText("");
            T_color.setText("");
            T_diselo .setText("");
            T_diselo.setText("");
            T_pieza.setText("");
            T_talla.setText("");
            bg1.clearSelection();
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
        if (T_id.getText().isEmpty()) {
            validar.setText("LLENAR EL CAMPO ID PRENDA!");
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
                   int id = Integer.parseInt(T_id.getText());
                   String color = T_color.getText();
                   String tela = T_tela.getText();
                   String talla = T_talla.getText();
                   String tipo = T_tipo.getText();
                   String diseno = T_diselo.getText();
                   String pieza = T_pieza.getText();
                   String sexo = "";
                   if(M.isSelected()){
                    sexo = "M";
                   }
                   if(F.isSelected()){
                    sexo = "F";
                   }
                   controlador control = new controlador();
                   controlador.agregarPrenda_Vestir(id, sexo, color, tela, tipo, talla, diseno, pieza, Tablero);
                   validar.setForeground(Color.black);
                   validar.setText("               DATO INSERTADO");
               } else if (actualizar.isSelected()) {
                   int id = Integer.parseInt(T_id.getText());
                   String color = T_color.getText();
                   String tela = T_tela.getText();
                   String talla = T_talla.getText();
                   String tipo = T_tipo.getText();
                   String diseno = T_diselo.getText();
                   String pieza = T_pieza.getText();
                   String sexo = "";
                   controlador control = new controlador();
                   controlador.actualizarPrenda(sexo, color, tela, tipo, talla, diseno, pieza, id, Tablero);
                   validar.setForeground(new Color(0,128,0));
                   validar.setText("                DATO ACTUALIZADO");
               } else if (consultar.isSelected()) {
                   int id = Integer.parseInt(T_id.getText());
                   controlador.consultarPrenda(id, Tablero);
                   validar.setForeground(Color.black);
                   validar.setText("                RESULTADO DE CONSULTA");
               } else if (eliminar.isSelected()) {
                   int id = Integer.parseInt(T_id.getText());
                   controlador.eliminarPrenda(id);
                   validar.setForeground(new Color(75, 0, 130));
                   vaciarCampos();
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
                    validar.setForeground(Color.black);
                   int id = Integer.parseInt(T_id.getText());
                    controlador.consultarPrenda(id, Tablero);

                    validar.setText("RESULTADO DE LA CONSULTA");
                }
                
            }
        }
    }
}
