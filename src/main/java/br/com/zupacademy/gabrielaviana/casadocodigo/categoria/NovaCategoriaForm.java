package br.com.zupacademy.gabrielaviana.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.gabrielaviana.casadocodigo.autor.Autor;

public class NovaCategoriaForm {

	@NotBlank
	private String nome;

	//Getter
	public String getNome() {
		return nome;
	}

	//Constructor
	@Deprecated
	public NovaCategoriaForm() {
		
	}
	
	public NovaCategoriaForm(@JsonProperty("nome") @NotBlank String nome) {
		this.nome = nome;
	}
		
	//Constructor - converte os dados passados no form para o sistema Autor
		public Categoria toModel() {		
			return new Categoria(this.nome);
		
		}
				
}
