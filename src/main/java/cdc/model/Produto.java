package cdc.model;

public class Produto {
    
    private Integer idProduto; 
    private String nomeProduto; 
    private float precoProduto; 
    private String descricaoProduto; 
    private String categoriaProduto; 
    private Integer quantidadeEstoqueProduto; 

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }
    
    public Produto(String nomeProduto, float precoProduto, String descricaoProduto, String categoriaProduto, Integer quantidadeEstoqueProduto) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.descricaoProduto = descricaoProduto;
        this.categoriaProduto = categoriaProduto;
        this.quantidadeEstoqueProduto = quantidadeEstoqueProduto;
    }

    public Produto(Integer idProduto, String nomeProduto, float precoProduto, String descricaoProduto, String categoriaProduto, Integer quantidadeEstoqueProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.descricaoProduto = descricaoProduto;
        this.categoriaProduto = categoriaProduto;
        this.quantidadeEstoqueProduto = quantidadeEstoqueProduto;
    }
    

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(float precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public Integer getQuantidadeEstoqueProduto() {
        return quantidadeEstoqueProduto;
    }

    public void setQuantidadeEstoqueProduto(Integer quantidadeEstoqueProduto) {
        this.quantidadeEstoqueProduto = quantidadeEstoqueProduto;
    }
    
    
}
