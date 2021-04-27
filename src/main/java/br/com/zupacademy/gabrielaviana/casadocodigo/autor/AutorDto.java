package br.com.zupacademy.gabrielaviana.casadocodigo.autor;

public class AutorDto {

	//AutorDto é os atributos obrigatorios que irão ser informados na Autor
	//AutorDto exige as anotações ( porque precisa validar as informações que vai receber antes de enviar pro banco de dados)
	//AutorDto é os atributos obrigatorios que irão ser informados na Autor
	//AutorDto exige as anotações ( porque precisa validar as informações que vai receber antes de enviar pro banco de dados)
	
	private Long id;	
	private String nome;	
	private String descricao;
	
	//Constructors
	public AutorDto(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}
	
	
	//Getters
	public String getNome() {
		return nome;
	}	
	
	public String getDescricao() {
		return descricao;
	}

	public Long getId() {
		return id;
	}

}
