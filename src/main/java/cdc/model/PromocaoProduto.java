package cdc.model;

/**
 *
 * @author cesar
 */
public class PromocaoProduto {
    
    private Integer idPromocaoProduto; 
    private Integer idProdutoPromocaoProduto; 
    private Integer idPromocaoPromocaoProduto; 
    
    private Integer idPromocao; 
    private String nomePromocao; 
    private Integer idProduto;
    private String nomeProduto; 
    
    

    public PromocaoProduto() {
    }

    public PromocaoProduto(Integer idPromocaoProduto) {
        this.idPromocaoProduto = idPromocaoProduto;
    }
    
    public PromocaoProduto(Integer idPromocaoProduto, Integer idPromocao, String nomePromocao, Integer idProduto, String nomeProduto) {
        this.idPromocaoProduto = idPromocaoProduto;
        this.idPromocao = idPromocao;
        this.nomePromocao = nomePromocao;
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
    }

    public PromocaoProduto(Integer idProdutoPromocaoProduto, Integer idPromocaoPromocaoProduto) {
        this.idProdutoPromocaoProduto = idProdutoPromocaoProduto;
        this.idPromocaoPromocaoProduto = idPromocaoPromocaoProduto;
    } 
    
    public PromocaoProduto(Integer idPromocaoProduto, Integer idProdutoPromocaoProduto, Integer idPromocaoPromocaoProduto) {
        this.idPromocaoProduto = idPromocaoProduto;
        this.idProdutoPromocaoProduto = idProdutoPromocaoProduto;
        this.idPromocaoPromocaoProduto = idPromocaoPromocaoProduto;
    }

    public Integer getIdPromocao() {
        return idPromocao;
    }

    public void setIdPromocao(Integer idPromocao) {
        this.idPromocao = idPromocao;
    }

    public String getNomePromocao() {
        return nomePromocao;
    }

    public void setNomePromocao(String nomePromocao) {
        this.nomePromocao = nomePromocao;
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
