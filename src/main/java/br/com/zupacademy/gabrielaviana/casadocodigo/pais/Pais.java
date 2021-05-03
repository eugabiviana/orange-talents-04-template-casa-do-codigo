package br.com.zupacademy.gabrielaviana.casadocodigo.pais;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Pais {

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
	public Pais() {
		
	}
		
	public Pais(@NotBlank String nome) {
		this.nome = nome;
		
	}
			
	
}
