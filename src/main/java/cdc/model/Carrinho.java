package cdc.model;

public class Carrinho {
    
    private Integer idCarrinho; 
    private Integer idProdutoCarrinho; 
    private Integer idUsuarioCarrinho; 
    private Integer idProduto;
    private String nomeProduto; 
    private float precoProduto; 
    private String descricaoProduto; 
    private String categoriaProduto; 
    private Integer quantidadeEstoqueProduto; 
    private Integer idImagemProduto; 
    private String imagem1;
    private String imagem2;
    private String imagem3;
    private Integer idProdutoImagemProduto;

    public Carrinho() {
    }

    public Carrinho(Integer idCarrinho, Integer idProdutoCarrinho, Integer idUsuarioCarrinho, Integer idProduto, String nomeProduto, float precoProduto, String descricaoProduto, String categoriaProduto, Integer quantidadeEstoqueProduto, Integer idImagemProduto, String imagem1, String imagem2, String imagem3, Integer idProdutoImagemProduto) {
        this.idCarrinho = idCarrinho;
        this.idProdutoCarrinho = idProdutoCarrinho;
        this.idUsuarioCarrinho = idUsuarioCarrinho;
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.descricaoProduto = descricaoProduto;
        this.categoriaProduto = categoriaProduto;
        this.quantidadeEstoqueProduto = quantidadeEstoqueProduto;
        this.idImagemProduto = idImagemProduto;
        this.imagem1 = imagem1;
        this.imagem2 = imagem2;
        this.imagem3 = imagem3;
        this.idProdutoImagemProduto = idProdutoImagemProduto;
    }

    public Integer getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Integer getIdProdutoCarrinho() {
        return idProdutoCarrinho;
    }

    public void setIdProdutoCarrinho(Integer idProdutoCarrinho) {
        this.idProdutoCarrinho = idProdutoCarrinho;
    }

    public Integer getIdUsuarioCarrinho() {
        return idUsuarioCarrinho;
    }

    public void setIdUsuarioCarrinho(Integer idUsuarioCarrinho) {
        this.idUsuarioCarrinho = idUsuarioCarrinho;
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

    public Integer getIdImagemProduto() {
        return idImagemProduto;
    }

    public void setIdImagemProduto(Integer idImagemProduto) {
        this.idImagemProduto = idImagemProduto;
    }

    public String getImagem1() {
        return imagem1;
    }

    public void setImagem1(String imagem1) {
        this.imagem1 = imagem1;
    }

    public String getImagem2() {
        return imagem2;
    }

    public void setImagem2(String imagem2) {
        this.imagem2 = imagem2;
    }

    public String getImagem3() {
        return imagem3;
    }

    public void setImagem3(String imagem3) {
        this.imagem3 = imagem3;
    }

    public Integer getIdProdutoImagemProduto() {
        return idProdutoImagemProduto;
    }

    public void setIdProdutoImagemProduto(Integer idProdutoImagemProduto) {
        this.idProdutoImagemProduto = idProdutoImagemProduto;
    }
    
    
}
