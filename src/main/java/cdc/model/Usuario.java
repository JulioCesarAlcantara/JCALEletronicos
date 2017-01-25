package cdc.model;

import java.sql.Date;


public class Usuario {
    
    private Integer id; 
    private String nome; 
    private String email; 
    private String telefone; 
    private Date dataNascimento; 
    private String sexo; 
    private String tipo; 
    private String senha; 
    private String cpf; 
    private String endereco; 
    private String cep; 
    private String cidade; 
    private String estado;

    public Usuario() {
    }

    public Usuario(String nome, String email, String telefone, Date dataNascimento, String sexo, String tipo, String senha, String cpf, String endereco, String cep, String cidade, String estado) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.tipo = tipo;
        this.senha = senha;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}
