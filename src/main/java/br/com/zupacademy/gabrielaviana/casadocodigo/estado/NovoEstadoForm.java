package br.com.zupacademy.gabrielaviana.casadocodigo.estado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gabrielaviana.casadocodigo.compartilhado.UniqueValue;
import br.com.zupacademy.gabrielaviana.casadocodigo.pais.Pais;

public class NovoEstadoForm {

	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nomeEstado")
	private String nomeEstado;
	
	@NotNull
	//@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	//Getters
	public String getNomeEstado() {
		return nomeEstado;
	}
		
	public Long getIdPais() {
		return idPais;
	}

	//Constructors
	public NovoEstadoForm(@NotBlank String nomeEstado, @NotNull Long idPais) {
		this.nomeEstado = nomeEstado;
		this.idPais = idPais;
	}
	
	public Estado toModel(EntityManager em) {
		Pais pais = em.find(Pais.class, this.idPais);
		return new Estado(this.nomeEstado, pais);
	}
}
