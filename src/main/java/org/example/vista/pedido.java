package org.example.vista;

import org.example.DAO.DAOpedido;
import org.example.controlador.controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class pedido extends JPanel implements ActionListener {
    JTextField T_numTitulo;
    static JTextField T_num;
    JTextField T_facturaTitulo;
    static JTextField T_factura;
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
    static ButtonGroup bg; //Boton de grupo para que se seleccione solo uno radio buton
    static JTextArea Tablero;
    JScrollPane barraDesplazamiento;
    JButton listo;
    JTextArea tituloVentana;
    JRadioButton insertar;
    JRadioButton consultar;
    JRadioButton actualizar;
    JRadioButton eliminar;

    public pedido() {
        Gui(); //Funcion que genera la vista
        vaciarCampos();
    }

    public void Gui() {
        setLayout(null);
        setBounds(350, 5, 920, 650);
        setBackground(new Color(0, 191, 255));
        //setBackground(new Color(220, 220, 220)); //Activelo cuando quiera ver el panel
        setVisible(false);
//735
        tituloVentana = new JTextArea();
        tituloVentana.setText("                                 TABLA PEDIDO                                 ");
        tituloVentana.setFocusable(false);
        tituloVentana.setFont(new Font("arial", 3, 30));
        tituloVentana.setEditable(false);
        tituloVentana.setBorder(new LineBorder(Color.gray));
        tituloVentana.setBounds(30, 15, 705, 40);
        add(tituloVentana);

        T_numTitulo = new JTextField();
        T_numTitulo.setText(" NUMERO PEDIDO");
        T_numTitulo.setFont(new Font("arial", 3, 17));
        T_numTitulo.setEditable(false);
        T_numTitulo.setBorder(new LineBorder(Color.gray));
        T_numTitulo.setBounds(30, 80, 190, 30);
        add(T_numTitulo);

        T_num = new JTextField();
        T_num.setBounds(240, 80, 220, 31);
        T_num.setBorder(new LineBorder(Color.gray));
        add(T_num);

        T_facturaTitulo = new JTextField();
        T_facturaTitulo.setText(" FACTURA ");
        T_facturaTitulo.setFont(new Font("arial", 3, 15));
        T_facturaTitulo.setEditable(false);
        T_facturaTitulo.setBorder(new LineBorder(Color.gray));
        T_facturaTitulo.setBounds(30, 130, 190, 30);
        add(T_facturaTitulo);

        T_factura = new JTextField();
        T_factura.setBounds(240, 130, 220, 31);
        T_factura.setBorder(new LineBorder(Color.gray));
        add(T_factura);

        T_montoTitulo = new JTextField();
        T_montoTitulo.setText(" MONTO TOTAL");
        T_montoTitulo.setFont(new Font("arial", 3, 15));
        T_montoTitulo.setBorder(new LineBorder(Color.gray));
        T_montoTitulo.setEditable(false);
        T_montoTitulo.setBounds(30, 180, 190, 30);
        add(T_montoTitulo);

        T_monto = new JTextField();
        T_monto.setBounds(240, 180, 220, 31);
        T_monto.setBorder(new LineBorder(Color.gray));
        add(T_monto);

        T_abonoTitulo = new JTextField();
        T_abonoTitulo.setText(" ABONO");
        T_abonoTitulo.setFont(new Font("arial", 3, 15));
        T_abonoTitulo.setBorder(new LineBorder(Color.gray));
        T_abonoTitulo.setEditable(false);
        T_abonoTitulo.setBounds(30, 230, 190, 30);
        add(T_abonoTitulo);

        T_abono = new JTextField();
        T_abono.setBounds(240, 230, 220, 30);
        T_abono.setBorder(new LineBorder(Color.gray));
        add(T_abono);

        T_fecha_encargoTitulo = new JTextField();
        T_fecha_encargoTitulo.setText(" FECHA DE ENCARGO");
        T_fecha_encargoTitulo.setFont(new Font("arial", 3, 15));
        T_fecha_encargoTitulo.setBorder(new LineBorder(Color.gray));
        T_fecha_encargoTitulo.setEditable(false);
        T_fecha_encargoTitulo.setBounds(490, 80, 190, 30);
        add(T_fecha_encargoTitulo);

        T_fecha_encargo = new JTextField();
        T_fecha_encargo.setBounds(700, 80, 220, 30);
        T_fecha_encargo.setBorder(new LineBorder(Color.gray));
        add(T_fecha_encargo);

        T_fecha_entregaTitulo = new JTextField();
        T_fecha_entregaTitulo.setText(" FECHA DE ENTREGA");
        T_fecha_entregaTitulo.setFont(new Font("arial", 3, 15));
        T_fecha_entregaTitulo.setBorder(new LineBorder(Color.gray));
        T_fecha_entregaTitulo.setEditable(false);
        T_fecha_entregaTitulo.setBounds(490, 130, 190, 30);
        add(T_fecha_entregaTitulo);

        T_fecha_entrega = new JTextField();
        T_fecha_entrega.setBounds(700, 130, 220, 30);
        T_fecha_entrega.setBorder(new LineBorder(Color.gray));
        add(T_fecha_entrega);

        T_medidaTitulo = new JTextField();
        T_medidaTitulo.setText(" MEDIDAS ");
        T_medidaTitulo.setFont(new Font("arial", 3, 15));
        T_medidaTitulo.setBorder(new LineBorder(Color.gray));
        T_medidaTitulo.setEditable(false);
        T_medidaTitulo.setBounds(490, 180, 190, 30);
        add(T_medidaTitulo);

        T_medida = new JTextField();
        T_medida.setBounds(700, 180, 220, 30);
        T_medida.setBorder(new LineBorder(Color.gray));
        add(T_medida);

        T_estadoTitulo = new JTextField();
        T_estadoTitulo.setText(" ESTADO");
        T_estadoTitulo.setFont(new Font("arial", 3, 15));
        T_estadoTitulo.setBorder(new LineBorder(Color.gray));
        T_estadoTitulo.setEditable(false);
        T_estadoTitulo.setBounds(490, 230, 190, 30);
        add(T_estadoTitulo);

        T_estado = new JTextField();
        T_estado.setBounds(700, 230, 220, 30);
        T_estado.setBorder(new LineBorder(Color.gray));
        add(T_estado);

        listo = new JButton("Listo ");
        listo.setBounds(755, 15, 165, 40);
        listo.addActionListener(this);
        listo.setBorder(new LineBorder(Color.gray));
        listo.setForeground(Color.BLACK); //Color de la letra
        listo.setFont(new Font("cooper black", 2, 25));
        listo.setBorderPainted(true); //Establece si el borde del botón debe ser dibujado o no.
        listo.setContentAreaFilled(true); //Establece si el área de contenido del botón debe ser dibujada o no.
        listo.setFocusPainted(false); //desactivar el efecto de resaltado del texto cuando se hace clic en el botón

        add(listo);

        insertar = new JRadioButton("Insertar");
        insertar.setBounds(30, 280, 115, 30);
        insertar.setFont(new Font("arial", 1, 15));
        insertar.setContentAreaFilled(true); //Le quito el fondo
        insertar.setFocusPainted(false); //Que no quede seleccionada
        insertar.setBorder(new LineBorder(Color.gray));
        add(insertar);

        consultar = new JRadioButton("consultar");
        consultar.setBounds(160, 280, 115, 30);
        consultar.setFont(new Font("arial", 1, 15));
        consultar.setBorderPainted(false);
        consultar.setFocusPainted(false); //Que no quede seleccionada
        consultar.setContentAreaFilled(true); //Le quito el fondo
        consultar.setBorder(new LineBorder(Color.gray));
        add(consultar);

        actualizar = new JRadioButton("actualizar");
        actualizar.setBounds(285, 280, 115, 30);
        actualizar.setFont(new Font("arial", 1, 15));
        actualizar.setBorderPainted(false);
        actualizar.setFocusPainted(false); //Que no quede seleccionada
        actualizar.setContentAreaFilled(true); //Le quito el fondo
        actualizar.setBorder(new LineBorder(Color.gray));
        add(actualizar);

        eliminar = new JRadioButton("eliminar");
        eliminar.setBounds(415, 280, 115, 30);
        eliminar.setFont(new Font("arial", 1, 15));
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
        barraDesplazamiento.setBounds(30, 380, 890, 250);
        barraDesplazamiento.setBorder(new LineBorder(Color.gray));
        add(barraDesplazamiento);
    }

    public static void vaciarCampos() {
        T_num.setText("");
        T_abono.setText("");
        T_monto.setText("");
        T_factura.setText("");
        T_estado.setText("");
        Tablero.setText("");
        bg.clearSelection();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listo) {
            try {
                if (insertar.isSelected()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    int numPedido = Integer.parseInt(T_num.getText());
                    Double abono = Double.valueOf(T_abono.getText());
                    String medPersona = T_medida.getText();
                    String estado = T_estado.getText();
                    int DocCliente = 10001;
                    int facVenta = Integer.parseInt(T_factura.getText());
                    Double MontoTotal = Double.valueOf(T_monto.getText());
                    Date fechaEncargo = new Date(sdf.parse(T_fecha_encargo.getText()).getTime());
                    Date fechaEntrega = new Date(sdf.parse(T_fecha_entrega.getText()).getTime());
                    controlador control = new controlador();
                    controlador.agregarPedido(numPedido, fechaEncargo, abono, fechaEntrega, medPersona, estado, DocCliente, facVenta, MontoTotal);
                    System.out.println("insertar");
                    Tablero.setText("Usuario agregado");
                } else if (actualizar.isSelected()) {
                    System.out.println("actualizar");
                } else if (consultar.isSelected()) {
                    System.out.println("consultar");
                } else if (eliminar.isSelected()) {
                    System.out.println("eliminar");
                } else {
                    System.out.println("Escoja una opción.");
                }

            } catch (ParseException f) {
                f.printStackTrace();
            }
        }
    }
}

