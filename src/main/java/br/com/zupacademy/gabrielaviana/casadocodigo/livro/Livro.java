package br.com.zupacademy.gabrielaviana.casadocodigo.livro;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.gabrielaviana.casadocodigo.autor.Autor;
import br.com.zupacademy.gabrielaviana.casadocodigo.categoria.Categoria;


@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank	
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
	private String isbn;
	
	@NotNull
	@Future
	@JsonIgnoreProperties(value = {"dataPublicacao"}, ignoreUnknown = true, allowSetters = true)
	@JsonFormat(pattern="dd/MM/yyyy", shape = Shape.STRING)	
	private Date dataPublicacao;
	
	
	//Relação entre tabelas
	@NotNull
	@ManyToOne //um autor pode ter vários livros
	private Autor autor;
	
	@NotNull
	@ManyToOne //um livro pode pertencer a mais de uma categoria. ex.: um romance de mitologia, também entra em história.
	private Categoria categoria;
	
	
	//Constructor	
	@Deprecated
	public Livro() {
		
	}	

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotBlank @Min(100) String numeroPag, @NotBlank String isbn,
			@Future @NotNull @Future Date dataPublicacao2, @NotNull Autor autor, @NotNull Categoria categoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPag = numeroPag;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao2;
		this.autor = autor;
		this.categoria = categoria;
	}

	
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

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Long getId() {
		return id;
	}

	//setter para a data
		public void setDataPublicacao(Date dataPublicacao){
			this.dataPublicacao = dataPublicacao;
		}
}
