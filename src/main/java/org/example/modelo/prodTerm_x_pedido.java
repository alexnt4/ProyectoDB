package org.example.modelo;

public class prodTerm_x_pedido {

    private int numPedido;
    private int codProdTerm;

    public prodTerm_x_pedido() {

    }

    public prodTerm_x_pedido(int numPedido, int codProdTerm) {
        this.numPedido = numPedido;
        this.codProdTerm = codProdTerm;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }


    public int getCodProdTerm() {
        return codProdTerm;
    }


    public void setCodProdTerm(int codProdTerm) {
        this.codProdTerm = codProdTerm;
    }

}