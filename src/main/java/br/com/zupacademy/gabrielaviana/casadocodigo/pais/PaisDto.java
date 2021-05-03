package br.com.zupacademy.gabrielaviana.casadocodigo.pais;

public class PaisDto {

	private String nome;
	private Long idEstado;
	
	//Getters
	public String getNome() {
		return nome;
	}
	public Long getIdEstado() {
		return idEstado;
	}
	
	//Constructor
	public PaisDto(Pais pais) {
		this.nome = pais.getNome();		
	}	
	
}
