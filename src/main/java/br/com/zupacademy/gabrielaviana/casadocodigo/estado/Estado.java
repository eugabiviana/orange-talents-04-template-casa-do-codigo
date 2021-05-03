package br.com.zupacademy.gabrielaviana.casadocodigo.estado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gabrielaviana.casadocodigo.pais.Pais;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nomeEstado;
	
	@NotNull
	@ManyToOne
	Pais pais;
	
	//Getters
	public String getNome() {
		return nomeEstado;
	}

	public Pais getPais() {
		return pais;
	}
	
	//Constructors
	@Deprecated
	public Estado() {
		
	}

	public Estado(String nomeEstado, @NotNull Pais pais) {
		this.nomeEstado = nomeEstado;
		this.pais = pais;
	}
	
	
}
