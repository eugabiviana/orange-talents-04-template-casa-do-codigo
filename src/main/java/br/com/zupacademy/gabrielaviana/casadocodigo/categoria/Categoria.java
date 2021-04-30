package br.com.zupacademy.gabrielaviana.casadocodigo.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.gabrielaviana.casadocodigo.compartilhado.UniqueValue;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank	
	private String nome;
	

	//Getters
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	
	//Constructors
		@Deprecated
		public Categoria() {
			
		}
	
	public Categoria(@NotBlank String nome) {
		this.nome = nome;
	}
		
}
