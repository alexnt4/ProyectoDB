package org.example.modelo;

public class telColegio {
    private int idColegio;
    private String telefonoColegio;

    public telColegio() {

    }

    public telColegio(int idColegio, String telefonoColegio) {
        this.idColegio = idColegio;
        this.telefonoColegio = telefonoColegio;
    }

    public int getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(int idColegio) {
        this.idColegio = idColegio;
    }


    public String getTelefonoColegio() {
        return telefonoColegio;
    }

    public void setTelefonoColegio(String telefonoColegio) {
        this.telefonoColegio = telefonoColegio;
    }

    
}
