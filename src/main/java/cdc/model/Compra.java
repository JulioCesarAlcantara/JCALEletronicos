package cdc.model;

public class Compra {
    private Integer idCompra; 
    private float valor; 
    private float frete; 
    private Integer idUsuarioCompra;

    public Compra() {
    }

    public Compra(Integer idCompra, float valor, float frete, Integer idUsuarioCompra) {
        this.idCompra = idCompra;
        this.valor = valor;
        this.frete = frete;
        this.idUsuarioCompra = idUsuarioCompra;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getFrete() {
        return frete;
    }

    public void setFrete(float frete) {
        this.frete = frete;
    }

    public Integer getIdUsuarioCompra() {
        return idUsuarioCompra;
    }

    public void setIdUsuarioCompra(Integer idUsuarioCompra) {
        this.idUsuarioCompra = idUsuarioCompra;
    }    
     
}
