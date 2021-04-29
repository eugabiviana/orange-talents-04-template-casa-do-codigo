package br.com.zupacademy.gabrielaviana.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.gabrielaviana.casadocodigo.compartilhado.UniqueValue;


public class NovaCategoriaForm {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
		private String nome;

	//Getter
	public String getNome() {
		return nome;
	}

	//Constructor
	@Deprecated
	public NovaCategoriaForm() {
		
	}
	
	//Essa anotação do Json, é para corrigir um bug do Java que não cria um objeto com apenas uma variável, nesse caso, apenas o nome 
	public NovaCategoriaForm(@JsonProperty("nome") @NotBlank String nome) {
		this.nome = nome;
	}
		
	//Constructor - converte os dados passados no form para o sistema Autor
		public Categoria toModel() {		
			return new Categoria(this.nome);
		
		}
				
}
