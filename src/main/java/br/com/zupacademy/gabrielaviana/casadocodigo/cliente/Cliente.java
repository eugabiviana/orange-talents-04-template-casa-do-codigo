package br.com.zupacademy.gabrielaviana.casadocodigo.cliente;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.gabrielaviana.casadocodigo.estado.Estado;
import br.com.zupacademy.gabrielaviana.casadocodigo.pais.Pais;
import com.sun.istack.NotNull;


import javax.persistence.Entity;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    @NotNull
    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;



    @Deprecated
    public Cliente() {

    }

    //construtores
    public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                        @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                        @NotBlank String cidade, Pais pais, @NotBlank String telefone,
                        @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;


//getters

    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    //----------------- setter necessário paro estado ----///
    public void setEstado(Estado estado) {
        this.estado = estado;

    }

}
