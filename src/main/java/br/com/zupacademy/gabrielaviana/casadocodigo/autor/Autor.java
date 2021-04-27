package br.com.zupacademy.gabrielaviana.casadocodigo.autor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;



@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nome;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Size (max = 400)
	private String descricao;
	
	private LocalDateTime instante = LocalDateTime.now();
	
	//Getters
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getDescricao() {
		return descricao;
	}
	public LocalDateTime getDataCriacao() {
		return instante;
	}
	
	
	//Constructors
	@Deprecated
	public Autor() {
		
	}
	
	public Autor(@NotEmpty String nome, @NotEmpty @Email String email,
			@NotEmpty @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;	
		this.instante = LocalDateTime.now();
	}	
	
}
