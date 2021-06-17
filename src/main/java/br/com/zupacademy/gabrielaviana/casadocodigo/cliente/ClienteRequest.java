package br.com.zupacademy.gabrielaviana.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.gabrielaviana.casadocodigo.compartilhado.CpfOrCnpj;
import br.com.zupacademy.gabrielaviana.casadocodigo.compartilhado.ExistsId;
import br.com.zupacademy.gabrielaviana.casadocodigo.estado.Estado;
import br.com.zupacademy.gabrielaviana.casadocodigo.pais.Pais;
import org.springframework.util.Assert;


public class ClienteRequest {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;

    @NotBlank
    @CpfOrCnpj
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

    @ExistsId(domainClass= Pais.class,fieldName="id", message="Id Inexistente!")
    private Long idPais;
    private Long idEstado;

    public ClienteRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                             @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                             @NotBlank String cidade, @NotBlank String telefone, @NotBlank String cep, Long idPais, Long idEstado) {

        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.idPais = idPais;
        this.idEstado = idEstado;
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

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }


    public Cliente toModel(EntityManager emt) {
        Pais pais = emt.find(Pais.class, idPais);
        Estado estado = emt.find(Estado.class, this.idEstado);

        Assert.state(pais != null, "País é um campo obrigatório!");

        Cliente cliente = new  Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);
        if(estado != null ) cliente.setEstado(estado);

        return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);
    }
}
