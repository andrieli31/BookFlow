package controle;

import java.sql.Date;
import java.util.ArrayList;

import modelo.Categoria;
import modelo.ICategoriaDAO;
import modelo.Livro;

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
	public boolean alterarCategoria(Categoria c) {
		for (Categoria categoria : tabelaCategorias) {
			if (categoria.getIdCategoria() == c.getIdCategoria()) {

				categoria.setNomeCategoria(c.getNomeCategoria());
				categoria.setGenero(c.getGenero());
				categoria.setQuantPaginas(c.getQuantPaginas());
				categoria.setIdioma(c.getIdioma());
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
	
	public Categoria buscarCategoriaPorID(int id) {
		for (Categoria categoria : tabelaCategorias) {
			if (categoria.getIdCategoria() == id) {
				return categoria;
			}
		}

		return null;
	}


}
