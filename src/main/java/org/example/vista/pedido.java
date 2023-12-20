package org.example.vista;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.example.DAO.DAOpedido;
import org.example.controlador.controlador;

import static org.example.DAO.DAOpedido.tablapedidoid;
import static org.example.Util.Constantes.VALIDAR_CAMPOS;

public class pedido extends JPanel implements ActionListener{
    JTextField T_numTitulo;
    static JTextField T_num;
    JTextField T_montoTitulo;
    static JTextField T_monto;
    JTextField T_abonoTitulo;
    static JTextField T_abono;
    JTextField T_fecha_encargoTitulo;
    static JTextField T_fecha_encargo;
    JTextField T_fecha_entregaTitulo;
    static JTextField T_fecha_entrega;
    JTextField T_medidaTitulo;
    static JTextField T_medida;
    JTextField T_estadoTitulo;
    static JTextField T_estado;
    JTextField T_docTitulo;
    static JTextField T_doc;
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

    public pedido(){
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
        tituloVentana.setText("                                 TABLA PEDIDO                                 ");
        tituloVentana.setFocusable(false);
        tituloVentana.setFont(new Font("arial", 3, 30));
        tituloVentana.setEditable(false);
        tituloVentana.setBorder(new LineBorder(Color.gray));
        tituloVentana.setBounds(15,15,705,40);
        add(tituloVentana);

        T_numTitulo = new JTextField();
        T_numTitulo.setText(" NUMERO PEDIDO *");
        T_numTitulo.setFont(new Font("arial", 3, 17));
        T_numTitulo.setEditable(false);
        T_numTitulo.setBorder(new LineBorder(Color.gray));
        T_numTitulo.setBounds(15,80,190,30);
        add(T_numTitulo);

        T_num  = new JTextField();
        T_num.setBounds(225,80,220,31);
        T_num.setBorder(new LineBorder(Color.gray));
        add(T_num );

        T_docTitulo = new JTextField();
        T_docTitulo.setText(" DOC CLIENTE ");
        T_docTitulo.setFont(new Font("arial", 3, 15));
        T_docTitulo.setEditable(false);
        T_docTitulo.setBorder(new LineBorder(Color.gray));
        T_docTitulo.setBounds(15,130,190,30);
        add( T_docTitulo);

        T_doc = new JTextField();
        T_doc.setBounds(225,130,220,31);
        T_doc.setBorder(new LineBorder(Color.gray));
        add( T_doc);

        T_montoTitulo = new JTextField();
        T_montoTitulo.setText(" MONTO TOTAL");
        T_montoTitulo.setFont(new Font("arial", 3, 15));
        T_montoTitulo.setBorder(new LineBorder(Color.gray));
        T_montoTitulo.setEditable(false);
        T_montoTitulo.setBounds(15,180,190,30);
        add(T_montoTitulo);

        T_monto = new JTextField();
        T_monto.setBounds(225,180,220,31);
        T_monto.setBorder(new LineBorder(Color.gray));
        add(T_monto);

        T_abonoTitulo = new JTextField();
        T_abonoTitulo.setText(" ABONO");
        T_abonoTitulo.setFont(new Font("arial", 3, 15));
        T_abonoTitulo.setBorder(new LineBorder(Color.gray));
        T_abonoTitulo.setEditable(false);
        T_abonoTitulo.setBounds(15,230,190,30);
        add(T_abonoTitulo);

        T_abono = new JTextField();
        T_abono.setBounds(225,230,220,30);
        T_abono.setBorder(new LineBorder(Color.gray));
        add(T_abono);

        T_fecha_encargoTitulo = new JTextField();
        T_fecha_encargoTitulo.setText(" FECHA DE ENCARGO");
        T_fecha_encargoTitulo.setFont(new Font("arial", 3, 15));
        T_fecha_encargoTitulo.setBorder(new LineBorder(Color.gray));
        T_fecha_encargoTitulo.setEditable(false);
        T_fecha_encargoTitulo.setBounds(475,80,190,30);
        add(T_fecha_encargoTitulo);

        T_fecha_encargo = new JTextField();
        T_fecha_encargo.setBounds(685,80,220,30);
        T_fecha_encargo.setBorder(new LineBorder(Color.gray));
        add(T_fecha_encargo);

        T_fecha_entregaTitulo = new JTextField();
        T_fecha_entregaTitulo.setText(" FECHA DE ENTREGA");
        T_fecha_entregaTitulo.setFont(new Font("arial", 3, 15));
        T_fecha_entregaTitulo.setBorder(new LineBorder(Color.gray));
        T_fecha_entregaTitulo.setEditable(false);
        T_fecha_entregaTitulo.setBounds(475,130,190,30);
        add(T_fecha_entregaTitulo);

        T_fecha_entrega = new JTextField();
        T_fecha_entrega.setBounds(685,130,220,30);
        T_fecha_entrega.setBorder(new LineBorder(Color.gray));
        add(T_fecha_entrega);

        T_medidaTitulo = new JTextField();
        T_medidaTitulo.setText(" MEDIDAS ");
        T_medidaTitulo.setFont(new Font("arial", 3, 15));
        T_medidaTitulo.setBorder(new LineBorder(Color.gray));
        T_medidaTitulo.setEditable(false);
        T_medidaTitulo.setBounds(475,180,190,30);
        add(T_medidaTitulo);

        T_medida = new JTextField();
        T_medida.setBounds(685,180,220,30);
        T_medida.setBorder(new LineBorder(Color.gray));
        add(T_medida);

        T_estadoTitulo = new JTextField();
        T_estadoTitulo.setText(" ESTADO");
        T_estadoTitulo.setFont(new Font("arial", 3, 15));
        T_estadoTitulo.setBorder(new LineBorder(Color.gray));
        T_estadoTitulo.setEditable(false);
        T_estadoTitulo.setBounds(475,230,190,30);
        add(T_estadoTitulo);

        T_estado = new JTextField();
        T_estado.setBounds(685,230,220,30);
        T_estado.setBorder(new LineBorder(Color.gray));
        add(T_estado);

        listo = new JButton("Listo ");
        listo.setBounds(740,15,165,40);
        listo.addActionListener(this);
        listo.setBorder(new LineBorder(Color.gray));
        listo.setForeground(Color.BLACK); //Color de la letra
        listo.setFont(new Font("cooper black",2,25));
        listo.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        listo.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        listo.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón
       
        add(listo);

        validar = new JLabel();
        validar.setText("");
        validar.setBounds(160, 610, 660, 30);
        validar.setFont(new Font("arial",1,30));
        add(validar);

        insertar = new JRadioButton("insertar");
        insertar.setBounds(15, 280, 100, 30);
        insertar.setFont(new Font("arial",1,15));
        insertar.setContentAreaFilled(true); //Le quito el fondo
        insertar.setFocusPainted(false); //Que no quede seleccionada
        insertar.setBorder(new LineBorder(Color.gray));
        insertar.setBackground(Color.WHITE);
        add(insertar);

        consultar = new JRadioButton("consultar");
        consultar.setBounds(125, 280, 100, 30);
        consultar.setFont(new Font("arial",1,15));
        consultar.setBorderPainted(false);
        consultar.setFocusPainted(false); //Que no quede seleccionada
        consultar.setContentAreaFilled(true); //Le quito el fondo
        consultar.setBorder(new LineBorder(Color.gray));
        consultar.setBackground(Color.WHITE);
        add(consultar);

        actualizar = new JRadioButton("actualizar");
        actualizar.setBounds(245, 280, 100, 30);
        actualizar.setFont(new Font("arial",1,15));
        actualizar.setBorderPainted(false);
        actualizar.setFocusPainted(false); //Que no quede seleccionada
        actualizar.setContentAreaFilled(true); //Le quito el fondo
        actualizar.setBorder(new LineBorder(Color.gray));
        actualizar.setBackground(Color.WHITE);
        add(actualizar);

        eliminar = new JRadioButton("eliminar");
        eliminar.setBounds(365, 280, 100, 30);
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

    public void validarCampos(){
        validar.setText("");
        validar.setForeground(Color.red);
        if (T_num.getText().isEmpty()) {
            validar.setText("LLENAR EL CAMPO NUMERO DE PEDIDO!");
        } else {
            try {
                int numeroPedido = Integer.parseInt(T_num.getText());
    
                // Resto de tu lógica para validar otros campos si es necesario
                if (!eliminar.isSelected() && !actualizar.isSelected() && !consultar.isSelected() && !insertar.isSelected()) {
                    validar.setText("       ESCOJA UN CAMPO!");
                }
            } catch (NumberFormatException e) {
                validar.setText("EL CAMPO NUMERO DE PEDIDO DEBE SER UN NÚMERO ENTERO!");
            }
        }  
    }

    public static void vaciarCampos() {
        T_num.setText("");
        T_abono.setText("");
        T_monto.setText("");
        T_estado.setText("");
        T_fecha_encargo.setText("");
        T_fecha_entrega.setText("");
        T_medida.setText("");
        T_doc.setText("");
        validar.setText("");
        DefaultTableModel modeloVacio = new DefaultTableModel(); // Crea un nuevo modelo vacío
        Tablero.setModel(modeloVacio); 
        bg.clearSelection();
    }

    public void actionPerformed(ActionEvent e) {
        validar.setText(""); //Vaciar el texto
        if (e.getSource() == listo) {
            //Validar
            validarCampos();
            try {
                if (insertar.isSelected()){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    int numPedido = Integer.parseInt(T_num.getText());
                    Double abono = Double.valueOf(T_abono.getText());
                    String medPersona = T_medida.getText();
                    String estado = T_estado.getText();
                    int DocCliente = Integer.parseInt(T_doc.getText());
                    int facVenta = 0;
                    if(Objects.equals(estado, "Entregado")){
                        facVenta = DAOpedido.obtenerProximoNumeroFactura();
                    }
                    Double MontoTotal = Double.valueOf(T_monto.getText());
                    Date fechaEncargo = new Date(sdf.parse(T_fecha_encargo.getText()).getTime());
                    Date fechaEntrega = new Date(sdf.parse(T_fecha_entrega.getText()).getTime());
                    controlador control = new controlador();
                    controlador.agregarPedido(numPedido, fechaEncargo, abono, fechaEntrega, medPersona, estado, DocCliente, facVenta, MontoTotal, Tablero);
                    validar.setForeground(Color.black);
                    validar.setText("               DATO INSERTADO");
                } else if (actualizar.isSelected()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    int numPedido = Integer.parseInt(T_num.getText());
                    Double abono = T_abono.getText().isEmpty() ? 0.0 : Double.valueOf(T_abono.getText());
                    String medPersona = T_medida.getText();
                    String estado = T_estado.getText();
                    int DocCliente = T_doc.getText().isEmpty() ? 0 : Integer.parseInt(T_doc.getText());
                    int facVenta = DAOpedido.obtenerPedidoPorNumero(numPedido).getFacVenta();
                    System.out.println(facVenta);
                    Double MontoTotal = T_monto.getText().isEmpty() ? 0.0 : Double.valueOf(T_monto.getText());
                    Date fechaEncargo = null;
                    Date fechaEntrega = null;

                    try {
                        if (!T_fecha_encargo.getText().isEmpty()) {
                            fechaEncargo = new Date(sdf.parse(T_fecha_encargo.getText()).getTime());
                        }
                        if (!T_fecha_entrega.getText().isEmpty()) {
                            fechaEntrega = new Date(sdf.parse(T_fecha_entrega.getText()).getTime());
                        }
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }

                    controlador control = new controlador();
                    controlador.actualizarPedido(numPedido, fechaEncargo, abono, fechaEntrega, medPersona, estado, DocCliente, facVenta, MontoTotal, Tablero);
                    validar.setForeground(new Color(0,128,0));
                    validar.setText("                DATO ACTUALIZADO");
                } else if (consultar.isSelected()) {
                    int numPedido = Integer.parseInt(T_num.getText());
                    controlador.consultarPedido(numPedido, Tablero);
                    System.out.println("consultar");
                    //controlador.consultarPedido(numPedido);
                    validar.setForeground(Color.black);
                    validar.setText("                RESULTADO DE CONSULTA");
                } else if (eliminar.isSelected()) {
                    int numPedido = Integer.parseInt(T_num.getText());
                    controlador.eliminarPedido(numPedido);
                    validar.setForeground(new Color(75, 0, 130));
                    validar.setText("               ELIMINADO");
                } else {
                    //validar.setForeground(Color.red);
                    //validar.setText("ECOJA UNA OPCION");
                }

            } catch (ParseException f) {
                f.printStackTrace();
            }

        }
    }
}

