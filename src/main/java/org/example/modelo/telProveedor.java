package org.example.modelo;

public class telProveedor {
    private int idProveedor;
    private String telefonoProveedor;

    public telProveedor() {

    }

    public telProveedor(int idProveedor, String telefonoProveedor) {
        this.idProveedor = idProveedor;
        this.telefonoProveedor = telefonoProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor= idProveedor;
    }



    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }


    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    
}
