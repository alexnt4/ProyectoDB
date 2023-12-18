package org.example.modelo;

public class uniforme {
    private int idPrenda;
    private String caracEspecial;
    private int idColegio;


    public uniforme() {

    }



    public uniforme(int idPrenda, String caracEspecial, int idColegio) {
        this.idPrenda = idPrenda;
        this.caracEspecial = caracEspecial;
        this.idColegio = idColegio;
    }




    public int getIdPrenda() {
        return idPrenda;
    }

    public void setIdPrenda(int idPrenda) {
        this.idPrenda = idPrenda;
    }



    public String getCaracEspecial() {
        return caracEspecial;
    }

    public void setCaracEspecial(String caracEspecial) {
        this.caracEspecial = caracEspecial;
    }



    public int getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(int idColegio) {
        this.idColegio = idColegio;
    }



    
}
