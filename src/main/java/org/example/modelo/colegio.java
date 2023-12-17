package org.example.modelo;

public class colegio {

    private int idColegio;
    private String nombreColegio;
    private String direccionColegio;
    private String contacto;

    public colegio() {

    }

    public colegio(int idColegio, String nombreColegio, String direccionColegio, String contacto) {
        this.idColegio = idColegio;
        this.nombreColegio = nombreColegio;
        this.direccionColegio = direccionColegio;
        this.contacto = contacto;
    }

    public int getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(int idColegio) {
        this.idColegio = idColegio;
    }


    public String getNombreColegio() {
        return nombreColegio;
    }

    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }


    public String getDireccionColegio() {
        return direccionColegio;
    }

    public void setDireccionColegio(String direccionColegio) {
        this.direccionColegio = direccionColegio;
    }


    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
}
