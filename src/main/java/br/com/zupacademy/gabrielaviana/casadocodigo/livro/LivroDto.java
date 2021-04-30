package br.com.zupacademy.gabrielaviana.casadocodigo.livro;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class LivroDto {

	private Long id;
	private String titulo;	
	private String resumo;	
	private String sumario;
	private BigDecimal preco;
	private String numeroPag;
	private String isbn;
	@JsonFormat
	private Date dataPublicacao;
	private Long idAutor;
	private Long idCategoria;
	
	//Constructors
	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo(); 
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPag = livro.getNumeroPag();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		
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
	
	public Long getId() {
		return id;
	}
	public Long getIdAutor() {
		return idAutor;
	}
	public Long getIdCategoria() {
		return idCategoria;
	}		
	
	//setter para a data
		public void setDataPublicacao(Date dataPublicacao){
			this.dataPublicacao = dataPublicacao;
		}
}
