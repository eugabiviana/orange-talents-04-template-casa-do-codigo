package br.com.zupacademy.gabrielaviana.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.zupacademy.gabrielaviana.casadocodigo.compartilhado.UniqueValue;


public class NovoAutorForm {
	
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@UniqueValue(domainClass = Autor.class, fieldName = "email")//essa condição é colocada no request, para que já saiba da restrição
	private String email;
	@NotBlank
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
	public String getEmail() {
		return this.email;
	}

}
