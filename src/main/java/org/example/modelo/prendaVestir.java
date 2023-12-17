package org.example.modelo;

public class prendaVestir {

    private int idPrendaVestir;
    private String sexo;
    private String color;
    private String tela;
    private String tipo;
    private String talla;
    private String diseno;
    private String pieza;


    public prendaVestir() {

    }



    public prendaVestir(int idPrendaVestir, String sexo, String color, String tela, String tipo, String talla, String diseno, String pieza) {
        this.idPrendaVestir = idPrendaVestir;
        this.sexo = sexo;
        this.color = color;
        this.tela = tela;
        this.tipo = tipo;
        this.talla = talla;
        this.diseno = diseno;
        this.pieza = pieza;
    }




    public int getIdPrendaVestir() {
        return idPrendaVestir;
    }

    public void setIdPrendaVestir(int idPrendaVestir) {
        this.idPrendaVestir = idPrendaVestir;
    }



    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }




    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }




    public String getTela() {
        return tela;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }




    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }




    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }




    public String getDiseno() {
        return diseno;
    }

    public void setDiseno(String diseno) {
        this.diseno = diseno;
    }




    public String getPieza() {
        return pieza;
    }

    public void setPieza(String pieza) {
        this.pieza = pieza;
    }




    
}
