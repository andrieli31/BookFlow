package controle;

import java.sql.Date;
import java.util.ArrayList;

import modelo.Categoria;
import modelo.ICategoriaDAO;

public class CategoriaDAO implements ICategoriaDAO {

	private static ArrayList<Categoria> tabelaCategorias;
	private static CategoriaDAO instancia;

	public CategoriaDAO() {

	}

	public static CategoriaDAO getInstancia() {
		if (instancia == null) {
			instancia = new CategoriaDAO();
			tabelaCategorias = new ArrayList<>();
		}
		return instancia;

	}

	@Override
	public boolean cadastarCategoria(Categoria c) {
		if (c != null) {
			tabelaCategorias.add(c);
			return true;
		}

		return false;
	}

	@Override
	public boolean alterarCategoria(Categoria c, int idCategoria, String nomeCategoria, String descricao,
			Date dataCriacao) {
		for (Categoria categoria : tabelaCategorias) {
			if (categoria.getIdCategoria() == idCategoria) {
				categoria.setNomeCategoria(nomeCategoria);
				categoria.setDataCriacao(dataCriacao);
				categoria.setDescricao(descricao);
				categoria.setIdCategoria(idCategoria);

				return true;
			}
		}

		return false;
	}

	@Override
	public boolean deletarCategoria(Categoria c, int idCategoria) {

		for (Categoria categoria : tabelaCategorias) {
			if (categoria.getIdCategoria() == idCategoria) {
				tabelaCategorias.remove(categoria);
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Categoria> listarCategorias() {
		if (!tabelaCategorias.isEmpty()) {
			return this.tabelaCategorias;
		}
		return null;
	}

}
