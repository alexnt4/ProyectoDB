package org.example.modelo;

public class prodTerminado {

    private int codProdTerm;
    private int idPrenda;
    private int codMaterial;
    private String descripcion;
    private Double precio;
    private String encargado;
    private int canTerminados;


    public prodTerminado() {

    }



    public prodTerminado(int codProdTerm, int idPrenda, int codMaterial, String descripcion, Double precio, String encargado, int canTerminados) {
        this.codProdTerm = codProdTerm;
        this.idPrenda = idPrenda;
        this.codMaterial = codMaterial;
        this.descripcion = descripcion;
        this.precio = precio;
        this.encargado = encargado;
        this.canTerminados = canTerminados;
    }




    public int getCodProdTerm() {
        return codProdTerm;
    }

    public void setCodProdTerm(int codProdTerm) {
        this.codProdTerm = codProdTerm;
    }


    public int getIdPrenda() {
        return idPrenda;
    }


    public void setIdPrenda(int idPrenda) {
        this.idPrenda = idPrenda;
    }




    public int getCodMaterial() {
        return codMaterial;
    }


    public void setCodMaterial(int codMaterial) {
        this.codMaterial = codMaterial;
    }




    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




    public Double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio =  precio;
    }




    public String getEncargado() {
        return encargado;
    }


    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }




    public int getCanTerminados() {
        return canTerminados;
    }


    public void setCanTerminados(int canTerminados) {
        this.canTerminados = canTerminados;
    }



    
    
}
