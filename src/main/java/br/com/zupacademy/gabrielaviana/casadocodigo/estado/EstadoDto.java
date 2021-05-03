package br.com.zupacademy.gabrielaviana.casadocodigo.estado;

public class EstadoDto {

	private String nomeEstado;
	
	//Getter	
	public String getNomeEstado() {
		return nomeEstado;
	}
	
	//Constructor
	public EstadoDto(Estado estado) {
		this.nomeEstado = estado.getNome();
	}
		
}
