package br.com.zupacademy.gabrielaviana.casadocodigo.categoria;

public class CategoriaDto {

	private String nome;

	//Getter
	public String getNome() {
		return nome;
	}

	//Constructor
	public CategoriaDto(Categoria categoria) {
		this.nome = categoria.getNome();
	}
	
	
	
}
