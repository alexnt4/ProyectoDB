package org.example.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class informe extends JPanel implements ActionListener{
    static JTable Tablero;
    static JTextField T_colegioId;
    JScrollPane barraDesplazamiento;
    JButton listo;
    static JComboBox<String> informes;
    JTextArea tituloVentana;
    static String tipo;

    public informe(){
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
        tituloVentana.setText("                            INFORMES                                 ");
        tituloVentana.setFocusable(false);
        tituloVentana.setFont(new Font("arial", 3, 33));
        tituloVentana.setEditable(false);
        tituloVentana.setBorder(new LineBorder(Color.gray));
        tituloVentana.setBounds(15,15,705,40);
        add(tituloVentana);

        T_colegioId = new JTextField();
        T_colegioId.setBounds(685,65,220,50);
        T_colegioId.setBorder(new LineBorder(Color.gray));
        T_colegioId.setEditable(false);
        add(T_colegioId);

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

        Tablero = new JTable();
        Tablero.setFont(new Font("arial", 2, 15));
        Tablero.setEnabled(false);
        barraDesplazamiento = new JScrollPane(Tablero);
        barraDesplazamiento.setBounds(15,135,890,455);
        barraDesplazamiento.setBorder(new LineBorder(Color.gray));
        add(barraDesplazamiento);

        informes = new JComboBox<>();
        informes.addActionListener(this);
        informes.addItem("Seleccione Informe"); //0
        informes.addItem("Listado de productos encargados pendientes por entregar"); //1
        informes.addItem("Por cada cliente, listar los productos encargados que no han sido entregados"); //2
        informes.addItem("Por cada producto, cantidad en existencia descontando los que están encargados"); //3
        informes.addItem("Listado de colegios de los que se fabrican uniformes"); //4
        informes.addItem("Dado un colegio las características de su uniforme"); //5
        informes.addItem("Calcular el total de productos vendidos por colegio"); //6
        informes.addItem("Calcular el total de ventas"); //7
        informes.setBounds(15,65,620,50);
        informes.setFont(new Font("arial", 1, 15));
        informes.setBackground(Color.white);
        add(informes);
    }

    public static void vaciarCampos() {
        DefaultTableModel modeloVacio = new DefaultTableModel(); // Crea un nuevo modelo vacío
        Tablero.setModel(modeloVacio); 
        informes.setSelectedIndex(0);
        T_colegioId.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == listo){
            if(informes.getSelectedIndex() == 1){
                //Se muestra -> Listado de productos encargados pendientes por entregar
            }else if(informes.getSelectedIndex() == 2){
                //Se muestra -> Por cada cliente, listar los productos encargados que no han sido entregados
            }else if(informes.getSelectedIndex() == 3){
                //Se muestra -> Por cada producto, cantidad en existencia descontando los que están encargados
            }else if(informes.getSelectedIndex() == 4){
                //Se muestra -> Listado de colegios de los que se fabrican uniformes
            }else if(informes.getSelectedIndex() == 5){
                //Se muestra -> Dado un colegio las características de su uniforme
            }else if(informes.getSelectedIndex() == 6){
                //Se muestra -> Calcular el total de productos vendidos por colegio
            }else if(informes.getSelectedIndex() == 7){
                //Se muestra -> Calcular el total de ventas
            }
        }
        if(e.getSource() == informes){
            if(informes.getSelectedIndex() == 5){
                T_colegioId.setEditable(true);
            }
            else{
                T_colegioId.setEditable(false);
            }
        }
    }
           
}
