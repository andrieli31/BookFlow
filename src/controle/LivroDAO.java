package controle;

import java.util.ArrayList;

import modelo.ILivroDAO;
import modelo.Livro;

public class LivroDAO implements ILivroDAO {

	private static ArrayList<Livro> tabelaLivros;
	private static LivroDAO instancia;

	public LivroDAO() {

	}

	public static LivroDAO getInstancia() {

		if (instancia == null) {
			instancia = new LivroDAO();
			tabelaLivros = new ArrayList<>();
		}
		return instancia;
	}

	@Override
	public boolean cadastrarLivro(Livro l) {
		if (l != null) {
			tabelaLivros.add(l);
			return true;
		}

		return false;
	}

	public boolean alterarLivro(Livro l) {
		for (Livro livro : tabelaLivros) {
			if (livro.getIsbn() == l.getIsbn()) {
				livro.setEditora(l.getEditora());
				livro.setNrEdicao(l.getNrEdicao());
				livro.setTitulo(l.getTitulo());
				livro.setAnoLancamento(l.getAnoLancamento());
				return true;
			}
		}

		return false;
	}

	public Livro buscarLivroPorIsbn(long isbn) {
		for (Livro livro : tabelaLivros) {
			if (livro.getIsbn() == isbn) {
				return livro;
			}
		}

		return null;
	}

	public boolean deletarLivro(Livro l, Long isbn) {

		for (Livro livro : tabelaLivros) {
			if (livro.getIsbn() == isbn) {
				tabelaLivros.remove(livro);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Livro> listarLivros() {
		return tabelaLivros;
	}

}
