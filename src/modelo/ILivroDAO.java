package modelo;

import java.util.ArrayList;

public interface ILivroDAO {

	public boolean cadastrarLivro(Livro l);

	public boolean alterarLivro(Livro l, Long isbn, String titulo, String editora, int nrEdicao, int anoLancamento);

	public boolean deletarLivro(Livro l, Long isbn);

	public ArrayList<Livro> listarLivros();

}
