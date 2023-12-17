package org.example.modelo;

public class pedido {
    private int numPedido;
    private int fechaEncargado;
    private String abono;
    private int fechaEntrega;
    private String medPersona;
    private String estado;
    private String docCliente;
    private String facVenta;
    private String montoTotal;


    public pedido() {

    }




    public pedido(int numPedido, int fechaEncargado, String abono, int fechaEntrega, String medPersona, String estado, String docCliente, String facVenta, String montoTotal) {
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




    public int getFechaEncargado() {
        return fechaEncargado;
    }




    public void setFechaEncargado(int fechaEncargado) {
        this.fechaEncargado = fechaEncargado;
    }




    public String getAbono() {
        return abono;
    }



    
    public void setAbono(String abono) {
        this.abono = abono;
    }




    public int getFechaEntrega() {
        return fechaEntrega;
    }




    public void setFechaEntrega(int fechaEntrega) {
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

    


    public String getDocCliente() {
        return docCliente;
    }




    public void setDocCliente(String docCliente) {
        this.docCliente = docCliente;
    }




    public String getFacVenta() {
        return facVenta;
    }




    public void setFacVenta(String facVenta) {
        this.facVenta = facVenta;
    }




    public String getMontoTotal() {
        return montoTotal;
    }




    public void setMontoTotal(String montoTotal) {
        this.montoTotal = montoTotal;
    }





    
    
}
