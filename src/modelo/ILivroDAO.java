package modelo;

import java.util.ArrayList;

public interface ILivroDAO {

	public boolean cadastrarLivro(Livro l);

	public boolean alterarLivro(Livro l);

	public boolean deletarLivro(Livro l, Long isbn);

	public ArrayList<Livro> listarLivros();
	
	public Livro buscarLivroPorIsbn(long isbn);

}
