package cdc.model;

import java.sql.Date;

public class Promocao {
    private int idPromocao;
    private String nomePromocao;
    private Date dataComecoPromocao;
    private Date dataFimPromocao;
    private float descontoPromocao;
    private String statusPromocao;

    public Promocao() {
    }

    public Promocao(String nomePromocao, Date dataComecoPromocao, Date dataFimPromocao, float descontoPromocao, String statusPromocao) {
        this.nomePromocao = nomePromocao;
        this.dataComecoPromocao = dataComecoPromocao;
        this.dataFimPromocao = dataFimPromocao;
        this.descontoPromocao = descontoPromocao;
        this.statusPromocao = statusPromocao;
    }
    
    public Promocao(int idPromocao, String nomePromocao, Date dataComecoPromocao, Date dataFimPromocao, float descontoPromocao, String statusPromocao) {
        this.idPromocao = idPromocao;
        this.nomePromocao = nomePromocao;
        this.dataComecoPromocao = dataComecoPromocao;
        this.dataFimPromocao = dataFimPromocao;
        this.descontoPromocao = descontoPromocao;
        this.statusPromocao = statusPromocao;
    }

    public int getIdPromocao() {
        return idPromocao;
    }

    public void setIdPromocao(int idPromocao) {
        this.idPromocao = idPromocao;
    }

    public String getNomePromocao() {
        return nomePromocao;
    }

    public void setNomePromocao(String nomePromocao) {
        this.nomePromocao = nomePromocao;
    }

    public Date getDataComecoPromocao() {
        return dataComecoPromocao;
    }

    public void setDataComecoPromocao(Date dataComecoPromocao) {
        this.dataComecoPromocao = dataComecoPromocao;
    }

    public Date getDataFimPromocao() {
        return dataFimPromocao;
    }

    public void setDataFimPromocao(Date dataFimPromocao) {
        this.dataFimPromocao = dataFimPromocao;
    }

    public float getDescontoPromocao() {
        return descontoPromocao;
    }

    public void setDescontoPromocao(float descontoPromocao) {
        this.descontoPromocao = descontoPromocao;
    }

    public String getStatusPromocao() {
        return statusPromocao;
    }

    public void setStatusPromocao(String statusPromocao) {
        this.statusPromocao = statusPromocao;
    }
    
    
}
