package modelo;

import java.sql.Date;

public class Categoria {
	private int idCategoria;
	private String nomeCategoria;
	private String idioma;
	private int quantPaginas;
	private String genero;
	

	
	
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public int getQuantPaginas() {
		return quantPaginas;
	}
	public void setQuantPaginas(int quantPaginas) {
		this.quantPaginas = quantPaginas;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}



}
