package modelo;

import java.sql.Date;

public class Categoria {
	private int idCategoria;
	private String nomeCategoria;
	private String descricao;
	private int dataDia;
	private int dataMes;
	private int dataAno;
	
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getDataDia() {
		return dataDia;
	}
	public void setDataDia(int dataDia) {
		this.dataDia = dataDia;
	}
	public int getDataMes() {
		return dataMes;
	}
	public void setDataMes(int dataMes) {
		this.dataMes = dataMes;
	}
	public int getDataAno() {
		return dataAno;
	}
	public void setDataAno(int dataAno) {
		this.dataAno = dataAno;
	}
	


}
