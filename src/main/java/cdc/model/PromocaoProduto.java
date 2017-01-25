package cdc.model;

/**
 *
 * @author cesar
 */
public class PromocaoProduto {
    
    private Integer idPromocaoProduto; 
    private Integer idProdutoPromocaoProduto; 
    private Integer idPromocaoPromocaoProduto; 

    public PromocaoProduto() {
    }

    public PromocaoProduto(Integer idPromocaoProduto, Integer idProdutoPromocaoProduto, Integer idPromocaoPromocaoProduto) {
        this.idPromocaoProduto = idPromocaoProduto;
        this.idProdutoPromocaoProduto = idProdutoPromocaoProduto;
        this.idPromocaoPromocaoProduto = idPromocaoPromocaoProduto;
    }

    public Integer getIdPromocaoProduto() {
        return idPromocaoProduto;
    }

    public void setIdPromocaoProduto(Integer idPromocaoProduto) {
        this.idPromocaoProduto = idPromocaoProduto;
    }

    public Integer getIdProdutoPromocaoProduto() {
        return idProdutoPromocaoProduto;
    }

    public void setIdProdutoPromocaoProduto(Integer idProdutoPromocaoProduto) {
        this.idProdutoPromocaoProduto = idProdutoPromocaoProduto;
    }

    public Integer getIdPromocaoPromocaoProduto() {
        return idPromocaoPromocaoProduto;
    }

    public void setIdPromocaoPromocaoProduto(Integer idPromocaoPromocaoProduto) {
        this.idPromocaoPromocaoProduto = idPromocaoPromocaoProduto;
    }
    
    
    
}
