package org.example.modelo;

public class telCliente {
    private int idCliente;
    private String telefonoCliente;

    public telCliente() {

    }

    public telCliente(int idCliente, String telefonoCliente) {
        this.idCliente = idCliente;
        this.telefonoCliente = telefonoCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }


    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    
}
