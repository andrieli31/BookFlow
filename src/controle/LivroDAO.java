package controle;

import java.util.ArrayList;

import modelo.ILivroDAO;
import modelo.Livro;

public class LivroDAO implements ILivroDAO {

	private static ArrayList<Livro> tabelaLivros;
	private static LivroDAO instancia;

	private LivroDAO() {

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

	public boolean alterarLivro(Livro l, Long isbn, String titulo, String editora, int nrEdicao, int anoLancamento) {
		for (Livro livro : tabelaLivros) {
			if (livro.getIsbn() == isbn) {
				livro.setIsbn(isbn);
				livro.setEditora(editora);
				livro.setNrEdicao(nrEdicao);
				livro.setTitulo(titulo);
				livro.setAnoLancamento(anoLancamento);

				return true;
			}
		}

		return false;
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
		if(!tabelaLivros.isEmpty()) {
			return this.tabelaLivros;
			
		}
		return null;
	}

}
