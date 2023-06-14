package modelo;

import java.util.ArrayList;

public class Livro {

	private Long isbn;
	private String titulo;
	private String editora;
	private int nrEdicao;
	private int anoLancamento;
	private String autor;


	

	public Long getIsbn() {
		return isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getNrEdicao() {
		return nrEdicao;
	}

	public void setNrEdicao(int nrEdicao) {
		this.nrEdicao = nrEdicao;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

}
