package modelo;

import java.sql.Date;
import java.util.ArrayList;

public interface ICategoriaDAO {

	public boolean cadastarCategoria(Categoria c);

	public boolean alterarCategoria(Categoria c,int idCategoria, String nomeCategoria, String descricao, int dataMes, int dataAno, int dataDia);
	
	public boolean deletarCategoria(Categoria  c, int idCategoria);
	
	public ArrayList<Categoria> listarCategorias();

}
