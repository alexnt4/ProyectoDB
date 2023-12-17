package org.example.modelo;

public class proveedor {
    private int nitProveedor;
    private String nombreProveedor;
    private String direccionProveedor;
    private String contacto;
    private String producto;
    private int codMaterial;

    public proveedor() {

    } 

    public proveedor(int nitProveedor, String nombreProveedor, String direccionProveedor, String contacto, String producto, int codMaterial) {
        this.nitProveedor = nitProveedor;
        this.nombreProveedor = nombreProveedor;
        this.direccionProveedor = direccionProveedor;
        this.contacto = contacto;
        this.producto = producto;
        this.codMaterial = codMaterial;
    }

    public int getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(int nitProveedor) {
        this.nitProveedor = nitProveedor;
    }


    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor= nombreProveedor;
    }


    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor= direccionProveedor;
    }


    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto= contacto;
    }


    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto= producto;
    }


    public int getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(int codMaterial) {
        this.codMaterial= codMaterial;
    }


    
}
