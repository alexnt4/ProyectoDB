package org.example.modelo;

public class telColegio {
    private int idColegio;
    private int telefonoColegio;

    public telColegio() {

    }

    public telColegio(int idColegio, int telefonoColegio) {
        this.idColegio = idColegio;
        this.telefonoColegio = telefonoColegio;
    }

    public int getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(int idColegio) {
        this.idColegio = idColegio;
    }


    public int getTelefonoColegio() {
        return telefonoColegio;
    }

    public void setTelefonoColegio(int telefonoColegio) {
        this.telefonoColegio = telefonoColegio;
    }

    
}
