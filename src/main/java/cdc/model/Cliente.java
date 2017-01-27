package cdc.model;

import java.sql.Date;

/**
 *
 * @author cesar
 */
public class Cliente {

    private Integer idCliente;
    private String primeiroNomeCliente;
    private String segundoNomeCliente;
    private String emailCliente;
    private String telefoneCliente;
    private Date dataNascimentoCliente;
    private String sexoCliente;
    private String tipoCliente;
    private String senhaCliente;
    private String cpfCliente;
    private String enderecoCliente;
    private String cepCliente;
    private String cidadeCliente;
    private String estadoCliente;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String primeiroNomeCliente, String segundoNomeCliente, String emailCliente, String telefoneCliente, Date dataNascimentoCliente, String sexoCliente, String tipoCliente, String senhaCliente, String cpfCliente, String enderecoCliente, String cepCliente, String cidadeCliente, String estadoCliente) {
        this.idCliente = idCliente;
        this.primeiroNomeCliente = primeiroNomeCliente;
        this.segundoNomeCliente = segundoNomeCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
        this.dataNascimentoCliente = dataNascimentoCliente;
        this.sexoCliente = sexoCliente;
        this.tipoCliente = tipoCliente;
        this.senhaCliente = senhaCliente;
        this.cpfCliente = cpfCliente;
        this.enderecoCliente = enderecoCliente;
        this.cepCliente = cepCliente;
        this.cidadeCliente = cidadeCliente;
        this.estadoCliente = estadoCliente;
    }

    public Cliente(String primeiroNomeCliente, String segundoNomeCliente, String emailCliente, String telefoneCliente, Date dataNascimentoCliente, String sexoCliente, String tipoCliente, String senhaCliente, String cpfCliente, String enderecoCliente, String cepCliente, String cidadeCliente, String estadoCliente) {
        this.primeiroNomeCliente = primeiroNomeCliente;
        this.segundoNomeCliente = segundoNomeCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
        this.dataNascimentoCliente = dataNascimentoCliente;
        this.sexoCliente = sexoCliente;
        this.tipoCliente = tipoCliente;
        this.senhaCliente = senhaCliente;
        this.cpfCliente = cpfCliente;
        this.enderecoCliente = enderecoCliente;
        this.cepCliente = cepCliente;
        this.cidadeCliente = cidadeCliente;
        this.estadoCliente = estadoCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getPrimeiroNomeCliente() {
        return primeiroNomeCliente;
    }

    public void setPrimeiroNomeCliente(String primeiroNomeCliente) {
        this.primeiroNomeCliente = primeiroNomeCliente;
    }

    public String getSegundoNomeCliente() {
        return segundoNomeCliente;
    }

    public void setSegundoNomeCliente(String segundoNomeCliente) {
        this.segundoNomeCliente = segundoNomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public Date getDataNascimentoCliente() {
        return dataNascimentoCliente;
    }

    public void setDataNascimentoCliente(Date dataNascimentoCliente) {
        this.dataNascimentoCliente = dataNascimentoCliente;
    }

    public String getSexoCliente() {
        return sexoCliente;
    }

    public void setSexoCliente(String sexoCliente) {
        this.sexoCliente = sexoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    public String getCidadeCliente() {
        return cidadeCliente;
    }

    public void setCidadeCliente(String cidadeCliente) {
        this.cidadeCliente = cidadeCliente;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    
    
    
}
