package cdc.model;


class ImagemProduto {
    
    private Integer idImagemProduto;
    private String imagem1;
    private String imagem2;
    private String imagem3;
    private Integer idProdutoImagemProduto; 

    public ImagemProduto() {
    }

    public ImagemProduto(Integer idImagemProduto, String imagem1, String imagem2, String imagem3, Integer idProdutoImagemProduto) {
        this.idImagemProduto = idImagemProduto;
        this.imagem1 = imagem1;
        this.imagem2 = imagem2;
        this.imagem3 = imagem3;
        this.idProdutoImagemProduto = idProdutoImagemProduto;
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
