package br.com.zupacademy.gabrielaviana.casadocodigo.livro;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.zupacademy.gabrielaviana.casadocodigo.autor.Autor;
import br.com.zupacademy.gabrielaviana.casadocodigo.categoria.Categoria;
import br.com.zupacademy.gabrielaviana.casadocodigo.compartilhado.UniqueValue;

public class NovoLivroForm {

	
	@NotBlank	
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	@NotBlank
	private String sumario;
	
	@NotNull
	@Min(value = 20)
	private BigDecimal preco;
	
	@NotBlank
	@Min(value = 100)
	private String numeroPag;
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	
	@NotNull
	@Future
	@JsonIgnoreProperties(value = {"dataPublicacao"}, ignoreUnknown = true, allowSetters = true)
	//@JsonFormat(pattern="dd/MM/yyyy", shape = JsonFormat.Shape.STRING)	
	private Date dataPublicacao;

	@NotNull
	@ManyToOne	
	private Long idCategoria;
	
	@NotNull
	@ManyToOne
	private Long idAutor;
	
	//Getters
	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getNumeroPag() {
		return numeroPag;
	}

	public String getIsbn() {
		return isbn;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	
	public Long getIdCategoria() {
		return idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}
	

	//Constructors
	
	public NovoLivroForm(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotBlank @Min(100) String numeroPag, @NotBlank String isbn,
			@NotNull @Future @NotNull @Future Date dataPublicacao, @NotNull Long idCategoria, @NotNull Long idAutor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPag = numeroPag;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	public Livro toModel(EntityManager em) {	
		
		Autor autor = em.find(Autor.class, this.idAutor);
		Categoria categoria = em.find(Categoria.class, this.idCategoria);
		
		return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPag, this.isbn, this.dataPublicacao, autor, categoria);
	
	}
	
	//setter para a data
	public void setDataPublicacao(Date dataPublicacao){
		this.dataPublicacao = dataPublicacao;
	}

	
}
