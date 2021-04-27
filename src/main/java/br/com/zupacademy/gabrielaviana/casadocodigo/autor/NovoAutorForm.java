package br.com.zupacademy.gabrielaviana.casadocodigo.autor;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class NovoAutorForm {
	
	@NotEmpty
	private String nome;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Size (max = 400)
	private String descricao;
		
	//Constructors
	public NovoAutorForm(@NotEmpty String nome, @NotEmpty @Email String email,
			@NotEmpty @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	//Constructor - converte os dados passados no form para o sistema Autor
	public Autor toModel() {		
		return new Autor(nome, email, descricao);
	
	}

}
