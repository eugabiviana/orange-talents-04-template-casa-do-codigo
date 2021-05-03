package br.com.zupacademy.gabrielaviana.casadocodigo.pais;


import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.gabrielaviana.casadocodigo.compartilhado.UniqueValue;

public class NovoPaisForm {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
			
	//Getters
	public String getNome() {
		return nome;
	}
	

	//Constructors	
	public NovoPaisForm(@NotBlank @JsonProperty("nome") String nome) {
		this.nome = nome;		
	}
		
	public Pais toModel() {
		return new Pais(this.nome);
	}
	
}
