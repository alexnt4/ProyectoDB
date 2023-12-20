package org.example.modelo;

import java.util.Date;

public class pedido {
    private int numPedido;
    private Date fechaEncargado;
    private Double abono;
    private Date fechaEntrega;
    private String medPersona;
    private String estado;
    private int docCliente;
    private int facVenta = 0;
    private Double montoTotal;


    public pedido() {
        
    }




    public pedido(int numPedido, Date fechaEncargado, Double abono, Date fechaEntrega, String medPersona, String estado, int docCliente, int facVenta, Double montoTotal) {
        this.numPedido = numPedido;
        this.fechaEncargado = fechaEncargado;
        this.abono = abono;
        this.fechaEntrega = fechaEntrega;
        this.medPersona = medPersona;
        this.estado = estado;
        this.docCliente = docCliente;
        this.facVenta = facVenta;
        this.montoTotal = montoTotal;
    }




    public int getNumPedido() {
        return numPedido;
    }




    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }




    public Date getFechaEncargado() {
        return fechaEncargado;
    }




    public void setFechaEncargado(Date fechaEncargado) {
        this.fechaEncargado = fechaEncargado;
    }




    public Double getAbono() {
        return abono;
    }



    
    public void setAbono(Double abono) {
        this.abono = abono;
    }




    public Date getFechaEntrega() {
        return fechaEntrega;
    }




    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }




    public String getMedPersona() {
        return medPersona;
    }




    public void setMedPersona(String medPersona) {
        this.medPersona = medPersona;
    }




    public String getEstado() {
        return estado;
    }




    public void setEstado(String estado) {
        this.estado = estado;
    }

    


    public int getDocCliente() {
        return docCliente;
    }




    public void setDocCliente(int docCliente) {
        this.docCliente = docCliente;
    }




    public int getFacVenta() {
        return facVenta;
    }




    public void setFacVenta(int facVenta) {
        this.facVenta = facVenta;
    }




    public Double getMontoTotal() {
        return montoTotal;
    }




    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }





    
    
}
