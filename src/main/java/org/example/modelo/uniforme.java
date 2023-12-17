package org.example.modelo;

public class uniforme {
    private String idPrenda;
    private String caracEspecial;
    private String idColegio;


    public uniforme() {

    }



    public uniforme(String idPrenda, String caracEspecial, String idColegio) {
        this.idPrenda = idPrenda;
        this.caracEspecial = caracEspecial;
        this.idColegio = idColegio;
    }




    public String getIdPrenda() {
        return idPrenda;
    }

    public void setIdPrenda(String idPrenda) {
        this.idPrenda = idPrenda;
    }



    public String getCaracEspecial() {
        return caracEspecial;
    }

    public void setCaracEspecial(String caracEspecial) {
        this.caracEspecial = caracEspecial;
    }



    public String getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(String idColegio) {
        this.idColegio = idColegio;
    }



    
}
