package org.example.modelo;

public class inventarioMateriales {
    private int codMaterial;
    private int cantidad;
    private String tipo;
    private String desMaterial;
    private String uniMedida;


    public inventarioMateriales() {

    }




    public inventarioMateriales(int codMaterial, int cantidad, String tipo, String desMaterial, String uniMedida) {
        this.codMaterial = codMaterial;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.desMaterial = desMaterial;
        this.uniMedida = uniMedida;
    }




    public int getCodMaterial() {
        return codMaterial;
    }


    public void setCodMaterial(int codMaterial) {
        this.codMaterial = codMaterial;
    }




    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }




    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }




    public String getDesMaterial() {
        return desMaterial;
    }


    public void setDesMaterial(String desMaterial) {
        this.desMaterial = desMaterial;
    }




    public String getUniMedida() {
        return uniMedida;
    }


    public void setUniMedida(String uniMedida) {
        this.uniMedida = uniMedida;
    }




    
    
}
